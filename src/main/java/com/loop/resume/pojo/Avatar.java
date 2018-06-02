package com.loop.resume.pojo;

public class Avatar {
    private Integer id;

    private byte[] img;

    public Avatar(Integer id, byte[] img) {
        this.id = id;
        this.img = img;
    }

    public Avatar() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}