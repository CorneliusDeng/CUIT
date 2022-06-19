package com.dateornotbackend.controller;

import com.dateornotbackend.entity.Log;
import com.dateornotbackend.entity.User;
import com.dateornotbackend.service.LogService;
import com.dateornotbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    // 封禁、删除用户
    @GetMapping("Delete")
    public void DeleteUser(int user_id) {
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
        user.setState(1);
        userService.UpdateUser(user);
    }

    // 查询所有用户
    @GetMapping("Query")
    public List<User> QueryUser() {
        return userService.QueryUser();
    }

    // 查询单个用户信息
    @GetMapping("Detail")
    public User DetailUser(int user_id) {
        return userService.DetailUser(user_id);
    }

}
