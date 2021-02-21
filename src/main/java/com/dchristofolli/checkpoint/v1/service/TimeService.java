package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.model.TimeRegistrationEntity;
import com.dchristofolli.checkpoint.domain.repository.TimeRegistrationRepository;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationResponseDto;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;

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
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd-MM-yyyy");
        departureBeforeEntry(dto);
        if (dto.getTime() == null) {
            entity = actualDateTimeRegistration(dto);
        } else
            entity = new TimeRegistrationEntity(
                dto.getEmployeeCpf(),
                LocalDate.parse(dto.getDate(), dateFormat).toString(),
                LocalTime.parse(dto.getTime()).toString());
        return mapToResponse(timeRegistrationRepository.save(entity));
    }

    private TimeRegistrationEntity actualDateTimeRegistration(TimeRegistrationRequestDto dto) {
        TimeRegistrationEntity entity;
        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        entity = new TimeRegistrationEntity(
            dto.getEmployeeCpf(),
            today.toString(),
            nowTime.toString());
        return entity;
    }

    private void departureBeforeEntry(TimeRegistrationRequestDto dto) {
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd-MM-yyyy");
        boolean isBefore = timeRegistrationRepository
            .findAllByEmployeeCpfAndAndDate(
                dto.getEmployeeCpf(),
                LocalDate.parse(dto.getDate(), dateFormat).toString())
            .stream()
            .anyMatch(entity -> (LocalTime.parse(dto.getTime())).isBefore(LocalTime.parse(entity.getTime())));
        if (isBefore)
            throw new DateTimeException("Invalid record, the last record was made at {}" +
                ". Please, insert a time after {}");
    }
}
