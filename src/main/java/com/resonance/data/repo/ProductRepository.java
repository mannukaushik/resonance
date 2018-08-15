package com.resonance.data.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.resonance.entities.ProductTo;

public interface ProductRepository extends MongoRepository<ProductTo, String> {

	@Query("{'modelName': ?0}")
	public ProductTo findUnique(String modelName);
	
	@Query("{'type': ?0}")
	public List<ProductTo> findUniqueType(String type);

}
