package com.dateornotbackend.controller;

import com.dateornotbackend.common.CommonResult;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.entity.User;
import com.dateornotbackend.service.LogService;
import com.dateornotbackend.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    // 封禁、删除用户
    @GetMapping("Delete")
    public void DeleteUser(HttpServletRequest request) {
        int user_id = Integer.parseInt(request.getParameter("id"));
        // 记录操作日志
        Log log = new Log();
        log.setLog_id(user_id);
        log.setLog_type(0);
        log.setManager_id(1);
        log.setOperation(0);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除用户
        userService.DeleteUser(user_id);
    }

    // 更新用户信息
    @GetMapping("Update")
    public void UpdateUser(User user) {
        userService.UpdateUser(user);
    }

    // 查询所有用户
    @PostMapping("Query")
    @ResponseBody
    public CommonResult QueryUser(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        // 使用PageHelper传入当前页数和页面显示条数会自动为sql语句加上limit查询
        // 从下一条sql开始分页
        PageHelper.startPage(page, limit);
        List<User> list = userService.QueryUser();
        // 使用pageInfo包装查询
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询单个用户信息
    @PostMapping("Detail")
    @ResponseBody
    public CommonResult DetailUser(HttpServletRequest request) {
        int user_id = Integer.parseInt(request.getParameter("id"));
        List<User> listAll = userService.QueryUser();   //遍历所有用户
        List<Integer> ids = new ArrayList();    //存放所有id
        List<User> list = new ArrayList<User>(); //返回数据

        //获取所有id
        for (User user : listAll) {
            int id = user.getUser_id();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(user_id == id){
                User user = userService.DetailUser(user_id);
                list.add(user); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }
}