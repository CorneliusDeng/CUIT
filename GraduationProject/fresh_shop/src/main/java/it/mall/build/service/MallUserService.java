package it.mall.build.service;

import it.mall.build.controller.vo.MallUserVO;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;
import it.mall.build.entity.MallUser;

import javax.servlet.http.HttpSession;

public interface MallUserService {
    // 后台分页
    PageResult getMallUsersPage(PageQueryUtil pageUtil);

    // 用户注册
    String register(String loginName, String password);

    // 登录
    String login(String loginName, String passwordMD5, HttpSession httpSession);

    // 用户信息修改并返回最新的用户信息用户信息修改并返回最新的用户信息
    MallUserVO updateUserInfo(MallUser mallUser, HttpSession httpSession);

    // 用户禁用与解除禁用(0-未锁定 1-已锁定)
    Boolean lockUsers(Integer[] ids, int lockStatus);
    
    int deleteUserById(Long userId);
}
