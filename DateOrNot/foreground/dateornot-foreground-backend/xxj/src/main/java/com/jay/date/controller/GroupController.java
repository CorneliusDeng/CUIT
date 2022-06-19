package com.jay.date.controller;

import com.jay.date.model.dto.GroupWithTagsDTO;
import com.jay.date.model.vo.GroupInfoUserVO;
import com.jay.date.model.dto.GroupMemberDTO;
import com.jay.date.model.vo.MatchedGroupVO;
import com.jay.date.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Jay
 */
@RestController
@CrossOrigin
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    private final Logger logger;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @GetMapping("/search")
    public List<MatchedGroupVO> searchGroup(@RequestParam("text") String groupName, @RequestParam("limit") Integer limit){
        try{
            return groupService.searchGroupByName(groupName, limit);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @GetMapping("/recommend")
    public List<MatchedGroupVO> recommendGroup(@RequestParam("userId") Integer userId, @RequestParam("limit") Integer limit){
        try{
            return groupService.recommendGroup(userId, limit);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @GetMapping("/member/chart")
    public List<GroupInfoUserVO> getGroupMembersForChart(@RequestParam("groupId") Integer groupId){
        try{
            return groupService.getGroupMembersForChart(groupId);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @GetMapping("/member/province")
    public Map<String, Integer> getGroupMemberProvince(@RequestParam("groupId") Integer groupId){
        try{
            return groupService.getGroupMemberProvinces(groupId);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @PostMapping()
    public Boolean addGroup(@RequestBody GroupWithTagsDTO group){
        try{
            System.out.println(group.toString());
            return groupService.addGroup(group);
        }
        catch (Exception e){
            logger.info("添加出错：{}", e.getMessage());
            return false;
        }
    }

    @PostMapping("/join")
    public Boolean joinGroup(@RequestBody GroupMemberDTO groupMemberDTO){
        try{
            return groupService.joinGroup(groupMemberDTO.getUserId(), groupMemberDTO.getGroupId());
        }catch (Exception e){
            logger.info("进群出错：{}", e.getMessage());
            return false;
        }
    }
}
