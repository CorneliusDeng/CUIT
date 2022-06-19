package com.dateornotbackend.controller;

import com.dateornotbackend.entity.Group;
import com.dateornotbackend.entity.GroupCheck;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.service.GroupCheckService;
import com.dateornotbackend.service.GroupService;
import com.dateornotbackend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/GroupCheck")
public class GroupCheckController {
    @Autowired
    private GroupCheckService groupCheckService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private LogService logService;

    // 群聊申请审核通过
    @GetMapping("OptionApplicationPass")
    public void ApplicationPass(int serial_num) {
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupCheck(serial_num);

        //审核通过，插入到群聊表
        Group group = new Group();
        group.setGroup_name(groupCheck.getGroup_name());
        group.setOwner_id(groupCheck.getOwner_id());
        group.setMember_count(1);
        group.setCreate_time(group.nowtime());
        group.setDescription("群主还未设置任何介绍");
        group.setStatus(0);
        group.setHead_image_url(groupCheck.getHead_image_url());
        groupService.CreateGroup(group);

        //记录操作日志
        Log log = new Log();
        log.setLog_id(group.getGroup_id());
        log.setLog_type(2);
        log.setManager_id(1);
        log.setOperation(0);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        groupCheckService.DeleteGroupCheck(serial_num);
    }

    // 群聊申请审核不通过
    @GetMapping("OptionApplicationFail")
    public void ApplicationFail(int serial_num) {
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupCheck(serial_num);

        //审核不通过，记录操作日志
        Log log = new Log();
        log.setLog_id(1024);
        log.setLog_type(2);
        log.setManager_id(1);
        log.setOperation(1);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        groupCheckService.DeleteGroupCheck(serial_num);
    }

    // 群聊举报审核通过
    @GetMapping("DeletePass")
    public void DeletePass(int serial_num) {
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupCheck(serial_num);
        int group_id = groupService.GroupId(groupCheck.getGroup_name(),groupCheck.getOwner_id());

        //封禁通过，记录操作日志
        Log log = new Log();
        log.setLog_id(group_id);
        log.setLog_type(2);
        log.setManager_id(1);
        log.setOperation(0);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 封禁群，即删除群聊表内该群的信息
        groupService.DeleteGroup(group_id);

        // 删除审核表中的该条记录
        groupCheckService.DeleteGroupCheck(serial_num);
    }

    // 群聊举报审核不通过
    @GetMapping("DeleteFail")
    public void DeleteFail(int serial_num) {
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupCheck(serial_num);
        int group_id = groupService.GroupId(groupCheck.getGroup_name(),groupCheck.getOwner_id());

        //封禁不通过，记录操作日志
        Log log = new Log();
        log.setLog_id(group_id);
        log.setLog_type(2);
        log.setManager_id(1);
        log.setOperation(1);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        groupCheckService.DeleteGroupCheck(serial_num);
    }

    // 查询群聊审核表群聊申请的所有信息
    @GetMapping("QueryApplication")
    public List<GroupCheck> QueryGroupCheckApplication() {
        return groupCheckService.QueryGroupCheckApplication();
    }

    // 查询群聊审核表群聊举报的所有信息
    @GetMapping("QueryWarn")
    public List<GroupCheck> QueryGroupCheckWarn() {
        return groupCheckService.QueryGroupCheckWarn();
    }

    // 查询群聊审核表的单条信息
    @GetMapping("Detail")
    public GroupCheck DetailGroupCheck(int serial_num) {
        return groupCheckService.DetailGroupCheck(serial_num);
    }
}