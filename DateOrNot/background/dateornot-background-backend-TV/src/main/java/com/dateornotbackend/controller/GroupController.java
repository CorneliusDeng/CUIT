package com.dateornotbackend.controller;

import com.dateornotbackend.entity.Group;
import com.dateornotbackend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    // 创建群聊
    @GetMapping("Create")
    public void CreateGroup(Group group) {
        group.setCreate_time(group.nowtime());
        group.setMember_count(1);
        group.setStatus(0);
        groupService.CreateGroup(group);
    }

    // 删除群聊
    @GetMapping("Delete")
    public void DeleteGroup(int group_id){
        groupService.DeleteGroup(group_id);
    }

    // 更新群聊信息
    @GetMapping("Update")
    public void UpdateGroup(Group group) {
        groupService.UpdateGroup(group);
    }

    // 查询所有群聊信息
    @GetMapping("Query")
    public List<Group> QueryGroup() {
        return groupService.QueryGroup();
    }

    // 查询单条群聊信息
    @GetMapping("Detail")
    public Group DetailGroup(int group_id) {
        return groupService.DetailGroup(group_id);
    }

    // 通过群名称查询群id
    @GetMapping("GroupIdBynameId")
    public Integer GroupId(String group_name, int owner_id){
        return groupService.GroupId(group_name, owner_id);
    }

}
