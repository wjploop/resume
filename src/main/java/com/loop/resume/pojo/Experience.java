package com.loop.resume.pojo;

public class Experience {
    private Integer id;

    private Integer resumeId;

    private String timePeriod;

    private String organization;

    private String jobTitle;

    private String description;

    public Experience(Integer id, Integer resumeId, String timePeriod, String organization, String jobTitle, String description) {
        this.id = id;
        this.resumeId = resumeId;
        this.timePeriod = timePeriod;
        this.organization = organization;
        this.jobTitle = jobTitle;
        this.description = description;
    }

    public Experience() {
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}