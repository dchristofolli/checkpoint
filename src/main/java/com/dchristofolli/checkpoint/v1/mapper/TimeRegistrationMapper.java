package com.dchristofolli.checkpoint.v1.mapper;

import com.dchristofolli.checkpoint.domain.model.TimeRegistrationEntity;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationResponseDto;

public class TimeRegistrationMapper {
    private TimeRegistrationMapper() {
    }

    public static TimeRegistrationResponseDto mapToResponse(TimeRegistrationEntity entity) {
        return new TimeRegistrationResponseDto(
            entity.getEmployeeCpf(),
            entity.getTime().toLocalDate() + " " + entity.getTime().plusHours(3).toLocalTime());
    }
}
