package com.dateme.demo.bean;

import java.util.Date;

public class UserBean {
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    private int userID;
    private String account;
    private String password;
    private String userName;
    private int sex;
    private String headImageUrl;
    private Date birthday;
    private String introduction;
    private int state;
    private String school;

    @Override
    public String toString() {
        return "UserBean{" +
                "userID=" + userID +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", headImageUrl='" + headImageUrl + '\'' +
                ", birthday=" + birthday +
                ", introduction='" + introduction + '\'' +
                ", state=" + state +
                ", school='" + school + '\'' +
                '}';
    }
}
