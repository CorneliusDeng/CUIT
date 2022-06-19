package com.dateornotbackend.service;

import com.dateornotbackend.entity.User;
import com.dateornotbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int DeleteUser(int user_id) {
        return userMapper.DeleteUser(user_id);
    }

    public int UpdateUser(User user) {
        return userMapper.UpdateUser(user);
    }

    public List<User> QueryUser() {
        return userMapper.QueryUser();
    }

    public User DetailUser(int user_id) {
        return userMapper.DetailUser(user_id);
    }


}
