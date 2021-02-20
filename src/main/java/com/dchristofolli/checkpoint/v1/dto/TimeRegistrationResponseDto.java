package com.dchristofolli.checkpoint.v1.dto;

public class TimeRegistrationResponseDto {
    private String cpf;
    private String registeredTime;

    public TimeRegistrationResponseDto(String cpf, String registeredTime) {
        this.cpf = cpf;
        this.registeredTime = registeredTime;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }
}
