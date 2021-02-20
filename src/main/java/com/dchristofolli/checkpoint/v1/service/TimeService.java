package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.model.TimeRegistrationEntity;
import com.dchristofolli.checkpoint.domain.repository.TimeRegistrationRepository;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    private final TimeRegistrationRepository timeRegistrationRepository;
    private final EmployeeService employeeService;
    private final Logger log = LoggerFactory.getLogger("Time Service");

    public TimeService(TimeRegistrationRepository timeRegistrationRepository, EmployeeService employeeService) {
        this.timeRegistrationRepository = timeRegistrationRepository;
        this.employeeService = employeeService;
    }

    public void timeRegistration(TimeRegistrationRequestDto dto) {
//        if(employeeService.employeeNotRegistered(dto.getEmployeeCpf()))
//            throw new ApiException("Employee not registered", HttpStatus.BAD_REQUEST);
        DateTimeFormatter dateTimeFormatter = ISODateTimeFormat.dateTime();
//        DateTime dateTime = dateTimeFormatter.parseDateTime(dto.getTime().toString());
        DateTime dateTime = DateTime.now();
        TimeRegistrationEntity entity = new TimeRegistrationEntity(null, dto.getEmployeeCpf(),
            dateTime.toString("dd/MM/yyyy hh:mm:ss"));
        log.info(entity.toString());
        timeRegistrationRepository.save(entity);
    }
}
