package com.resonance.data.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.resonance.entities.OverviewTo;

public interface OverviewRepository extends MongoRepository<OverviewTo, String> {

	@Query("{'modelName': ?0}")
	public OverviewTo findUnique(String modelName);
	
	@Query(value="{}")
	public Page<OverviewTo> findPagedList(Pageable pageable);


}
