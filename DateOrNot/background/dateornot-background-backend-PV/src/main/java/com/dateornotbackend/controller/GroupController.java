package com.dateornotbackend.controller;

import com.dateornotbackend.common.CommonResult;
import com.dateornotbackend.entity.Group;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.entity.User;
import com.dateornotbackend.service.GroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Group")
@CrossOrigin
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
    public void DeleteGroup(HttpServletRequest request){
        int group_id = Integer.parseInt(request.getParameter("id"));
        groupService.DeleteGroup(group_id);
    }

    // 更新群聊信息
    @GetMapping("Update")
    public void UpdateGroup(Group group) {
        groupService.UpdateGroup(group);
    }

    // 查询所有群聊信息
    @PostMapping("Query")
    @ResponseBody
    public CommonResult QueryGroup(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Group> list = groupService.QueryGroup();
        PageInfo<Group> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询单条群聊信息
    @PostMapping("Detail")
    @ResponseBody
    public CommonResult DetailGroup(HttpServletRequest request) {
        int group_id = Integer.parseInt(request.getParameter("id"));
        List<Group> listAll = groupService.QueryGroup();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<Group> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (Group group: listAll) {
            int id = group.getGroup_id();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(group_id == id){
                Group group = groupService.DetailGroup(group_id);
                list.add(group); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    // 通过群名称查询群id
    @PostMapping("GroupIdBynameId")
    public Integer GroupId(String group_name, int owner_id){
        return groupService.GroupId(group_name, owner_id);
    }

}
