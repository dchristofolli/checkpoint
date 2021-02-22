package com.dchristofolli.checkpoint.domain.repository;

import com.dchristofolli.checkpoint.domain.model.AllocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends MongoRepository<AllocationEntity, String> {
}
