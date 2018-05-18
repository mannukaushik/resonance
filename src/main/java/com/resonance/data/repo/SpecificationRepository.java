package com.resonance.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.resonance.entities.SpecTo;

public interface SpecificationRepository extends MongoRepository<SpecTo, String>{

	@Query("{'modelName': ?0}")
	public SpecTo findUnique(String modelName);
	
}
