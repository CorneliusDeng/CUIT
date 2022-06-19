package com.ylm.demo.dao;

import com.ylm.demo.pojo.MsgPacket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 离线消息处理
 */
@Mapper
@Repository
public interface OfflineMsgDao {
    /**
     * 根据id查找离线消息
     * @param uid
     * @return
     */
    @Select("select * from OfflineMessage where accepter_id = #{uid}")
    List<MsgPacket> findById(int uid);

    /**
     * 插入消息
     * @param msgPacket
     */
    @Insert("insert into OfflineMessage(sender_id,sender_url,sender_name,accepter_id,is_group_chat,type,msg,time)" +
            "VALUES(#{senderId},#{senderUrl},#{senderName},#{accepterId},0,#{type},#{msg},#{time})")
    void insertMsg(MsgPacket msgPacket);

    /**
     * 根据id删除用户所有离线消息缓存
     * @param uid
     */
    @Delete("delete from OfflineMessage where accepter_id=#{uid}")
    void deleteMsg(int uid);
}
