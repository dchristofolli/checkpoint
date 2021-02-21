package com.dchristofolli.checkpoint.v1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

public class TimeRegistrationRequestDto {
    @CPF(message = "Invalid CPF. Type only numbers")
    @NotBlank
    @Schema(defaultValue = "07683807079")
    private String employeeCpf;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Schema(defaultValue = "20-02-2021")
    private String date;

    @DateTimeFormat(pattern = "HH:mm")
    @Schema(defaultValue = "13:17")
    private String time;

    public TimeRegistrationRequestDto(@CPF(message = "Invalid CPF. Type only numbers") @NotBlank String employeeCpf, String date, String time) {
        this.employeeCpf = employeeCpf;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeRegistrationRequestDto{" +
            "employeeCpf='" + employeeCpf + '\'' +
            ", date='" + date + '\'' +
            ", time='" + time + '\'' +
            '}';
    }

    public String getEmployeeCpf() {
        return employeeCpf;
    }

    public void setEmployeeCpf(String employeeCpf) {
        this.employeeCpf = employeeCpf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
