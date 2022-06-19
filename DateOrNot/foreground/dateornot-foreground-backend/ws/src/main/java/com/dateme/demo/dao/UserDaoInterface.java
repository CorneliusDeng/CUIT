package com.dateme.demo.dao;

import com.dateme.demo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDaoInterface {

    // 根据UserID查找用户信息
    @Select("select * from User where user_id = #{userID}")
    UserBean findUserByID(@Param("userID")int userID);


    // 获取用户总点赞数
    @Select("select COUNT(user_id) from Likes " +
            "where blog_id in (select blog_id from Blog where user_id = #{userID})")
    int calculateTotalLikes(@Param("userID")int userID);
}
