package de.opendatalab.gemeinde.rss.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
@PropertySource("classpath:/config.properties")
@EnableMongoRepositories(basePackages = "de.opendatalab.gemeinde.rss")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Value("${mongo.db}")
	private String mongoDb;
	@Value("${mongo.host}")
	private String host;

	@Override
	protected String getDatabaseName() {
		return mongoDb;
	}

	@Override
	protected String getMappingBasePackage() {
		return "de.opendatalab.gemeinde.rss";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		MongoFactoryBean mongoFactory = new MongoFactoryBean();
		mongoFactory.setHost(host);
		mongoFactory.afterPropertiesSet();
		Mongo mongo = mongoFactory.getObject();
		return mongo;
	}

	@Override
	@Bean
	public CustomConversions customConversions() {
		List<Converter<?, ?>> converterList = new ArrayList<>();
		return new CustomConversions(converterList);
	}

	@Override
	@Bean
	public MappingMongoConverter mappingMongoConverter() throws Exception {
		MappingMongoConverter converter = super.mappingMongoConverter();
		converter.setTypeMapper(new DefaultMongoTypeMapper(DefaultMongoTypeMapper.DEFAULT_TYPE_KEY,
				mongoMappingContext()));
		return converter;
	}

	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = super.mongoTemplate();
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
		return mongoTemplate;
	}
}
