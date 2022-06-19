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

    public List<BlogCheck> QueryBlogCheck() {
        return blogCheckMapper.QueryBlogCheck();
    }

    public BlogCheck DetailBlogCheck(int blog_id) {
        return blogCheckMapper.DetailBlogCheck(blog_id);
    }
}
