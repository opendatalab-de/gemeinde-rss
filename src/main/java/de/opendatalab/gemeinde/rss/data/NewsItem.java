package de.opendatalab.gemeinde.rss.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gemeinde.newsitem")
@TypeAlias("RssFeed")
public class NewsItem extends BaseItem {

	@Id
	private String newsItemId;
	private String metaDataId;

	public String getNewsItemId() {
		return newsItemId;
	}

	public void setNewsItemId(String newsItemId) {
		this.newsItemId = newsItemId;
	}

	public String getMetaDataId() {
		return metaDataId;
	}

	public void setMetaDataId(String metaDataId) {
		this.metaDataId = metaDataId;
	}
}
