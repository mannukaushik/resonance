package com.resonance.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.resonance.entities.ProductTo;

public interface ProductRepository extends MongoRepository<ProductTo, String>{

	@Query("{'modelName': ?0}")
	public ProductTo findUnique(String modelName);

}
