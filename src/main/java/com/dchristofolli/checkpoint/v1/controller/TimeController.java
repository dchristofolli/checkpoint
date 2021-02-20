package com.dchristofolli.checkpoint.v1.controller;

import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import com.dchristofolli.checkpoint.v1.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/time")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping(value = "registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void timeRegistration(TimeRegistrationRequestDto dto) {
        timeService.timeRegistration(dto);
    }
}
