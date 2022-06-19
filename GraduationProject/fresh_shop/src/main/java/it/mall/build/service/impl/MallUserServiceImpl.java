package it.mall.build.service.impl;

import it.mall.build.common.Constants;
import it.mall.build.common.ServiceResultEnum;
import it.mall.build.controller.vo.MallUserVO;
import it.mall.build.mapper.MallUserMapper;
import it.mall.build.entity.MallUser;
import it.mall.build.service.MallUserService;
import it.mall.build.util.BeanUtil;
import it.mall.build.util.MD5Util;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MallUserServiceImpl implements MallUserService {

    @Autowired
    private MallUserMapper mallUserMapper;

    @Override
    public PageResult getMallUsersPage(PageQueryUtil pageUtil) {
        List<MallUser> mallUsers = mallUserMapper.findMallUserList(pageUtil);
        int total = mallUserMapper.getTotalMallUsers(pageUtil);
        PageResult pageResult = new PageResult(mallUsers, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    // 用户注册
    @Override
    public String register(String loginName, String password) {
        // 检测注册用户是否存在
        if (mallUserMapper.selectByLoginName(loginName) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        // 封装数据
        MallUser registerUser = new MallUser();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);
        String passwordMD5 = MD5Util.MD5Encode(password, "UTF-8");
        registerUser.setPasswordMd5(passwordMD5);
        // 注册操作
        if (mallUserMapper.insertSelective(registerUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String login(String loginName, String passwordMD5, HttpSession httpSession) {
        // 根据用户名密码查询用户是否存在
        MallUser user = mallUserMapper.selectByLoginNameAndPasswd(loginName, passwordMD5);
        if (user != null && httpSession != null) {
            // 用户锁定
            if (user.getLockedFlag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED.getResult();
            }
            // 昵称太长 影响页面展示
            if (user.getNickName() != null && user.getNickName().length() > 7) {
                String tempNickName = user.getNickName().substring(0, 7) + "..";
                user.setNickName(tempNickName);
            }
            MallUserVO mallUserVO = new MallUserVO();
            // 将登录结果转变为一个VO对象
            BeanUtil.copyProperties(user, mallUserVO);
            // 设置购物车中的数量，即生成购物车
            httpSession.setAttribute(Constants.MALL_USER_SESSION_KEY, mallUserVO);
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    @Override
    public MallUserVO updateUserInfo(MallUser mallUser, HttpSession httpSession) {
        MallUser user = mallUserMapper.selectByPrimaryKey(mallUser.getUserId());
        if (user != null) {
            user.setNickName(mallUser.getNickName());
            user.setAddress(mallUser.getAddress());
            user.setIntroduceSign(mallUser.getIntroduceSign());
            if (mallUserMapper.updateByPrimaryKeySelective(user) > 0) {
                MallUserVO mallUserVO = new MallUserVO();
                user = mallUserMapper.selectByPrimaryKey(mallUser.getUserId());
                BeanUtil.copyProperties(user, mallUserVO);
                httpSession.setAttribute(Constants.MALL_USER_SESSION_KEY, mallUserVO);
                return mallUserVO;
            }
        }
        return null;
    }

    @Override
    public Boolean lockUsers(Integer[] ids, int lockStatus) {
        if (ids.length < 1) {
            return false;
        }
        return mallUserMapper.lockUserBatch(ids, lockStatus) > 0;
    }

	@Override
	public int deleteUserById(Long userId) {
		return mallUserMapper.deleteByPrimaryKeyTwo(userId);
	}
}
