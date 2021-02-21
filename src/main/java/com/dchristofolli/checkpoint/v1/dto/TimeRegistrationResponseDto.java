package com.dchristofolli.checkpoint.v1.dto;

public class TimeRegistrationResponseDto {
    private String cpf;
    private String registeredDate;
    private String registeredTime;

    public TimeRegistrationResponseDto(String cpf, String registeredDate, String registeredTime) {
        this.cpf = cpf;
        this.registeredDate = registeredDate;
        this.registeredTime = registeredTime;
    }

    @Override
    public String toString() {
        return "TimeRegistrationResponseDto{" +
            "cpf='" + cpf + '\'' +
            ", registeredDate='" + registeredDate + '\'' +
            ", registeredTime='" + registeredTime + '\'' +
            '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }
}
