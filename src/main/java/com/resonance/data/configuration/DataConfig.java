package com.resonance.data.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Configuration
@Component
@PropertySource(value = { "classpath:application.properties" })
@EnableMongoRepositories(basePackages = { "com.resonance.data.repo" })
public class DataConfig extends AbstractMongoConfiguration{

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;


	@Override
	protected String getDatabaseName() {
		return database;
	}


	@Override
	public MongoClient mongoClient() {
		return new MongoClient(mongoUri);
	}

}