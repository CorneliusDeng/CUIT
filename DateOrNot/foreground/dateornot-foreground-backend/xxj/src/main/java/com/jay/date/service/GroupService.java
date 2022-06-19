package com.jay.date.service;

import com.jay.date.model.dto.GroupWithTagsDTO;
import com.jay.date.model.vo.GroupInfoUserVO;
import com.jay.date.model.vo.MatchedGroupVO;

import java.util.List;
import java.util.Map;

/**
 * @author Jay
 */
public interface GroupService {
    /**
     * 通过名称搜索群聊
     * @param groupName 群聊名称
     * @param limit 上限
     * @return 搜索结果
     */
    List<MatchedGroupVO> searchGroupByName(String groupName, int limit);

    /**
     * 为用户推荐群聊
     * @param userId 用户id
     * @param limit 推荐数量上限
     * @return 推荐结果
     */
    List<MatchedGroupVO> recommendGroup(Integer userId, Integer limit);

    /**
     * 获取group的标签
     * @param groupId 群聊id
     * @return 标签集合
     */
    @Deprecated
    List<String> getGroupTags(Integer groupId);

    /**
     * 获取group成员信息
     * @param groupId 群聊id
     * @return 群成员信息
     */
    List<GroupInfoUserVO> getGroupMembersForChart(Integer groupId);

    /**
     * 获取group成员的省份分布
     * @param groupId 群聊id
     * @return 各省份成员数量
     */
    Map<String, Integer> getGroupMemberProvinces(Integer groupId);

    /**
     * 进群
     * @param userId 用户id
     * @param groupId 群聊id
     * @return 进群状态
     */
    Boolean joinGroup(Integer userId, Integer groupId);

    /**
     * 建群
     * @param group 群实体
     * @return 状态
     */
    Boolean addGroup(GroupWithTagsDTO group);
}
