package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.repository.AllocationRepository;
import com.dchristofolli.checkpoint.v1.dto.ProjectAllocationRequestDto;
import org.springframework.stereotype.Service;

import static com.dchristofolli.checkpoint.v1.mapper.AllocationMapper.mapToEntity;

@Service

public class AllocationService {
    private AllocationRepository allocationRepository;
    private TimeService timeService;

    public void allocateHour(ProjectAllocationRequestDto dto) {
        timeService.hoursWorkedInTheDay();
        allocationRepository.save(mapToEntity(dto));
    }
}
