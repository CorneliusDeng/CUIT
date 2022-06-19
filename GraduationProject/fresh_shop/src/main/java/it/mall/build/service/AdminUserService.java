package it.mall.build.service;

import it.mall.build.entity.AdminUser;

public interface AdminUserService {

    AdminUser login(String userName, String password);

    // 获取用户信息
    AdminUser getUserDetailById(Integer loginUserId);

    // 修改当前登录用户的密码
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    // 修改当前登录用户的名称信息
    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);
}