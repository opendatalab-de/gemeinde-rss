package de.opendatalab.gemeinde.rss.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "app.android")
@TypeAlias("AppAndroid")
public class AppAndroid extends BaseItem {

	@Id
	private String appAndroidId;

	public String getAppAndroidId() {
		return appAndroidId;
	}

	public void setAppAndroidId(String appAndroidId) {
		this.appAndroidId = appAndroidId;
	}
}
