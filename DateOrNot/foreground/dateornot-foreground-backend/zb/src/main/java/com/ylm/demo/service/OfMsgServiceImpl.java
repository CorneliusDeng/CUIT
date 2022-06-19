package com.ylm.demo.service;

import com.ylm.demo.dao.OfflineMsgDao;
import com.ylm.demo.pojo.MsgPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 离线消息处理
 */
@Service(value = "OfMsgServiceImpl")
public class OfMsgServiceImpl implements OfMsgService {
    @Autowired
    private OfflineMsgDao offlineMsgDao;

    @Override
    public List<MsgPacket> findById(int uid) {
        return offlineMsgDao.findById(uid);
    }

    @Override
    public void insertMsg(MsgPacket msgPacket) {
        offlineMsgDao.insertMsg(msgPacket);
    }

    @Override
    public void deleteMsg(int uid) {
        offlineMsgDao.deleteMsg(uid);
    }
}
