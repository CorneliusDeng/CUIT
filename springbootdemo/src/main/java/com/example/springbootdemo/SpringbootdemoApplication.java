package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 本身就是一个Spring组件

// 程序主入口
// SpringBootApplication：标注这个类是一个Springboot的应用
@SpringBootApplication
public class SpringbootdemoApplication
{

    public static void main(String[] args)
    {
        //将springboot应用启动
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}
