package com.ylm.demo.dao;


import com.ylm.demo.pojo.GroupUser;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 群信息获取
 */
@Mapper
@Repository
public interface GroupChatDao {
    /**
     * 根据群id查询
     * @param groupID
     * @return
     */
    @Select("select user_id from GroupMember where group_id = #{groupID}")
    List<Integer> groupUserFind(int groupID);
}
