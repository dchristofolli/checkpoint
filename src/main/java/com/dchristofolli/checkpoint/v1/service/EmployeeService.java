package com.dchristofolli.checkpoint.v1.service;

import com.dchristofolli.checkpoint.domain.repository.EmployeeRepository;
import com.dchristofolli.checkpoint.v1.dto.EmployeeRequestDto;
import org.springframework.stereotype.Service;

import static com.dchristofolli.checkpoint.v1.mapper.EmployeeMapper.mapEmployeeToEntity;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(EmployeeRequestDto dto) {
        employeeRepository.save(mapEmployeeToEntity(dto));
    }
    public boolean employeeNotRegistered(String employeeCpf) {
        return !employeeRepository.existsByCpf(employeeCpf);
    }
}
