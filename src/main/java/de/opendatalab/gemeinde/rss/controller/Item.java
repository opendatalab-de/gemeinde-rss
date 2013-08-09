package de.opendatalab.gemeinde.rss.controller;

import de.opendatalab.gemeinde.rss.data.NewsItem;

public class Item implements Comparable<Item> {

	private String gemeinde;
	private NewsItem rssFeed;

	public Item(String gemeinde, NewsItem rssFeed) {
		this.gemeinde = gemeinde;
		this.rssFeed = rssFeed;
	}

	public String getGemeinde() {
		return gemeinde;
	}

	public NewsItem getRssFeed() {
		return rssFeed;
	}

	@Override
	public int compareTo(Item o) {
		int c = o.rssFeed.getPubDate().compareTo(rssFeed.getPubDate());
		if (c == 0) {
			c = gemeinde.compareTo(o.gemeinde);
			if (c == 0) {
				c = rssFeed.getTitle().compareTo(o.rssFeed.getTitle());
				if (c == 0) {
					c = rssFeed.getNewsItemId().compareTo(o.rssFeed.getNewsItemId());
				}
			}
		}
		return c;
	}
}
