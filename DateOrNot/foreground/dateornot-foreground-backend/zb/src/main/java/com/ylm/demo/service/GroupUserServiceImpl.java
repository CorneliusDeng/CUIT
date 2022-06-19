package com.ylm.demo.service;

import com.ylm.demo.dao.GroupChatDao;
import com.ylm.demo.pojo.GroupUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "GroupUserServiceImpl")
public class GroupUserServiceImpl implements GroupUserService{

    @Autowired
    private GroupChatDao groupChatDao;

    /**
     * 根据id获取所有群用户
     * @param groupID
     * @return
     */
    @Override
    public List<Integer> findById(int groupID) {
        return groupChatDao.groupUserFind(groupID);
    }
}
