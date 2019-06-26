package com.yl.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String pwd;

    private String phone;

    private String email;

    private String image;

    private long createAt;

    private long updateAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User[id="+id+",name="+name+",pwd="+pwd+",phone="+phone+"" +
                ",email="+email+",image="+image+",createAt="+createAt+",updateAt="+updateAt+"]";
    }
}
