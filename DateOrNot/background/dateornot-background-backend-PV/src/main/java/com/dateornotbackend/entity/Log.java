package com.dateornotbackend.entity;

import com.dateornotbackend.utils.PageHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log extends PageHelper {
    private int serial_num;// 待审核流水号
    private int log_id; // 操作对象id
    private int log_type; //0:用户 1:动态 2:群
    private int manager_id; // 审批的管理员id
    private int operation; //操作内容 0:通过 1:不通过
    private String time;//操作时间

    public Log() {
    }

    public Log(int serial_num, int log_id, int log_type, int manager_id, int operation, String time) {
        this.serial_num = serial_num;
        this.log_id = log_id;
        this.log_type = log_type;
        this.manager_id = manager_id;
        this.operation = operation;
        this.time = time;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getLog_type() {
        return log_type;
    }

    public void setLog_type(int log_type) {
        this.log_type = log_type;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
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
