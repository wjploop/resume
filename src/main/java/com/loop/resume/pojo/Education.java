package com.loop.resume.pojo;

public class Education {
    private Integer id;

    private Integer resumeId;

    private String timePeriod;

    private String schoolName;

    private String major;

    private String description;

    public Education(Integer id, Integer resumeId, String timePeriod, String schoolName, String major, String description) {
        this.id = id;
        this.resumeId = resumeId;
        this.timePeriod = timePeriod;
        this.schoolName = schoolName;
        this.major = major;
        this.description = description;
    }

    public Education() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod == null ? null : timePeriod.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}