package com.dateornotbackend.service;

import com.dateornotbackend.entity.BlogCheck;
import com.dateornotbackend.mapper.BlogCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCheckService {
    @Autowired
    private BlogCheckMapper blogCheckMapper;

    public int DeleteBlogCheck(int blog_id) {
        return blogCheckMapper.DeleteBlogCheck(blog_id);
    }

    public List<BlogCheck> QueryBlogCheckApplication() {
        return blogCheckMapper.QueryBlogCheckApplication();
    }

    public List<BlogCheck> QueryBlogCheckWarn() {
        return blogCheckMapper.QueryBlogCheckWarn();
    }

    public BlogCheck DetailBlogCheckApplication(int blog_id) {
        return blogCheckMapper.DetailBlogCheckApplication(blog_id);
    }

    public BlogCheck DetailBlogCheckWarn(int blog_id) {
        return blogCheckMapper.DetailBlogCheckWarn(blog_id);
    }
}
