package com.demo.ylm.controller;

import com.demo.ylm.entity.User;
import com.demo.ylm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping("a")
    public void testA(){
        System.out.println("Here is testA");

        User userA = userMapper.getOne();
        if (userA!=null){
            System.err.println(userA.toString());
        }


        System.err.println("TestA end!");
    }

}
