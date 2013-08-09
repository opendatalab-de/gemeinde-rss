package de.opendatalab.gemeinde.rss.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.opendatalab.gemeinde.rss.data.MetaData;
import de.opendatalab.gemeinde.rss.data.MetaDataRepository;
import de.opendatalab.gemeinde.rss.data.NewsItem;
import de.opendatalab.gemeinde.rss.data.NewsItemRepository;

@Controller
public class IndexController {

	@Autowired
	private MetaDataRepository metaDataRepository;
	@Autowired
	private NewsItemRepository newsItemRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView get() {
		Collection<Item> items = new TreeSet<>();
		Map<String, MetaData> gemeindeMap = getGemeindeMap();
		List<NewsItem> allItems = newsItemRepository.findAll();
		for (NewsItem newsItem : allItems) {
			MetaData metaData = gemeindeMap.get(newsItem.getMetaDataId());
			items.add(new Item(metaData.getName(), newsItem));
		}
		return new ModelAndView("index", "items", items);
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
