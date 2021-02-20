package com.dchristofolli.checkpoint.domain.repository;

import com.dchristofolli.checkpoint.domain.model.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
}
