package com.loop.resume.pojo;

public class Skill {
    private Integer id;

    private Integer resumeId;

    private String name;

    private Integer levelNumber;

    private String levelName;

    public Skill(Integer id, Integer resumeId, String name, Integer levelNumber, String levelName) {
        this.id = id;
        this.resumeId = resumeId;
        this.name = name;
        this.levelNumber = levelNumber;
        this.levelName = levelName;
    }

    public Skill() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }
}