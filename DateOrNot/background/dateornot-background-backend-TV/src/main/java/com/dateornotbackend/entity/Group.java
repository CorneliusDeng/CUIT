package com.dateornotbackend.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Group {
    private int group_id;
    private String group_name;
    private int owner_id;
    private int member_count;
    private String create_time;
    private String description;
    private int status; //0:正常 1:违规
    private String head_image_url; //头像

    public Group() {

    }

    public Group(int group_id, String group_name, int owner_id, int member_count, String create_time, String description, int status, String head_image_url) {
        this.group_id = group_id;
        this.group_name = group_name;
        this.owner_id = owner_id;
        this.member_count = member_count;
        this.create_time = create_time;
        this.description = description;
        this.status = status;
        this.head_image_url = head_image_url;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getMember_count() {
        return member_count;
    }

    public void setMember_count(int member_count) {
        this.member_count = member_count;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHead_image_url() {
        return head_image_url;
    }

    public void setHead_image_url(String head_image_url) {
        this.head_image_url = head_image_url;
    }

    public String nowtime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
