package com.dateme.demo.pojo;

public class UserProfile {
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getTotalBlogs() {
        return totalBlogs;
    }

    public void setTotalBlogs(int totalBlogs) {
        this.totalBlogs = totalBlogs;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    private String nickname;
    private String headImage;
    private String school;
    private int totalBlogs;
    private int totalLikes;
}
