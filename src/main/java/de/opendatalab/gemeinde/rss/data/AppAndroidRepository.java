package de.opendatalab.gemeinde.rss.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppAndroidRepository extends MongoRepository<AppAndroid, String> {

	List<AppAndroid> findByPubDateGreaterThan(Date date);
}
