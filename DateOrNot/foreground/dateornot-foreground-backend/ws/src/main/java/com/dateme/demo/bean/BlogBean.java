package com.dateme.demo.bean;

import java.util.Date;

public class BlogBean {

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getImgLinks() {
        return imgLinks;
    }

    public void setImgLinks(String imgLinks) {
        this.imgLinks = imgLinks;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    private int blogID;
    private int userID;
    private int thumbsUp;
    private int commentsNum;
    private Date releaseTime;
    private int state;
    private String textContent;
    private String imgLinks;

    @Override
    public String toString() {
        return "BlogBean{" +
                "blogID=" + blogID +
                ", userID=" + userID +
                ", thumbsUp=" + thumbsUp +
                ", commentsNum=" + commentsNum +
                ", releaseTime=" + releaseTime +
                ", state=" + state +
                ", textContent='" + textContent + '\'' +
                ", imgLinks='" + imgLinks + '\'' +
                '}';
    }
}
