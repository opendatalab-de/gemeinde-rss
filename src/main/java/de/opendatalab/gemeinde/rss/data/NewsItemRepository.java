package de.opendatalab.gemeinde.rss.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsItemRepository extends MongoRepository<NewsItem, String> {

	List<NewsItem> findByPubDateGreaterThan(Date date);
}
