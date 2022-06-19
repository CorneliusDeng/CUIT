package com.dateornotbackend.controller;

import com.dateornotbackend.entity.Blog;
import com.dateornotbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    // 删除动态
    @GetMapping("Delete")
    public void DeleteBlog(int blog_id) {
        blogService.DeleteBlog(blog_id);
    }

    @GetMapping("Update")
    // 更新动态状态,主要为通过审核，置状态为“0”
    public void UpdateBlog(int blog_id) {
        blogService.UpdateBlog(blog_id);
    }

    // 查询所有动态信息
    @GetMapping("Query")
    public List<Blog> QueryBlog() {
        return blogService.QueryBlog();
    }

    // 返回单个动态信息
    @GetMapping("Detail")
    public Blog DetailBlog(int blog_id) {
        return blogService.DetailBlog(blog_id);
    }

}
