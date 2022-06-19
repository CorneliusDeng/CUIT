package com.demo.ylm.mapper;

import com.demo.ylm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


// TODO ，所有均不考虑事务
@Mapper
public interface UserMapper {

    //    获取一个用户
    User getOne();

    //    登陆
    int selectByAccountPwd(@Param("account") String account, @Param("password") String password);


    //    注册
    int getUserByAccountRecord(@Param("account") String account);

    //    uid10=uuid五位数+时间戳，秒级，后十位数
    int insertUser(@Param("account") String account, @Param("password") String password, @Param("uid10") String uid10);


    //    修改用户头像

    String getPreProfile(@Param("account")String account); // 获取用户之前头像

    int updateProfile(@Param("account") String account, @Param("head_image_url") String head_image_url); // 修改用户profile值

    int pwdModify(@Param("account") String account,@Param("password")  String password);

    // 获取用户信息，根据账号
    User getUserByAccount(@Param("account")String account);

    // 上传json，设置用户个人信息
    int updateInfo(@Param("user") User user);// 传入实体

    /**
     * 获取用户所有的tag
     * @param userId 用户id
     * @return tag id 集合
     */
    @Select("SELECT tag_id FROM UserTag WHERE user_id=#{userId}")
    List<Integer> getUserTags(@Param("userId") Integer userId);
}
