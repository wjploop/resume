package com.loop.resume.pojo;

public class Preference {
    private Integer id;

    private String jobFunction;

    private String jobType;

    private String jobCity;

    private String salary;

    private String dutyTime;

    public Preference(Integer id, String jobFunction, String jobType, String jobCity, String salary, String dutyTime) {
        this.id = id;
        this.jobFunction = jobFunction;
        this.jobType = jobType;
        this.jobCity = jobCity;
        this.salary = salary;
        this.dutyTime = dutyTime;
    }

    public Preference() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction == null ? null : jobFunction.trim();
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity == null ? null : jobCity.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(String dutyTime) {
        this.dutyTime = dutyTime == null ? null : dutyTime.trim();
    }
}