package com.dateme.demo.controller;


import com.dateme.demo.pojo.BlogCard;
import com.dateme.demo.pojo.BlogDetailCard;
import com.dateme.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


@Controller
public class BlogController {

    @Resource
    BlogService blogService;

    // 处理发送动态的请求（有图片）
    @RequestMapping("/postblogwithimg")
    @ResponseBody
    public int dealPostBlogWithImg(MultipartHttpServletRequest mulq, @RequestParam("userID") int userID,
             @RequestParam("textContent") String textContent){
        Map<String, MultipartFile> map = mulq.getFileMap();
        return blogService.addNewBlogWithImg(map, userID, textContent);
    }


    // 处理发送动态的请求（无图片）
    @RequestMapping("/postblog")
    @ResponseBody
    public int dealPostBlog(@RequestParam("userID") int userID,
                            @RequestParam("textContent") String textContent){
        return blogService.addNewBlog(userID, textContent);
    }

    // 处理修改动态的请求（无图片）
    @RequestMapping("/editblog")
    @ResponseBody
    public int dealEditBlog(@RequestParam("blogID") int blogID,
                            @RequestParam("textContent") String textContent){
        return blogService.editBlog(blogID, textContent);
    }


    // 处理获取全部动态的请求
    @RequestMapping("/allblogs")
    @ResponseBody
    public List<BlogCard> deliverBlogs(@RequestParam("userID")int userID){
        List<BlogCard> blogCards = blogService.findAllBlogCards(userID);
        // 按blogID降序排列
        blogCards.sort(Comparator.comparing(BlogCard::getBlogID).reversed());
        // 按点赞数降序排列
//        blogCards.sort(Comparator.comparing(BlogCard::getLikeNum).reversed());
        // 按评论数降序排序
//        blogCards.sort(Comparator.comparing(BlogCard::getCommentNum).reversed());
        return blogCards;
    }

    // 处理获取用户全部动态的请求
    @RequestMapping("/allmyblogs")
    @ResponseBody
    public List<BlogCard> deliverMyBlogs(@RequestParam("userID")int userID){
        List<BlogCard> blogCards = blogService.findAllMyBlogCards(userID);
        // 按blogID降序排列
        blogCards.sort(Comparator.comparing(BlogCard::getBlogID).reversed());
        // 按点赞数降序排列
//        blogCards.sort(Comparator.comparing(BlogCard::getLikeNum).reversed());
        // 按评论数降序排序
//        blogCards.sort(Comparator.comparing(BlogCard::getCommentNum).reversed());
        return blogCards;
    }

    // 处理获取用户全部动态的请求
    @RequestMapping("/allhisblogs")
    @ResponseBody
    public List<BlogCard> deliverMyBlogs(@RequestParam("blogerID")int blogerID,
                                         @RequestParam("userID")int userID){
        List<BlogCard> blogCards = blogService.findAllHisBlogCards(blogerID,userID);
        // 按blogID降序排列
        blogCards.sort(Comparator.comparing(BlogCard::getBlogID).reversed());
        // 按点赞数降序排列
//        blogCards.sort(Comparator.comparing(BlogCard::getLikeNum).reversed());
        // 按评论数降序排序
//        blogCards.sort(Comparator.comparing(BlogCard::getCommentNum).reversed());
        return blogCards;
    }

    // 处理获取用户全部likes的请求
    @RequestMapping("/allmylikes")
    @ResponseBody
    public List<BlogCard> deliverMyLikes(@RequestParam("userID")int userID){
        List<BlogCard> blogCards = blogService.findLikedBlogs(userID);
        // 按blogID降序排列
        blogCards.sort(Comparator.comparing(BlogCard::getBlogID).reversed());
        // 按点赞数降序排列
//        blogCards.sort(Comparator.comparing(BlogCard::getLikeNum).reversed());
        // 按评论数降序排序
//        blogCards.sort(Comparator.comparing(BlogCard::getCommentNum).reversed());
        return blogCards;
    }

    // 处理获取指定动态的详情
    @RequestMapping("/blogdetail")
    @ResponseBody
    public BlogDetailCard deliverBlogDetail(@RequestParam("blogID")int blogID,
                                            @RequestParam("userID")int userID){
        return blogService.findBlogDetailByBlogID(blogID,userID);
    }


    // 处理评论
    @RequestMapping("/remarkblog")
    @ResponseBody
    public int leaveAComment(@RequestParam("blogID")int blogID, @RequestParam("userID")int userID,
                             @RequestParam("content")String content){
        return blogService.addComment(userID, blogID, content);
    }

    // 处理点赞
    @RequestMapping("/likeblog")
    @ResponseBody
    public int likeABlog(@RequestParam("userID")int userID,
                         @RequestParam("blogID")int blogID){
        return blogService.addLike(userID, blogID);
    }

    // 处理取消点赞
    @RequestMapping("/dislikeblog")
    @ResponseBody
    public int dislikeABlog(@RequestParam("userID")int userID,
                         @RequestParam("blogID")int blogID){
        return blogService.removeLike(userID, blogID);
    }

    // 删除动态
    @RequestMapping("/deleteblog")
    @ResponseBody
    public int deleteBlog(@RequestParam("blogID")int blogID){
        return blogService.deleteBlog(blogID);
    }

    // 处理举报
    @RequestMapping("/report")
    @ResponseBody
    public int dealReport(@RequestParam("userID")int userID,
                          @RequestParam("blogID")int blogID,
                          @RequestParam("reason")String reason){
        System.out.println(userID + blogID + reason);
        return blogService.reportBlog(blogID,reason);
    }
}
