package de.opendatalab.gemeinde.rss.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetaDataRepository extends MongoRepository<MetaData, String> {
}
