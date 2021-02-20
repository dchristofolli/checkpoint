package com.dchristofolli.checkpoint.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String cpf;
    private String name;
    private String lastName;
    @Indexed(unique = true)
    private String emailAddress;

    public EmployeeEntity(String id, String cpf, String name, String lastName, String emailAddress) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
            "id='" + id + '\'' +
            ", cpf='" + cpf + '\'' +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
