package de.opendatalab.gemeinde.rss.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gemeinde.newsitem")
@TypeAlias("RssFeed")
public class NewsItem {

	@Id
	private String newsItemId;
	private String metaDataId;
	private String title;
	private String link;
	private String author;
	private String description;
	private String guid;
	private Date pubDate;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
}
