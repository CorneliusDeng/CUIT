package com.dateme.demo.service;

import com.dateme.demo.bean.UserBean;
import com.dateme.demo.pojo.UserProfile;

public interface UserService {

    // 查询指定ID的用户信息
    UserBean findUserByID(int userID);

    // 获取用户简介
    UserProfile getUserProfile(int userID);
}
