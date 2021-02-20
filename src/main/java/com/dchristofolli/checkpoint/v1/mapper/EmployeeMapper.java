package com.dchristofolli.checkpoint.v1.mapper;

import com.dchristofolli.checkpoint.domain.model.EmployeeEntity;
import com.dchristofolli.checkpoint.domain.model.EmployeeEntityBuilder;
import com.dchristofolli.checkpoint.v1.dto.EmployeeRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public class EmployeeMapper {
//    @Value("${employee.mail.domain}")
    private static String domain = "ilia.com.br";

    private static final Logger log = LoggerFactory.getLogger(EmployeeMapper.class);

    private EmployeeMapper() {
    }

    public static EmployeeEntity mapEmployeeToEntity(EmployeeRequestDto dto) {
        EmployeeEntity employeeEntity = EmployeeEntityBuilder.anEmployeeEntity()
            .withCpf(dto.getCpf())
            .withEmailAddress(dto.getName().toLowerCase() + "." +
                dto.getLastName().toLowerCase() + "@" + domain)
            .withName(dto.getName())
            .withLastName(dto.getLastName())
            .build();
        log.info("Mapper: ".concat(employeeEntity.toString()));
        return employeeEntity;
    }
}
