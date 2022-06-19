package com.dateornotbackend.service;

import com.dateornotbackend.entity.Blog;
import com.dateornotbackend.entity.Group;
import com.dateornotbackend.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public int DeleteBlog(int blog_id) {
        return blogMapper.DeleteBlog(blog_id);
    }

    public int UpdateBlog(int blog_id) {
        return blogMapper.UpdateBlog(blog_id);
    }

    public List<Blog> QueryBlog() {
        List<Blog> list = blogMapper.QueryBlog();
//        List<Blog> listreturn = new ArrayList<Blog>();
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).setImg_links(blogMapper.BlogImages(list.get(i).getBlog_id()));
//            blog.setImg_links(blogMapper.BlogImages(blog.getBlog_id()));
//            listreturn.add(blog);
        }
        return list;
    }

    public Blog DetailBlog(int blog_id) {
        Blog blog = blogMapper.DetailBlog(blog_id);
        blog.setImg_links(blogMapper.BlogImages(blog.getBlog_id()));
        return blog;
    }
}
