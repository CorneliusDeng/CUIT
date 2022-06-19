package com.dateme.demo.service;

import com.dateme.demo.pojo.BlogCard;
import com.dateme.demo.pojo.BlogDetailCard;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface  BlogService {
    // 查询所有BlogCard
    List<BlogCard> findAllBlogCards(int userID);

    // 查询用户所有的动态
    List<BlogCard> findAllMyBlogCards(int userID);

    // 查询Bloger所有的动态
    List<BlogCard> findAllHisBlogCards(int blogerID,int userID);

    // 查询用户喜欢的动态
    List<BlogCard> findLikedBlogs(int userID);

    // 根据ID查询Blog Detail
    BlogDetailCard findBlogDetailByBlogID(int blogID, int userID);

    // 添加Blog（无图片）
    int addNewBlog(int userID, String textContent);

    // 添加Blog（有图片）
    int addNewBlogWithImg(Map<String, MultipartFile> map, int userID, String textContent);


    // 增加评论
    int addComment(int userID, int blogID, String content);

    // 增加点赞
    int addLike(int userID, int blogID);

    // 减少点赞
    int removeLike(int userID, int blogID);

    // 修改动态
    int editBlog(int blogID, String textContent);

    // 删除动态
    int deleteBlog(int blogID);

    // 举报动态
    int reportBlog(int blogID, String reason);
}
