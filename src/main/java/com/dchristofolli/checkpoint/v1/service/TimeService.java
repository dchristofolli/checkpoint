package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.model.TimeRegistrationEntity;
import com.dchristofolli.checkpoint.domain.repository.TimeRegistrationRepository;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationResponseDto;
import com.dchristofolli.checkpoint.v1.mapper.TimeRegistrationMapper;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.dchristofolli.checkpoint.v1.mapper.TimeRegistrationMapper.mapToResponse;

@Service
public class TimeService {
    private final TimeRegistrationRepository timeRegistrationRepository;
    private final Logger log = LoggerFactory.getLogger("Time Service");

    public TimeService(TimeRegistrationRepository timeRegistrationRepository) {
        this.timeRegistrationRepository = timeRegistrationRepository;
    }

    public TimeRegistrationResponseDto timeRegistration(TimeRegistrationRequestDto dto) {
        TimeRegistrationEntity entity;
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");
        if (dto.getTime() == null) {
            LocalDateTime now = LocalDateTime.now().minusHours(3);
            entity = new TimeRegistrationEntity(dto.getEmployeeCpf(), now);
        }
        else
            entity = new TimeRegistrationEntity(dto.getEmployeeCpf(),
                LocalDateTime.parse(dto.getTime(), formatter).minusHours(3));
        log.info(dto.getDayPeriodEnum().toString());
        return mapToResponse(timeRegistrationRepository.save(entity));
    }
}
