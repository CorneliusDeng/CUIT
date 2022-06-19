package com.dateornotbackend.controller;

import com.dateornotbackend.common.CommonResult;
import com.dateornotbackend.entity.BlogCheck;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.service.BlogCheckService;
import com.dateornotbackend.service.BlogService;
import com.dateornotbackend.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/BlogCheck")
@CrossOrigin
public class BlogCheckController {
    @Autowired
    private BlogCheckService blogCheckService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private LogService logService;

    // 动态申请审核通过
    @GetMapping("OptionApplicationPass")
    public void ApplicationPass(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheckApplication(serial_num);

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
    public void ApplicationFail(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheckApplication(serial_num);

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
    public void DeletePass(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheckWarn(serial_num);

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
    public void DeleteFail(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        // 获取动态审核表内的信息
        BlogCheck blogCheck = DetailBlogCheckWarn(serial_num);

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

    // 查询动态审核表中申请发布的所有信息
    @PostMapping("QueryApplication")
    @ResponseBody
    public CommonResult QueryBlogCheckApplication(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<BlogCheck> list = blogCheckService.QueryBlogCheckApplication();
        PageInfo<BlogCheck> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询动态审核表中举报的所有信息
    @PostMapping("QueryWarn")
    @ResponseBody
    public CommonResult QueryBlogCheckWarn(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<BlogCheck> list = blogCheckService.QueryBlogCheckWarn();
        PageInfo<BlogCheck> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询动态审核表中申请发布的单条信息
    @PostMapping("DetailApplication")
    @ResponseBody
    public CommonResult DetailBlogCheckApplication(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        List<BlogCheck> listAll = blogCheckService.QueryBlogCheckApplication();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<BlogCheck> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (BlogCheck blogCheck : listAll) {
            int id = blogCheck.getSerial_num();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(serial_num == id){
                BlogCheck blogCheck = blogCheckService.DetailBlogCheckApplication(serial_num);
                list.add(blogCheck); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    // 查询动态审核表中举报的单条信息
    @PostMapping("DetailWarn")
    @ResponseBody
    public CommonResult DetailBlogCheckWarn(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        List<BlogCheck> listAll = blogCheckService.QueryBlogCheckWarn();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<BlogCheck> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (BlogCheck blogCheck : listAll) {
            int id = blogCheck.getSerial_num();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(serial_num == id){
                BlogCheck blogCheck = blogCheckService.DetailBlogCheckWarn(serial_num);
                list.add(blogCheck); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    //逻辑调用
    public BlogCheck DetailBlogCheckApplication(int serial_num){
        BlogCheck blogCheck = blogCheckService.DetailBlogCheckApplication(serial_num);
        return blogCheck;
    }

    public BlogCheck DetailBlogCheckWarn(int serial_num){
        BlogCheck blogCheck = blogCheckService.DetailBlogCheckWarn(serial_num);
        return blogCheck;
    }
}
