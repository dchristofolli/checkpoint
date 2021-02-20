package com.dchristofolli.checkpoint.v1.dto;

import org.joda.time.DateTime;

public class TimeRegistrationRequestDto {
    private String employeeCpf;
    private DateTime time;

    public TimeRegistrationRequestDto(String employeeCpf, DateTime time) {
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

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }
}
