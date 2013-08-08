package de.opendatalab.gemeinde.rss.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RssFeedRepository extends MongoRepository<RssFeed, String> {
}
