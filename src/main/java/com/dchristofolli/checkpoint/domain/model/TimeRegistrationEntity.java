package com.dchristofolli.checkpoint.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Time Registration")
public class TimeRegistrationEntity {
    @Id
    private String id;
    private String employeeCpf;
    private String time;

    public TimeRegistrationEntity(String id, String employeeCpf, String time) {
        this.id = id;
        this.employeeCpf = employeeCpf;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeRegistrationEntity{" +
            "id='" + id + '\'' +
            ", employeeCpf='" + employeeCpf + '\'' +
            ", time=" + time +
            '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
