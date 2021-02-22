package com.dchristofolli.checkpoint.v1.controller;

import com.dchristofolli.checkpoint.v1.dto.ProjectAllocationRequestDto;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationRequestDto;
import com.dchristofolli.checkpoint.v1.dto.TimeRegistrationResponseDto;
import com.dchristofolli.checkpoint.v1.service.AllocationService;
import com.dchristofolli.checkpoint.v1.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/time")
public class TimeController {
    private final TimeService timeService;
    private final AllocationService allocationService;

    public TimeController(TimeService timeService, AllocationService allocationService) {
        this.timeService = timeService;
        this.allocationService = allocationService;
    }

    @PostMapping(value = "registration")
    @ResponseStatus(HttpStatus.CREATED)
    public TimeRegistrationResponseDto timeRegistration(@RequestBody TimeRegistrationRequestDto dto) {
        return timeService.timeRegistration(dto);
    }

    @PostMapping(value = "project-allocation")
    @ResponseStatus(HttpStatus.CREATED)
    public void projectAllocation(ProjectAllocationRequestDto dto){
        allocationService.allocateHour(dto);
    }
}
