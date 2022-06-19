package com.ylm.demo.pojo;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserChannelUtil {
    /**
     * 实现用户id与信道channel的映射
     * 不能用hashMap，hashMap不是线程安全的，并行操作时容易出现死锁
     */
    private static final Map<Integer, Channel> userToChannel = new ConcurrentHashMap<>();

    //添加映射关系
    public static void saveChannel(int userId, Channel channel){
        userToChannel.put(userId,channel);
    }

    //删除映射关系
    public static void removeChannel(int userId){
        userToChannel.remove(userId);
    }

    //根据id获取channel
    public static Channel getChannel(int userId){
        return userToChannel.get(userId);
    }

}
