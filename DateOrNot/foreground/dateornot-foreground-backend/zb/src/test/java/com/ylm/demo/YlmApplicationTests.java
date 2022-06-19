package com.ylm.demo;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.ylm.demo.dao.GroupChatDao;
import com.ylm.demo.dao.OfflineMsgDao;
import com.ylm.demo.pojo.MsgPacket;
import com.ylm.demo.service.GroupUserService;
import com.ylm.demo.service.OfMsgService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.Region;
import java.io.File;
import java.util.List;

@SpringBootTest
@MapperScan("com.ylm.demo.dao")
class YlmApplicationTests {

	@Autowired
	private OfMsgService service;
	@Autowired
	private GroupUserService groupService;

	@Test
	void contextLoads() {
		String json ="{\"senderId\":\"666\",\"senderName\":\"阿彪\",\"senderUrl\":\"https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg\",\"accepterId\":\"777\",\"msg\":\"你好啊\uD83D\uDE01\uD83D\uDE01\\n\",\"isChat\":false,\"type\":\"text\",\"time\":\"2021-05-03T15:08:29.997Z\"}";
		MsgPacket msgPacket = JSON.parseObject(json,MsgPacket.class);
		System.out.println(groupService.findById(1000001));
//		System.out.println(msgPacket);
//		dao.insertMsg(msgPacket);
//		System.out.println("删除前：");
//		System.out.println(dao.findById(msgPacket.getAccepterId()));
//		dao.deleteMsg(msgPacket.getAccepterId());
//		System.out.println("删除后：");
//		System.out.println(dao.findById(msgPacket.getAccepterId()));





	}
}
