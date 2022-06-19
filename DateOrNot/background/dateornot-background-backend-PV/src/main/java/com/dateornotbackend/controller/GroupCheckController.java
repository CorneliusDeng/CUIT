package com.dateornotbackend.controller;

import com.dateornotbackend.common.CommonResult;
import com.dateornotbackend.entity.Group;
import com.dateornotbackend.entity.GroupCheck;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.entity.User;
import com.dateornotbackend.service.GroupCheckService;
import com.dateornotbackend.service.GroupService;
import com.dateornotbackend.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public void ApplicationPass(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupApplicationCheck(serial_num);

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
    public void ApplicationFail(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupApplicationCheck(serial_num);

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
    public void DeletePass(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupWarnCheck(serial_num);
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
    public void DeleteFail(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        //获取群审核表内的群基本信息
        GroupCheck groupCheck = DetailGroupWarnCheck(serial_num);
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
    @PostMapping("QueryApplication")
    @ResponseBody
    public CommonResult QueryGroupCheckApplication(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<GroupCheck> list = groupCheckService.QueryGroupCheckApplication();
        PageInfo<GroupCheck> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询群聊审核表群聊举报的所有信息
    @PostMapping("QueryWarn")
    @ResponseBody
    public CommonResult QueryGroupCheckWarn(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<GroupCheck> list =groupCheckService.QueryGroupCheckWarn();
        PageInfo<GroupCheck> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询群聊申请审核表的单条信息
    @PostMapping("DetailApplication")
    @ResponseBody
    public CommonResult DetailGroupApplicationCheck(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        List<GroupCheck> listAll = groupCheckService.QueryGroupCheckApplication();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<GroupCheck> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (GroupCheck groupCheck : listAll) {
            int id = groupCheck.getSerial_num();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(serial_num == id){
                GroupCheck groupCheck = groupCheckService.DetailGroupApplicationCheck(serial_num);
                list.add(groupCheck); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    // 查询群聊审核表的单条信息
    @PostMapping("DetailWarn")
    @ResponseBody
    public CommonResult DetailGroupWarnCheck(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        int flag = 0;   //标志
        List<GroupCheck> listAll = groupCheckService.QueryGroupCheckWarn();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<GroupCheck> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (GroupCheck groupCheck : listAll) {
            int id = groupCheck.getSerial_num();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(serial_num == id){
                GroupCheck groupCheck = groupCheckService.DetailGroupWarnCheck(serial_num);
                list.add(groupCheck); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    // 查询群聊申请审核表的单条信息--逻辑调用
    public GroupCheck DetailGroupApplicationCheck(int serial_num) {
        return groupCheckService.DetailGroupApplicationCheck(serial_num);
    }

    // 查询群聊举报审核表的单条信息--逻辑调用
    public GroupCheck DetailGroupWarnCheck(int serial_num) {
        return groupCheckService.DetailGroupWarnCheck(serial_num);
    }
}
