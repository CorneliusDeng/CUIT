package com.jay.date.service.impl;

import com.jay.date.mapper.GroupMapper;
import com.jay.date.mapper.TagMapper;
import com.jay.date.model.dto.GroupWithTagsDTO;
import com.jay.date.model.dto.TagDTO;
import com.jay.date.model.entity.GroupDO;
import com.jay.date.model.vo.GroupInfoUserVO;
import com.jay.date.model.dto.GroupNoTagDTO;
import com.jay.date.model.vo.MatchedGroupVO;
import com.jay.date.service.GeoService;
import com.jay.date.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Jay
 */
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
    private final TagMapper tagMapper;
    private final GeoService geoService;
    private static final int DEFAULT_LIMIT = 20;
    private static final int RECOMMEND_LIMIT = 20;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper, TagMapper tagMapper, GeoService geoService) {
        this.groupMapper = groupMapper;
        this.tagMapper = tagMapper;
        this.geoService = geoService;
    }

    @Override
    public List<MatchedGroupVO> searchGroupByName(String groupName, int limit) {
        if(groupName == null || limit <= 0 || groupName.length() == 0){
            throw new IllegalArgumentException("搜索群聊参数错误");
        }
        String searchText = "%" + groupName + "%";
        List<GroupNoTagDTO> groups = groupMapper.searchGroupByName(searchText, Math.min(limit, DEFAULT_LIMIT));

        return getGroupVO(groups);
    }

    @Override
    public List<MatchedGroupVO> recommendGroup(Integer userId, Integer limit) {
        if(userId == null || userId < 0 || limit == null || limit <= 0){
            throw new IllegalArgumentException("推荐群聊参数错误");
        }
        List<GroupNoTagDTO> groupNoTag = groupMapper.recommendGroup(userId, Math.min(limit, RECOMMEND_LIMIT));

        return getGroupVO(groupNoTag);
    }

    @Override
    public List<String> getGroupTags(Integer groupId) {
        if(groupId == null || groupId < 0){
            throw new IllegalArgumentException("获取群标签参数错误");
        }
        return tagMapper.getGroupTags(groupId);
    }

    @Override
    public List<GroupInfoUserVO> getGroupMembersForChart(Integer groupId) {
        if(groupId == null || groupId < 0){
            throw new IllegalArgumentException("获取群成员参数错误");
        }
        return groupMapper.getGroupInfoMembers(groupId);
    }

    @Override
    public Map<String, Integer> getGroupMemberProvinces(Integer groupId) {
        if(groupId == null || groupId < 0){
            throw new IllegalArgumentException("获取群成员参数错误");
        }
        Map<String, Integer> result = new HashMap<>(16);
        List<Integer> members = groupMapper.getGroupMembers(groupId);
        if(members == null || members.isEmpty()){
            return result;
        }
        for (Integer userId : members){
            try{
                String address = geoService.getUserAddress(userId.toString());

                if(address != null){
                    int count = 0;
                    if(result.containsKey(address)){
                        count = result.get(address);
                    }
                    result.put(address, count + 1);
                }
            }catch (IllegalArgumentException ignored){
            }
        }
        return result;
    }

    @Override
    public Boolean joinGroup(Integer userId, Integer groupId) {
        if(userId == null || groupId == null){
            throw new IllegalArgumentException("进群参数为null");
        }
        if(userId < 0 || groupId < 0){
            throw new IllegalArgumentException("进群参数错误");
        }

        Integer userInGroupChat = groupMapper.isUserInGroupChat(groupId, userId);
        if(userInGroupChat == 1){
            return true;
        }

        return groupMapper.addGroupMember(groupId, userId) > 0;
    }

    private List<MatchedGroupVO> getGroupVO(List<GroupNoTagDTO> groupNoTagDTOS){
        List<MatchedGroupVO> result = new ArrayList<>(groupNoTagDTOS.size());
        groupNoTagDTOS.forEach((groupNoTagDTO -> {
            List<String> tags = tagMapper.getGroupTags(groupNoTagDTO.getGroupId());
            result.add(new MatchedGroupVO(
                    groupNoTagDTO.getGroupId(),
                    groupNoTagDTO.getGroupName(),
                    groupNoTagDTO.getMemberCount(),
                    groupNoTagDTO.getCreateTime(),
                    groupNoTagDTO.getDescription(),
                    tags,
                    groupNoTagDTO.getHeadImageUrl()));
        }));
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addGroup(GroupWithTagsDTO group) {
        GroupDO groupDO = new GroupDO(group.getGroupId(), group.getGroupName(),
                group.getOwnerId(), group.getMemberCount(),
                group.getCreateTime(), group.getDescription(),
                group.getHeadImageUrl(),group.getStatus());
        Integer status1 = groupMapper.addGroup(groupDO);
        if(status1 == 0){
            throw new RuntimeException("添加群实体出现异常");
        }

        Integer status2 = groupMapper.addGroupMember(groupDO.getGroupId(), group.getOwnerId());
        if(status2 == 0){
            throw new RuntimeException("添加群成员出现异常");
        }

        for(TagDTO tag : group.getGroupTags()){
            tagMapper.addGroupTag(groupDO.getGroupId(), tag.getTagId());
        }
        return true;
    }
}
