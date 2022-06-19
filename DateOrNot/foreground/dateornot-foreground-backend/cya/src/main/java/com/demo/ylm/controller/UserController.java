package com.demo.ylm.controller;

//import com.demo.yml.entity.ResponseResult;

import com.demo.ylm.entity.User;
import com.demo.ylm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/*
*接口注意事项*【以下事项，未实现（@）或事项待队伍协商解决（#）】
@1：判断空值。
@2：唯一标识来源。
#3：文件检查，后缀名，真文件，文件安全性校验，挂马脚本检查，文件大小限制【可通过application.yml设置，
* 超出文件大小闭区间的返回。】
@4：密码隐藏。
@5：可单独定义的User属性接口：tag。
#6：上传数据均接收限制为 json单层k-v格式。
#7：相应内容均为 json单层k-v格式。{"*_status":int}。前后端，相应格式未统一，无文档叙述，无规范。
#8：访问控制，权限验证
#9：图片等媒体资源的保存地址，用nginx，apache等反向代理。tomcat作为逻辑代码容器。
--【不隶属于后端程序的部分】--10：针对图片资源的选取，需要用户授权，且选取图片的UI，默认。
#11：图片等媒体资源的全路径，https/http。数据库暂时只保存为 name.suffix。同小组成员协商后再确定。
@12：控制台打印内容，仅仅作为调试，不可保留至部署版本的。
*
*
*
*
*
*
*
***********continue to be***********
*/



@CrossOrigin //跨域
@Controller
@RequestMapping("user")
public class UserController {
    //自动注入
    @Autowired
    UserService userService;

    //    获取用户信息
    @ResponseBody//接收数据
    @RequestMapping(value = "getuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getUser(@RequestBody JSONObject reqParams) {
        JSONObject resp = new JSONObject();

        System.out.println(reqParams.toJSONString());

        String account = reqParams.get("account").toString();// 不判断空值，不判断转义

        User user = userService.getUserByaccount(account);

        System.err.println(user.toString());

        if (user != null) {
            resp.put("user", user);// 获取成功

            return resp.toJSONString();
        } else {
            resp.put("get_status", 311);// 获取失败
            return resp.toJSONString();
        }
    }

    //    修改用户信息【用户头像修改，使用profileup接口】
    @ResponseBody//接收数据
    @RequestMapping(value = "setinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setUserInfo(@RequestBody JSONObject reqParams) {
        JSONObject resp = new JSONObject();
        User user = new User();

        // TODO 判断空值，判断特殊符号，只设置少部分实体属性
        /*
        * reqParams 格式[单层json结构]
        {
        "account":"",
        "birthday":"",
        "sex":"",
        "introduction":"",
        "tag":"tag"
        }
        * */
        user.setAccount(reqParams.getString("account")); // account，判定值，数据来源于session 或 app接口的上传。理论上必须判断为非空。
        user.setBirthday(reqParams.getString("birthday")); // 应当判断非空值
        user.setSex(reqParams.getString("sex")); // 应当判断非空值
        user.setIntroduction(reqParams.getString("introduction")); // 应当判断非空值
//        user.setTag(reqParams.getString("tag")); // 应当判断非空值 // 可以有单独的接口

        int setState = userService.setUserInfo(user);

        if (setState == 1) {
            resp.put("set_status", 310);// 设置成功

            return resp.toJSONString();
        } else {
            resp.put("set_status", 311);// 设置失败
            return resp.toJSONString();
        }
    }

    //    登陆
    @ResponseBody//接收数据
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(@RequestBody JSONObject reqParams) {
        JSONObject resp = new JSONObject();

        String account = reqParams.get("account").toString();// 不判断空值，不判断转义
        String password = reqParams.get("password").toString();// 不判断空值，不判断转义

        int loginStatus = userService.login(account, password);


        if (loginStatus == 1) {
            resp.put("login_status", 300);// 登陆成功
            User user = userService.getUserByaccount(account);
            resp.put("user", user);
            return resp.toJSONString();
        } else {
            resp.put("login_status", 301);// 登陆失败
            return resp.toJSONString();
        }
    }

    //    注册
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String register(@RequestBody JSONObject reqParams) {
        JSONObject resp = new JSONObject();

        String account = reqParams.get("account").toString();// 空值判断，转义判断 TODO，客户端，后端，空值、转义判断， 忽略
        String password = reqParams.get("password").toString();// 空值判断，转义判断

//          TODO,UID，后期修改，大写，忽略
        String user_name = account.substring(0, 5) + "@" + String.valueOf(System.currentTimeMillis()).substring(5);
//        System.err.println(account+password);

        int registerStatus = userService.register(account, password, user_name);

        if (registerStatus == 1) {
            resp.put("register_status", 302);// 注册成功，302

            return resp.toJSONString();
        } else {
            resp.put("register_status", 303);// 注册失败，303
            return resp.toJSONString();
        }
    }

    //    修改密码 【TODO ，硬删除，不使用软删除】
    @ResponseBody//接收数据
    @RequestMapping(value = "pwdremodify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String pwdModify(@RequestBody JSONObject reqParams) {
        JSONObject resp = new JSONObject();


        String account = reqParams.get("account").toString();// 不判断空值，不判断转义 // TODO account的服务器端来源。
        String password = reqParams.get("password").toString();// 不判断空值，不判断转义


        int loginStatus = userService.pwdModify(account, password);


        if (loginStatus == 1) {
            resp.put("modify_status", 308);// modify成功

            return resp.toJSONString();
        } else {
            resp.put("modify_status", 309);// modify失败
            return resp.toJSONString();
        }
    }


    //    头像上传、修改
    // TODO , 上传图片， 前端验证，后端检查，忽略
    @PostMapping(value = "profileup")
    public String profileUp(@RequestParam(value = "file") MultipartFile file) throws IOException {
        JSONObject resp = new JSONObject();
//        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static/img/";
        String path = System.getProperty("user.dir") + "/src/main/resources/static/img/";
        String account = "1"; // TODO, account应当来源于session或json上传

        if (file.isEmpty()) { // TODO ， 判断，忽略
            System.out.println("空文件"); // TODO 忽略细节
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

        String filePath = path; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名 TODO， 会不会重复，不考虑，忽略

        File newProfile = new File(filePath + fileName);

        if (!newProfile.getParentFile().exists()) {
            newProfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newProfile);

            userService.editProfile("123123123", fileName); // account 先写死。// TODO account 方案01: 从session-cookie中得到


        } catch (IOException e) {
            e.printStackTrace();
        }

        resp.put("profile_up", 305); // TODO , 默认成功。失败原因：网络差、断网，程序故障，事务回滚 ******** 忽略。
        return resp.toJSONString();
    }

}