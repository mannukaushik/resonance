package com.resonance.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.resonance.entities.User;

public interface UserRepository extends MongoRepository<User,Long> {
	 User findByUsername(String username);
}
