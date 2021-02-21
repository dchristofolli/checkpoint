package com.dchristofolli.checkpoint.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Time Registration")
public class TimeRegistrationEntity {
    @Id
    private String id;
    private String employeeCpf;
    private String date;
    private String time;

    public TimeRegistrationEntity(String employeeCpf, String date, String time) {
        this.employeeCpf = employeeCpf;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeRegistrationEntity{" +
            "id='" + id + '\'' +
            ", employeeCpf='" + employeeCpf + '\'' +
            ", date=" + date +
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
