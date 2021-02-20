package com.dchristofolli.checkpoint.v1.controller;

import com.dchristofolli.checkpoint.v1.dto.EmployeeRequestDto;
import com.dchristofolli.checkpoint.v1.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path ="/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@Valid @RequestBody EmployeeRequestDto dto){
        logger.info("DTO" + dto);
        employeeService.createEmployee(dto);
    }
}
