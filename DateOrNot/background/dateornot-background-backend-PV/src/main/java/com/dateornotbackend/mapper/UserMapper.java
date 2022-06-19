package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.User;

import java.util.List;

public interface UserMapper {

    int DeleteUser(int user_id); // 封禁/删除用户

    int UpdateUser(User user); // 修改用户信息

    List<User> QueryUser(); // 查询所有用户信息

    User DetailUser(int user_id); // 返回单用户信息
}
