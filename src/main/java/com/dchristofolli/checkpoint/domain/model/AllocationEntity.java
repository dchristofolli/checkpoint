package com.dchristofolli.checkpoint.domain.model;

import com.dchristofolli.checkpoint.v1.dto.ProjectEnum;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Allocation")
public class AllocationEntity {
    private String id;
    private String employeeCpf;
    private ProjectEnum projectEnum;
    private String date;
    private double allocationTime;

    public AllocationEntity(String id, String employeeCpf, ProjectEnum projectEnum, String date, double allocationTime) {
        this.id = id;
        this.employeeCpf = employeeCpf;
        this.projectEnum = projectEnum;
        this.date = date;
        this.allocationTime = allocationTime;
    }

    @Override
    public String toString() {
        return "AllocationEntity{" +
            "id='" + id + '\'' +
            ", employeeCpf='" + employeeCpf + '\'' +
            ", projectEnum=" + projectEnum +
            ", date='" + date + '\'' +
            ", allocationTime=" + allocationTime +
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

    public ProjectEnum getProjectEnum() {
        return projectEnum;
    }

    public void setProjectEnum(ProjectEnum projectEnum) {
        this.projectEnum = projectEnum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(double allocationTime) {
        this.allocationTime = allocationTime;
    }
}
