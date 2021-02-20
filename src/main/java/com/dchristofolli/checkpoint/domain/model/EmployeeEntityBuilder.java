package com.dchristofolli.checkpoint.domain.model;

public final class EmployeeEntityBuilder {
    private String cpf;
    private String name;
    private String lastName;
    private String emailAddress;

    private EmployeeEntityBuilder() {
    }

    public static EmployeeEntityBuilder anEmployeeEntity() {
        return new EmployeeEntityBuilder();
    }

    public EmployeeEntityBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public EmployeeEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeEntityBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeEntityBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmployeeEntity build() {
        return new EmployeeEntity(null, cpf, name, lastName, emailAddress);
    }
}
