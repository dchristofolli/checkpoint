package com.dchristofolli.checkpoint.v1.mapper;

import com.dchristofolli.checkpoint.domain.model.AllocationEntity;
import com.dchristofolli.checkpoint.v1.dto.ProjectAllocationRequestDto;

public class AllocationMapper {
    public static AllocationEntity mapToEntity(ProjectAllocationRequestDto dto) {
        return new AllocationEntity(
            null,
            dto.getEmployeeCpf(),
            dto.getProjectEnum(),
            dto.getDate(),
            dto.getAllocationTime());
    }
}
