package com.ylm.demo.pojo;

import java.util.Date;

/**
 * 消息实体类
 */
public class MsgPacket {
    private int senderId;   //发送者id
    private String senderName;  //发送者name
    private String senderUrl;   //发送者头像
    private int accepterId;     //接收者id
    private String type;    //消息类型
    private boolean isGroupChat;    //是否是群消息
    private String msg;     //消息内容
    private Date time;      //发送时间

    /* JSON样例：
  {"senderId":"666","senderName":"阿彪",
    "senderUrl":"https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg",
    "accepterId":"777","msg":"666\n","isChat":false,"type":"text","time":"2021-05-05T08:13:57.206Z"}

     {"senderId":"777","senderName":"邓棋",
     "senderUrl":"https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/dq.jpg",
     "accepterId":"666","msg":"你好\n","isChat":false,"type":"text","time":"2021-05-05T08:13:57.206Z"}  */
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(int accepterId) {
        this.accepterId = accepterId;
    }

    public boolean isGroupChat() {
        return isGroupChat;
    }

    public void setGroupChat(boolean groupChat) {
        isGroupChat = groupChat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderUrl() {
        return senderUrl;
    }

    public void setSenderUrl(String senderUrl) {
        this.senderUrl = senderUrl;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MsgPacket{" +
                "senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", senderUrl='" + senderUrl + '\'' +
                ", accepterId=" + accepterId +
                ", type='" + type + '\'' +
                ", isChat=" + isGroupChat +
                ", mes='" + msg + '\'' +
                ", time=" + time +
                '}';
    }
}
