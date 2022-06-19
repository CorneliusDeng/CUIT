package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.BlogCheck;

import java.util.List;

public interface BlogCheckMapper {

    int DeleteBlogCheck(int blog_id); // 删除待审核的动态信息

    List<BlogCheck> QueryBlogCheck(); // 查询所有流水记录

    BlogCheck DetailBlogCheck(int blog_id); // 返回单个流水记录
}
