package com.dchristofolli.checkpoint.v1.dto;

public class ProjectAllocationRequestDto {
    private String employeeCpf;
    private ProjectEnum projectEnum;
    private String date;
    private double allocationTime;

    public ProjectAllocationRequestDto(String employeeCpf, ProjectEnum projectEnum, String date, double allocationTime) {
        this.employeeCpf = employeeCpf;
        this.projectEnum = projectEnum;
        this.date = date;
        this.allocationTime = allocationTime;
    }

    @Override
    public String toString() {
        return "ProjectAllocationRequestDto{" +
            "employeeCpf='" + employeeCpf + '\'' +
            ", projectEnum=" + projectEnum +
            ", date='" + date + '\'' +
            ", allocationTime=" + allocationTime +
            '}';
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
