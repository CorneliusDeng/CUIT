package com.dateornotbackend.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlogCheck {
    private int serial_num;// 待审核流水号
    private int blog_id;
    private int status; // 0:申请发布 1:违规
    private String reason; // 申请发布，用户举报
    private String time; // 审核时间

    public BlogCheck() {
    }

    public BlogCheck(int serial_num, int blog_id, int status, String reason, String time) {
        this.serial_num = serial_num;
        this.blog_id = blog_id;
        this.status = status;
        this.reason = reason;
        this.time = time;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String nowtime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
