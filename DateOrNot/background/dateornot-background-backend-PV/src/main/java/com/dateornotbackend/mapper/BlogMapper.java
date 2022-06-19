package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.Blog;

import java.util.List;

public interface BlogMapper {

    int DeleteBlog(int blog_id); //删除动态

    int UpdateBlog(int blog_id); //修改动态的状态

    List<Blog> QueryBlog(); // 查询所有动态

    Blog DetailBlog(int blog_id); // 返回单个动态

    String[] BlogImages(int blog_id); //返回单个动态的所有配图

    List<Blog> QueryThreeDays(); // 查询3天内的动态

    List<Blog> QueryWeek(); // 查询一周内的动态

    List<Blog> QueryMonth(); // 查询一个月内的动态

}
