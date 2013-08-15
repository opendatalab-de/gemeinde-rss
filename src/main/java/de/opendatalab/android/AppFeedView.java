package de.opendatalab.android;

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

import de.opendatalab.gemeinde.rss.data.AppAndroid;

@Component
public class AppFeedView extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
		feed.setTitle("Hochzeit Android Apps");
		feed.setDescription("Neue Hochzeit Apps");
		feed.setLink("http://gemeinde-rss.grundid.de/appAndroid/rss");
		feed.setTtl(24 * 60);
	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Collection<AppAndroid> gemeindeItems = (Collection<AppAndroid>)model.get("items");
		List<Item> items = new ArrayList<Item>(gemeindeItems.size());
		for (AppAndroid appAndroid : gemeindeItems) {
			Item item = new Item();
			Description description = new Description();
			description.setValue(appAndroid.getDescription());
			item.setDescription(description);
			item.setTitle(appAndroid.getTitle());
			item.setLink(appAndroid.getLink());
			item.setPubDate(appAndroid.getPubDate());
			if (hasText(appAndroid.getAuthor()))
				item.setAuthor(appAndroid.getAuthor());
			Guid guid = new Guid();
			guid.setValue(appAndroid.getGuid());
			item.setGuid(guid);
			items.add(item);
		}
		return items;
	}
}
