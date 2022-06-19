package com.dateornotbackend.controller;

import com.dateornotbackend.entity.BlogCheck;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.service.BlogCheckService;
import com.dateornotbackend.service.BlogService;
import com.dateornotbackend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/BlogCheck")
public class BlogCheckController {
    @Autowired
    private BlogCheckService blogCheckService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private LogService logService;

    // 动态申请审核通过
    @GetMapping("OptionApplicationPass")
    public void ApplicationPass(int serial_num) {
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheck(serial_num);

        // 审核通过，动态表修改状态
        blogService.UpdateBlog(blogCheck.getBlog_id());

        // 记录操作日志
        Log log = new Log();
        log.setLog_id(blogCheck.getBlog_id());
        log.setLog_type(1);
        log.setManager_id(1);
        log.setOperation(0);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        blogCheckService.DeleteBlogCheck(serial_num);
    }

    // 动态申请审核不通过
    @GetMapping("OptionApplicationFail")
    public void ApplicationFail(int serial_num) {
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheck(serial_num);

        // 记录操作日志
        Log log = new Log();
        log.setLog_id(blogCheck.getBlog_id());
        log.setLog_type(1);
        log.setManager_id(1);
        log.setOperation(1);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        blogCheckService.DeleteBlogCheck(serial_num);

        // 删除动态表中的该动态
        blogService.DeleteBlog(blogCheck.getBlog_id());
    }

    // 动态举报审核通过
    @GetMapping("DeletePass")
    public void DeletePass(int serial_num) {
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheck(serial_num);

        // 记录操作日志
        Log log = new Log();
        log.setLog_id(blogCheck.getBlog_id());
        log.setLog_type(1);
        log.setManager_id(1);
        log.setOperation(0);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        blogCheckService.DeleteBlogCheck(serial_num);

        // 删除动态表中的该动态
        blogService.DeleteBlog(blogCheck.getBlog_id());
    }

    // 动态举报审核不通过
    @GetMapping("DeleteFail")
    public void DeleteFail(int serial_num) {
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheck(serial_num);

        // 记录操作日志
        Log log = new Log();
        log.setLog_id(blogCheck.getBlog_id());
        log.setLog_type(1);
        log.setManager_id(1);
        log.setOperation(1);
        log.setTime(log.nowtime());
        logService.CreateLog(log);

        // 删除审核表中的该条记录
        blogCheckService.DeleteBlogCheck(serial_num);
    }

    // 查询动态审核表中的所有信息
    @GetMapping("Query")
    public List<BlogCheck> QueryBlogCheck() {
        return blogCheckService.QueryBlogCheck();
    }

    // 查询动态审核表中的单条信息
    @GetMapping("Detail")
    public BlogCheck DetailBlogCheck(int serial_num) {
        return blogCheckService.DetailBlogCheck(serial_num);
    }

}
