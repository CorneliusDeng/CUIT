package com.dateornotbackend.controller;

import com.dateornotbackend.common.CommonResult;
import com.dateornotbackend.entity.Blog;
import com.dateornotbackend.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Blog")
@CrossOrigin
public class BlogController {
    @Autowired
    private BlogService blogService;

    // 删除动态
    @GetMapping("Delete")
    public void DeleteBlog(HttpServletRequest request) {
        int blog_id= Integer.parseInt(request.getParameter("id"));
        blogService.DeleteBlog(blog_id);
    }

    @GetMapping("Update")
    // 更新动态状态,主要为通过审核，置状态为“0”
    public void UpdateBlog(HttpServletRequest request) {
        int blog_id= Integer.parseInt(request.getParameter("id"));
        blogService.UpdateBlog(blog_id);
    }

    // 查询所有动态信息
    @PostMapping("Query")
    @ResponseBody
    public CommonResult QueryBlog(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Blog> list = blogService.QueryBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 返回单个动态信息
    @PostMapping("Detail")
    @ResponseBody
    public CommonResult DetailBlog(HttpServletRequest request) {
        int blog_id= Integer.parseInt(request.getParameter("id"));
        List<Blog> listAll = blogService.QueryBlog();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<Blog> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (Blog blog : listAll) {
            int id = blog.getBlog_id();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(blog_id == id){
                Blog blog = blogService.DetailBlog(blog_id);
                list.add(blog); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    // 查询三天内的动态信息
    @PostMapping("QueryThreeDays")
    @ResponseBody
    public CommonResult QueryThreeDays(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Blog> list = blogService.QueryThreeDays();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询一周内的动态信息
    @PostMapping("QueryWeek")
    @ResponseBody
    public CommonResult QueryWeek(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Blog> list = blogService.QueryWeek();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询一月内的动态信息
    @PostMapping("QueryMonth")
    @ResponseBody
    public CommonResult QueryMonth(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Blog> list = blogService.QueryMonth();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }
}