package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.repository.EmployeeRepository;
import com.dchristofolli.checkpoint.v1.dto.EmployeeRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.dchristofolli.checkpoint.v1.mapper.EmployeeMapper.mapEmployeeToEntity;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(EmployeeRequestDto dto) {
        log.info(String.valueOf(employeeRepository.save(mapEmployeeToEntity(dto))));
    }
}
