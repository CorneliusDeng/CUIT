package com.demo.ylm.entity;

import java.util.Date;

public class User {
    private int user_id;
    private String account;
    private String password;
    private String user_name;
    private String sex;
    private String head_image_url;
    private String tag;
    private String introduction;
    private String birthday;
    private String school;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHead_image_url() {
        return head_image_url;
    }

    public void setHead_image_url(String head_image_url) {
        this.head_image_url = head_image_url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", sex='" + sex + '\'' +
                ", head_image_url='" + head_image_url + '\'' +
                ", tag='" + tag + '\'' +
                ", introduction='" + introduction + '\'' +
                ", birthday='" + birthday + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
