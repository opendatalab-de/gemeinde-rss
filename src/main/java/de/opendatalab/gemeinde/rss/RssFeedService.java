package de.opendatalab.gemeinde.rss;

import static org.springframework.util.StringUtils.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.opendatalab.gemeinde.rss.controller.Item;
import de.opendatalab.gemeinde.rss.data.MetaData;
import de.opendatalab.gemeinde.rss.data.MetaDataRepository;
import de.opendatalab.gemeinde.rss.data.NewsItem;
import de.opendatalab.gemeinde.rss.data.NewsItemRepository;

@Service
public class RssFeedService {

	@Autowired
	private MetaDataRepository metaDataRepository;
	@Autowired
	private NewsItemRepository newsItemRepository;

	public Collection<Item> getItems(String gemeinde) {
		Collection<Item> items = new TreeSet<>();
		Map<String, MetaData> gemeindeMap = getGemeindeMap();
		Date lastMonth = createLastMonth();
		List<NewsItem> allItems = newsItemRepository.findByPubDateGreaterThan(lastMonth);
		for (NewsItem newsItem : allItems) {
			MetaData metaData = gemeindeMap.get(newsItem.getMetaDataId());
			if (metaData != null) {
				if (!hasText(gemeinde) || gemeinde.equals(metaData.getName()))
					items.add(new Item(metaData.getName(), newsItem));
			}
		}
		return items;
	}

	private Date createLastMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -28);
		return c.getTime();
	}

	private Map<String, MetaData> getGemeindeMap() {
		Map<String, MetaData> result = new HashMap<>();
		List<MetaData> allGemeinden = metaDataRepository.findAll();
		for (MetaData metaData : allGemeinden) {
			result.put(metaData.getMetaDataId(), metaData);
		}
		return result;
	}
}
