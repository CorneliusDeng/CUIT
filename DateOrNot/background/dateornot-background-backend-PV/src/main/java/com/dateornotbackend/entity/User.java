package com.dateornotbackend.entity;


import com.dateornotbackend.utils.PageHelper;

public class User extends PageHelper {
    private int user_id;
    private String account;
    private String password;
    private String user_name;
    private int sex; //0:男 1：女
    private String birthday;
    private String introduction;
    private int state; //0:一般 1:警告  2:封禁
    private String head_image_url; // 个人头像
    private String school; // 学校


    public User() {

    }

    public User(int user_id, String account, String password, String user_name, int sex, String birthday, String introduction, int state, String head_image_url, String school) {
        this.user_id = user_id;
        this.account = account;
        this.password = password;
        this.user_name = user_name;
        this.sex = sex;
        this.birthday = birthday;
        this.introduction = introduction;
        this.state = state;
        this.head_image_url = head_image_url;
        this.school = school;
    }

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getHead_image_url() {
        return head_image_url;
    }

    public void setHead_image_url(String head_image_url) {
        this.head_image_url = head_image_url;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}