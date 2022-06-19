package com.ylm.demo.service;

import com.ylm.demo.pojo.MsgPacket;

import java.util.List;

public interface OfMsgService {
    //获取用户所有离线消息
    List<MsgPacket> findById(int uid);
    //插入新离线消息
    void insertMsg(MsgPacket msgPacket);
    //删除用户所有离线消息
    void deleteMsg(int uid);
}
