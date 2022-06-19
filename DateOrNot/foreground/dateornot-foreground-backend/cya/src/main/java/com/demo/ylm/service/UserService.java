package com.demo.ylm.service;

import com.demo.ylm.entity.User;
import com.demo.ylm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("userService")
public class UserService {
    // TODO 不注明参数及其作用
// @Resouce
    @Autowired
    UserMapper userMapper;

    // 获取用户信息
    public User getUserByaccount(String account) {
        User user = userMapper.getUserByAccount(account);


        return user;
    }
    // 设置用户信息
    public int setUserInfo(User user){
        int code = userMapper.updateInfo(user);

        if (code == 1){ // 设置成功
            return 1;
        } else{
            return 0; // 设置失败
        }

    }

    //    登陆
    public int login(String account, String password) {
        // 根据账号密码，查询用户记录条数，1条，账号密码正确，0条，账号密码错误
        int loginRecord = userMapper.selectByAccountPwd(account, password);

        if (loginRecord == 1) {
            // 返回1，允许登陆，返回0，不可登陆
            return 1;
        } else {
            return 0;
        }
    }

    //    注册
    public int register(String account, String password, String user_name) {

        // 根据账号，查询用户记录条数，0条，账号可以注册，>=1条，账号已被注册【实际数据库中，应该是最多1条】
        int tmpCode = userMapper.getUserByAccountRecord(account);

        if (tmpCode == 0) {
            int registerCode = userMapper.insertUser(account, password, user_name);

            if (registerCode == 1) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return 0;
        }
    }

    //    修改-硬删除，不使用软删除
    public int pwdModify(String account, String password) {

        int tmpCode = userMapper.pwdModify(account, password);
        System.out.println(account + ":" + password);
        return tmpCode;
    }

    //  用户头像
    public int editProfile(String account, String profile) {
        String prePrefile = userMapper.getPreProfile(account); // 获取之前头像的字符串

        // TODO ，头像不设置性别，注册不设置性别
        if (!prePrefile.isEmpty() && !prePrefile.equals("profile.jpg")) { // 如果字符串不为空 且 字符串不是默认头像
            String rootAdd = System.getProperty("user.dir"); // 获取当前项目目录地址
            String imgAdd = rootAdd + "/src/main/resources/static/img/"; // 拼接img文件夹


            // TODO 判断null，忽略
            File preImg = new File(imgAdd + prePrefile); // 创建img文件对象

            // TODO 不判断是否是文件，不管
            if (preImg.exists()) {
                preImg.delete(); // 删除
            }
        }

        userMapper.updateProfile(account, profile); // 修改为新的文件名


        return 1; // TODO ，默认删除成功，删除失败，忽略
    }

    public List<Integer> getUserTags(Integer userId){
        return userMapper.getUserTags(userId);
    }


}
