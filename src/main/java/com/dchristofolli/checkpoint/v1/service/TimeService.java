package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.model.TimeRegistrationEntity;
import com.dchristofolli.checkpoint.domain.repository.TimeRegistrationRepository;
import com.dchristofolli.checkpoint.exception.ApiException;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationResponseDto;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.List;
import java.util.stream.Collectors;

import static com.dchristofolli.checkpoint.v1.mapper.TimeRegistrationMapper.mapToResponse;

@Service
public class TimeService {
    private final TimeRegistrationRepository timeRegistrationRepository;
    private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd-MM-yyyy");
    private final Logger log = LoggerFactory.getLogger("Time Service");

    public TimeService(TimeRegistrationRepository timeRegistrationRepository) {
        this.timeRegistrationRepository = timeRegistrationRepository;
    }

    public TimeRegistrationResponseDto timeRegistration(TimeRegistrationRequestDto dto) {
        weekDayValidator(dto);
        TimeRegistrationEntity entity;
        intervalLessThanAnHour(dto);
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
        getLastRecordByEmployeeAndDate(dto);
        TimeRegistrationEntity entity;
        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        entity = new TimeRegistrationEntity(
            dto.getEmployeeCpf(),
            today.toString(),
            nowTime.toString());
        return entity;
    }

    private void intervalLessThanAnHour(TimeRegistrationRequestDto dto) {
        LocalTime lastRecord = getLastRecordByEmployeeAndDate(dto);
        boolean isBefore = getAllRegistriesByEmployeeAndDate(dto)
            .parallelStream()
            .anyMatch(time -> LocalTime.parse(dto.getTime()).isBefore(time.plusHours(1)));
        if (isBefore)
            throw new DateTimeException("Invalid record, the last record was made at " +
                lastRecord.toString().substring(0, 5) +
                ". Please, insert a time after " + lastRecord.plusHours(1).toString().substring(0, 5));
    }

    private LocalTime getLastRecordByEmployeeAndDate(TimeRegistrationRequestDto dto) {
        return getAllRegistriesByEmployeeAndDate(dto)
            .parallelStream()
            .max(LocalTime::compareTo)
            .orElseGet(() -> LocalTime.now().minusHours(8));
    }

    private List<LocalTime> getAllRegistriesByEmployeeAndDate(TimeRegistrationRequestDto dto) {
        return timeRegistrationRepository
            .findAllByEmployeeCpfAndAndDate(
                dto.getEmployeeCpf(),
                LocalDate.parse(dto.getDate(), dateFormat).toString())
            .parallelStream()
            .map(entity -> LocalTime.parse(entity.getTime()))
            .collect(Collectors.toList());
    }

    private void weekDayValidator(TimeRegistrationRequestDto dto) {
        String weekday = LocalDate.parse(dto.getDate(), dateFormat).dayOfWeek().getAsText();
        if (weekday.equals("Saturday") || weekday.equals("Sunday"))
            throw new ApiException("You can't work at weekends. Have fun :)", HttpStatus.BAD_REQUEST);
    }
}
