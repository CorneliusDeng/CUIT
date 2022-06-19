package com.dateme.demo.controller;

import com.dateme.demo.bean.UserBean;
import com.dateme.demo.pojo.UserProfile;
import com.dateme.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/userprofile")
    @ResponseBody
    public UserProfile dealUserProfile(@RequestParam("userID")int userID){
        return userService.getUserProfile(userID);
    }

    // 处理获取指定userID的用户信息
    @RequestMapping("/getuser")
    @ResponseBody
    public UserBean getUser(@RequestParam("userID")int userID){
        return userService.findUserByID(userID);
    }
}
