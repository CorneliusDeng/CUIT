package com.dateornotbackend.service;

import com.dateornotbackend.entity.Group;
import com.dateornotbackend.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    public int CreateGroup(Group group) {
        return groupMapper.CreateGroup(group);
    }
    public int DeleteGroup(int group_id) {
        return groupMapper.DeleteGroup(group_id);
    }

    public int UpdateGroup(Group group) {
        return groupMapper.UpdateGroup(group);
    }

    public List<Group> QueryGroup(){
        return groupMapper.QueryGroup();
    }

    public Group DetailGroup(int group_id) {
        return groupMapper.DetailGroup(group_id);
    }

    public Integer GroupId(String group_name, int owner_id) {
        return groupMapper.GroupId(group_name, owner_id);
    }

}
