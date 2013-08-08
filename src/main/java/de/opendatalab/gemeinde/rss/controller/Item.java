package de.opendatalab.gemeinde.rss.controller;

import de.opendatalab.gemeinde.rss.data.RssFeed;

public class Item implements Comparable<Item> {

	private String gemeinde;
	private RssFeed rssFeed;

	public Item(String gemeinde, RssFeed rssFeed) {
		this.gemeinde = gemeinde;
		this.rssFeed = rssFeed;
	}

	public String getGemeinde() {
		return gemeinde;
	}

	public RssFeed getRssFeed() {
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
					c = rssFeed.getRssFeedId().compareTo(o.rssFeed.getRssFeedId());
				}
			}
		}
		return c;
	}
}
