package com.ylm.demo.service;

import com.ylm.demo.pojo.GroupUser;

import java.util.List;

public interface GroupUserService {
    /**
     * 根据id获取所有群用户
     * @param groupID
     * @return
     */
    List<Integer> findById(int groupID);
}
