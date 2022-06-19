package com.jay.date.mapper;

import com.jay.date.model.entity.GroupDO;
import com.jay.date.model.vo.GroupInfoUserVO;
import com.jay.date.model.dto.GroupNoTagDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jay
 */
@Mapper
@Repository
public interface GroupMapper {

    /**
     * 搜索群聊
     * @param searchText 搜索文本
     * @param limit 数量上限
     * @return 无标签搜索结果
     */
    @Select("SELECT group_id, group_name, member_count, create_time, description, head_image_url " +
            "FROM GroupChat " +
            "WHERE group_name LIKE #{searchText} " +
            "LIMIT #{limit}")
    List<GroupNoTagDTO> searchGroupByName(@Param("searchText") String searchText, @Param("limit") int limit);


    /**
     * 为用户推荐群聊
     * @param userId 用户id
     * @param limit 推荐数量上限
     * @return 无标签推荐结果
     */
    @Select("SELECT g.group_id, g.group_name, g.member_count, g.description, g.create_time, g.head_image_url  " +
            "FROM GroupChat g, GroupMember gm, GroupTag gt " +
            "WHERE " +
            "   g.group_id NOT IN " +
            "   (SELECT g.group_id " +
            "   FROM GroupChat g, GroupMember gm " +
            "   WHERE " +
            "       gm.user_id=#{userId} AND " +
            "       gm.group_id=g.group_id" +
            "   ) AND " +
            "   gt.tag_id IN " +
            "   (SELECT tag_id " +
            "   FROM UserTag " +
            "   WHERE " +
            "       user_id=#{userId}" +
            "   ) AND " +
            "   gt.group_id=g.group_id " +
            "GROUP BY g.group_id " +
            "ORDER BY COUNT(gt.tag_id) DESC, member_count DESC \n" +
            "LIMIT 10;")
    List<GroupNoTagDTO> recommendGroup(@Param("userId") Integer userId, @Param("limit") Integer limit);

    /**
     * 获取群聊信息中群成员的信息
     * @param groupId 群聊id
     * @return 群成员信息
     */
    @Select("SELECT u.birthday, u.sex FROM User u, GroupMember ug WHERE ug.group_id=#{groupId} AND u.user_id=ug.user_id")
    List<GroupInfoUserVO> getGroupInfoMembers(@Param("groupId") Integer groupId);

    /**
     * 获取群聊成员
     * @param groupId 群聊id
     * @return 成员id集合
     */
    @Select("SELECT user_id FROM GroupMember WHERE group_id=#{groupId}")
    List<Integer> getGroupMembers(@Param("groupId") Integer groupId);

    /**
     * 添加群聊
     * @param groupDO 群聊DO
     * @return 添加状态
     */
    @Insert("INSERT INTO GroupChat VALUES(null, #{group.groupName}, " +
            "#{group.ownerId}, 1," +
            " now(), #{group.description}, " +
            "0, #{group.headImageUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "group.groupId", keyColumn = "group_id")
    Integer addGroup(@Param("group") GroupDO groupDO);

    /**
     * 添加群成员记录
     * @param groupId 群聊id
     * @param userId 用户id
     * @return 添加结果
     */
    @Insert("INSERT INTO GroupMember VALUES(#{userId}, #{groupId})")
    Integer addGroupMember(@Param("groupId") Integer groupId, @Param("userId") Integer userId);

    /**
     * 判断用户是否在群聊中
     * @param groupId 群聊id
     * @param userId 用户id
     * @return 1 ： 在
     */
    @Select("SELECT COUNT(*) FROM GroupMember WHERE user_id=#{userId} AND group_id=#{groupId}")
    Integer isUserInGroupChat(@Param("groupId") Integer groupId, @Param("userId") Integer userId);
}
