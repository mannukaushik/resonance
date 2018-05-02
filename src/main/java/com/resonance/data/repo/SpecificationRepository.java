package com.resonance.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.resonance.entities.SpecTo;

public interface SpecificationRepository extends MongoRepository<SpecTo, String>{

	
}
