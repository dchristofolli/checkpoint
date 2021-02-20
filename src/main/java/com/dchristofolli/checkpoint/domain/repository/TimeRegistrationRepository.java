package com.dchristofolli.checkpoint.domain.repository;

import com.dchristofolli.checkpoint.domain.model.TimeRegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRegistrationRepository extends MongoRepository<TimeRegistrationEntity, String> {
}
