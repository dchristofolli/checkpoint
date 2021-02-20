package com.dchristofolli.checkpoint.v1.dto;

import com.dchristofolli.checkpoint.domain.enumerator.ScheduleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

public class TimeRegistrationRequestDto {
    @CPF(message = "Invalid CPF. Type only numbers")
    @NotBlank
    @Schema(defaultValue = "07683807079")
    private String employeeCpf;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @Schema(defaultValue = "20-02-2021 13:17")
    private String time;
    @Schema(allowableValues = "AM_IN, AM_OUT, PM_IN, PM_OUT", defaultValue = "AM_IN")
    private ScheduleTypeEnum scheduleTypeEnum;

    public TimeRegistrationRequestDto(String employeeCpf, String time, ScheduleTypeEnum scheduleTypeEnum) {
        this.employeeCpf = employeeCpf;
        this.time = time;
        this.scheduleTypeEnum = scheduleTypeEnum;
    }

    @Override
    public String toString() {
        return "TimeRegistrationRequestDto{" +
            "employeeCpf='" + employeeCpf + '\'' +
            ", time=" + time +
            '}';
    }

    public ScheduleTypeEnum getDayPeriodEnum() {
        return scheduleTypeEnum;
    }

    public void setDayPeriodEnum(ScheduleTypeEnum dayPeriodEnum) {
        this.scheduleTypeEnum = dayPeriodEnum;
    }

    public String getEmployeeCpf() {
        return employeeCpf;
    }

    public void setEmployeeCpf(String employeeCpf) {
        this.employeeCpf = employeeCpf;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
