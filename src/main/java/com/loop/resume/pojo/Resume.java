package com.loop.resume.pojo;

public class Resume {
    private Integer id;

    private String name;

    private Integer user;

    private Integer avatar;

    private Integer preference;

    public Resume(Integer id, String name, Integer user, Integer avatar, Integer preference) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.avatar = avatar;
        this.preference = preference;
    }

    public Resume() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public Integer getPreference() {
        return preference;
    }

    public void setPreference(Integer preference) {
        this.preference = preference;
    }
}