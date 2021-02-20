package com.dchristofolli.checkpoint.v1.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeRequestDto {
    @CPF(message = "CPF must be a valid security social number")
    private String cpf;
    @Size(min = 5, max = 50, message = "Name needs to be inside 5 and 50 characters")
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Last name can't be blank")
    private String lastName;

    public EmployeeRequestDto(String cpf, String name, String lastName) {
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "EmployeeRequestDto{" +
            "cpf='" + cpf + '\'' +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
