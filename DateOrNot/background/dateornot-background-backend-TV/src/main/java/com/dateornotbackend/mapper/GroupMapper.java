package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.Group;

import java.util.List;

public interface GroupMapper {

    int CreateGroup(Group group); // 新增群

    int DeleteGroup(int group_id); // 封禁/删除群

    int UpdateGroup(Group group); // 修改群聊信息

    List<Group> QueryGroup(); // 查询所有群聊信息

    Group DetailGroup(int group_id); // 返回单个群聊信息

    Integer GroupId(String group_name, int owner_id); // 通过通过群审查表内的信息称返回群id
}
