package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.BlogCheck;

import java.util.List;

public interface BlogCheckMapper {

    int DeleteBlogCheck(int blog_id); // 删除待审核的动态信息

    List<BlogCheck> QueryBlogCheckApplication(); // 查询所有待申请流水记录

    List<BlogCheck> QueryBlogCheckWarn(); // 查询所有举报待审核流水记录

    BlogCheck DetailBlogCheckApplication(int blog_id); // 返回单个待申请流水记录

    BlogCheck DetailBlogCheckWarn(int blog_id); // 返回单个举报待审核流水记录
}
