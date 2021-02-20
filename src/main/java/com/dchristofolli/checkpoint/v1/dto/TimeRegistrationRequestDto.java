package com.dchristofolli.checkpoint.v1.dto;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

public class TimeRegistrationRequestDto {
    @CPF(message = "Invalid CPF. Type only numbers")
    @NotBlank
    private String employeeCpf;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private String time;

    public TimeRegistrationRequestDto(String employeeCpf, String time) {
        this.employeeCpf = employeeCpf;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeRegistrationRequestDto{" +
            "employeeCpf='" + employeeCpf + '\'' +
            ", time=" + time +
            '}';
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
