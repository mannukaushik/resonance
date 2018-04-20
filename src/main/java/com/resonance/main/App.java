package com.resonance.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(scanBasePackages= {"com.resonance.controllers.impl","com.resonance.controllers", "com.resonance.configuration", "com.resonance.service.processor.impl","com.resonance.data.configuration","com.resonance.helper", "com.resonance.helper.generic", "com.resonance.api.elements", "com.resonance.api.tests"}, exclude={MongoAutoConfiguration.class})
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
