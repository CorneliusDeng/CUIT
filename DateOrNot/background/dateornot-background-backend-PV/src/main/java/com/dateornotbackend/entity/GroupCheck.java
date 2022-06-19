package com.dateornotbackend.entity;

public class GroupCheck {
    private int serial_num;// 待审核流水号
    private String group_name; // 群名称
    private int owner_id; //群主id
    private int status; //0:申请创建 1:违规
    private String reason; // 申请创建，用户举报
    private String time; // 提交时间
    private String head_image_url; //头像

    public GroupCheck() {
    }

    public GroupCheck(int serial_num, String group_name, int owner_id, int status, String reason, String time, String head_image_url) {
        this.serial_num = serial_num;
        this.group_name = group_name;
        this.owner_id = owner_id;
        this.status = status;
        this.reason = reason;
        this.time = time;
        this.head_image_url = head_image_url;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
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

    public String getHead_image_url() {
        return head_image_url;
    }

    public void setHead_image_url(String head_image_url) {
        this.head_image_url = head_image_url;
    }
}
