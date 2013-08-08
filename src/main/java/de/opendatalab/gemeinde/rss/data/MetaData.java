package de.opendatalab.gemeinde.rss.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gemeinde.metadata")
@TypeAlias("MetaData")
public class MetaData {

	@Id
	private String metaDataId;
	private String name;
	private String url;
	private String feed;
	private String rss;
	private String email;
	private String rs;
	private String des;
	private int ewzM;
	private int ewzW;
	private double shapeArea;

	public String getMetaDataId() {
		return metaDataId;
	}

	public void setMetaDataId(String metaDataId) {
		this.metaDataId = metaDataId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getRss() {
		return rss;
	}

	public void setRss(String rss) {
		this.rss = rss;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getEwzM() {
		return ewzM;
	}

	public void setEwzM(int ewzM) {
		this.ewzM = ewzM;
	}

	public int getEwzW() {
		return ewzW;
	}

	public void setEwzW(int ewzW) {
		this.ewzW = ewzW;
	}

	public double getShapeArea() {
		return shapeArea;
	}

	public void setShapeArea(double shapeArea) {
		this.shapeArea = shapeArea;
	}
}
