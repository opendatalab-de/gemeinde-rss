package de.opendatalab.gemeinde.rss;

import static org.springframework.util.StringUtils.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Guid;
import com.sun.syndication.feed.rss.Item;

import de.opendatalab.gemeinde.rss.data.NewsItem;

@Component
public class RssFeedView extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
		String gemeinde = (String)model.get("gemeinde");
		if (!hasText(gemeinde))
			gemeinde = "Gemeinde";
		feed.setTitle(gemeinde + " RSS Feed");
		feed.setDescription("Alle Nachrichten aus deiner Gemeinde und Umgebung");
		feed.setLink("http://gemeinde-rss.grundid.de/rss");
		feed.setTtl(24 * 60);
	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Collection<de.opendatalab.gemeinde.rss.controller.Item> gemeindeItems = (Collection<de.opendatalab.gemeinde.rss.controller.Item>)model
				.get("items");
		List<Item> items = new ArrayList<Item>(gemeindeItems.size());
		for (de.opendatalab.gemeinde.rss.controller.Item gemeindeNewsItem : gemeindeItems) {
			Item item = new Item();
			NewsItem newsItem = gemeindeNewsItem.getRssFeed();
			Description description = new Description();
			description.setValue(newsItem.getDescription());
			item.setDescription(description);
			item.setTitle(newsItem.getTitle());
			item.setLink(newsItem.getLink());
			item.setPubDate(newsItem.getPubDate());
			item.setAuthor(newsItem.getAuthor());
			Guid guid = new Guid();
			guid.setValue(newsItem.getGuid());
			item.setGuid(guid);
			items.add(item);
		}
		return items;
	}
}
