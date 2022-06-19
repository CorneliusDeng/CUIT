package com.dateme.demo.service;

import com.dateme.demo.bean.BlogBean;
import com.dateme.demo.bean.UserBean;
import com.dateme.demo.dao.BlogDaoInterface;
import com.dateme.demo.dao.UserDaoInterface;
import com.dateme.demo.pojo.UserProfile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserDaoInterface userDao;
    @Resource
    BlogDaoInterface blogDao;

    // 根据用户ID查找用户信息
    @Override
    public UserBean findUserByID(int userID) {
        return userDao.findUserByID(userID);
    }

    // 获取用户简介
    @Override
    public UserProfile getUserProfile(int userID) {
        UserProfile userProfile = new UserProfile();
        UserBean userBean = userDao.findUserByID(userID);

        userProfile.setNickname(userBean.getUserName());
        userProfile.setHeadImage(userBean.getHeadImageUrl());
        userProfile.setSchool(userBean.getSchool());
        List<BlogBean> blogBeans = blogDao.findBlogsByUserID(userID);
        userProfile.setTotalBlogs(blogBeans.size());
        int totalLikes = userDao.calculateTotalLikes(userID);
        userProfile.setTotalLikes(totalLikes);
        return userProfile;
    }
}
