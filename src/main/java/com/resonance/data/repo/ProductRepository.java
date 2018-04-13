package com.resonance.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.resonance.entities.ProductTo;

public interface ProductRepository extends MongoRepository<ProductTo, String>{

}
