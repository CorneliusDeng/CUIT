package it.mall.build.controller.admin;

import it.mall.build.service.MallUserService;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.Result;
import it.mall.build.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class MallUserController {

    @Resource
    private MallUserService mallUserService;

    @GetMapping("/users")
    public String usersPage(HttpServletRequest request) {
        request.setAttribute("path", "users");
        return "admin/mall_user";
    }

    // 列表
    @GetMapping("/users/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(mallUserService.getMallUsersPage(pageUtil));
    }

    // 用户禁用与解除禁用(0-未锁定 1-已锁定)
    @PostMapping("/users/lock/{lockStatus}")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (lockStatus != 0 && lockStatus != 1) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (mallUserService.lockUsers(ids, lockStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }
    
    @GetMapping("/users/delete/{userId}")
    public String deleteGoodById(HttpServletRequest request, @PathVariable("userId") Long userId) {
        int result = mallUserService.deleteUserById(userId);
        System.out.println(result);
        if (result != 1) {
            return "error/error_5xx";
        } else {
            return "admin/mall_user";
        }
    }
}