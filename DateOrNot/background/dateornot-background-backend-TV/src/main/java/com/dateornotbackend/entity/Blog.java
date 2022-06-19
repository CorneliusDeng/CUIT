package com.dateornotbackend.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Blog {
    private int blog_id; // 动态id
    private int user_id; // 动态所属用户id
    private int thumbs_up; // 点在数量
    private String release_time; // 发布时间
    private int state; // 0:正常 1:待审核
    private String text_content; // 文本内容
    private String[] img_links; // 动态图片
    private int comments_num; //评论数量

    public Blog() {
    }

    public Blog(int blog_id, int user_id, int thumbs_up, String release_time, int state, String text_content, String[] img_links, int comments_num) {
        this.blog_id = blog_id;
        this.user_id = user_id;
        this.thumbs_up = thumbs_up;
        this.release_time = release_time;
        this.state = state;
        this.text_content = text_content;
        this.img_links = img_links;
        this.comments_num = comments_num;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(int thumbs_up) {
        this.thumbs_up = thumbs_up;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public String[] getImg_links() {
        return img_links;
    }

    public void setImg_links(String[] img_links) {
        this.img_links = img_links;
    }

    public int getComments_num() {
        return comments_num;
    }

    public void setComments_num(int comments_num) {
        this.comments_num = comments_num;
    }

    public String nowtime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
