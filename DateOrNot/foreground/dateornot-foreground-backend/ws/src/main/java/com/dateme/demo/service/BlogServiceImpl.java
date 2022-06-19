package com.dateme.demo.service;

import com.dateme.demo.TencentCOS;
import com.dateme.demo.bean.BlogBean;
import com.dateme.demo.bean.CommentBean;
import com.dateme.demo.bean.UserBean;
import com.dateme.demo.dao.BlogDaoInterface;
import com.dateme.demo.dao.UserDaoInterface;
import com.dateme.demo.pojo.BlogCard;
import com.dateme.demo.pojo.BlogDetailCard;
import com.dateme.demo.pojo.CommentCard;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

@Service
public class BlogServiceImpl implements BlogService{
    @Resource
    BlogDaoInterface blogDao;
    @Resource
    UserDaoInterface userDao;

    // 查询所有Blog
    @Override
    public List<BlogCard> findAllBlogCards(int userID){
        List<BlogBean> blogBeans = blogDao.findAllBlogs();
        List<BlogCard> result = new ArrayList<>();

        for(BlogBean blogBean: blogBeans){
            BlogCard blogCard = initBlogCardFromBlogBean(blogBean, userID);
            result.add(blogCard);
        }
        return result;
    }

    // 查询用户所有的Blog
    @Override
    public List<BlogCard> findAllMyBlogCards(int userID) {
        List<BlogBean> blogBeans = blogDao.findBlogsByUserID(userID);
        List<BlogCard> result = new ArrayList<>();

        for(BlogBean blogBean: blogBeans){
            BlogCard blogCard = initBlogCardFromBlogBean(blogBean, userID);
            result.add(blogCard);
        }
        return result;
    }

    // 查询Bloger所有的Blog
    @Override
    public List<BlogCard> findAllHisBlogCards(int blogerID,int userID) {
        List<BlogBean> blogBeans = blogDao.findBlogsByUserID(blogerID);
        List<BlogCard> result = new ArrayList<>();

        for(BlogBean blogBean: blogBeans){
            BlogCard blogCard = initBlogCardFromBlogBean(blogBean, userID);
            result.add(blogCard);
        }
        return result;
    }

    @Override
    public List<BlogCard> findLikedBlogs(int userID) {
        List<BlogBean> blogBeans = blogDao.findLikedBlogs(userID);
        List<BlogCard> result = new ArrayList<>();

        for(BlogBean blogBean: blogBeans){
            BlogCard blogCard = initBlogCardFromBlogBean(blogBean, userID);
            result.add(blogCard);
        }
        return result;
    }

    // 查询指定ID的Blog
    @Override
    public BlogDetailCard findBlogDetailByBlogID(int blogID, int userID) {
        BlogDetailCard blogDetailCard = new BlogDetailCard();

        // 设置Blog详情
        BlogCard blogCard = initBlogCardFromBlogBean(blogDao.findBlogByID(blogID), userID);
        blogDetailCard.setBlogCard(blogCard);

        // 设置评论列表
        List<CommentBean> commentBeans= blogDao.findCommentsByBlogID(blogID);
        commentBeans.sort(Comparator.comparing(CommentBean::getCommentID).reversed());
        List<CommentCard> commentCards = new ArrayList<>();
        for(CommentBean cb: commentBeans){
            CommentCard commentCard = initCommentCardFromCommentBean(cb);
            commentCards.add(commentCard);
        }
        blogDetailCard.setComments(commentCards);
        return blogDetailCard;
    }

    // 根据blogBean生成blogCard
    public BlogCard initBlogCardFromBlogBean(BlogBean blogBean, int userID){
        BlogCard blogCard = new BlogCard();
        blogCard.setBlogID(blogBean.getBlogID());
        blogCard.setUserID(blogBean.getUserID());
        blogCard.setCommentNum(blogBean.getCommentsNum());
        blogCard.setImgLinks(blogBean.getImgLinks());
        blogCard.setTextContent(blogBean.getTextContent());
        blogCard.setLikeNum(blogBean.getThumbsUp());
        blogCard.setReleaseTime(blogBean.getReleaseTime());
        blogCard.setLiked(blogDao.checkLike(userID, blogBean.getBlogID()));
        UserBean userBean = userDao.findUserByID(blogBean.getUserID());
        if(userBean != null){
            blogCard.setUserName(userBean.getUserName());
            blogCard.setUserHeadImage(userBean.getHeadImageUrl());
            blogCard.setSchool(userBean.getSchool());
        }

        return blogCard;
    }

    // 根据commentBean生成commentCard
    public CommentCard initCommentCardFromCommentBean(CommentBean commentBean){
        CommentCard commentCard = new CommentCard();
        commentCard.setTime(commentBean.getCommentTime());
        UserBean userBean = userDao.findUserByID(commentBean.getUserID());
        commentCard.setUserName(userBean.getUserName());
        commentCard.setHeadImage(userBean.getHeadImageUrl());
        commentCard.setCommentContent(commentBean.getCommentContent());
        return commentCard;
    }

    // 添加新的Blog(无图片）
    @Override
    public int addNewBlog(int userID, String textContent) {
        System.out.println("添加Blog");
        return blogDao.addNewBlog(userID, new Date(),textContent);
    }

    // 添加新的Blog(有图片)
    @Override
    public int addNewBlogWithImg(Map<String, MultipartFile> map, int userID, String textContent) {
        String imgLinks = "";
        String domain = "https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/";
        List<String> imgList = new ArrayList<>();
        for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
            MultipartFile multfile = entry.getValue();
            String imgUrl = getUrl(multfile);
            imgUrl = domain+imgUrl;
            imgList.add(imgUrl);
            imgLinks += imgUrl + ";";
        }
        imgLinks = imgLinks.substring(0,imgLinks.length()-1);
        blogDao.addNewBlogWithImg(userID, new Date(), textContent, imgLinks);
        int blogID = blogDao.getBlogIDByUser(userID);
        for(String link: imgList){
            blogDao.addImage(blogID, link);
        }
        return 1;
    }


    // 添加评论
    @Override
    public int addComment(int userID, int blogID, String content) {
        System.out.println("评论");
        blogDao.addComment(userID, blogID, content, new Date());
        blogDao.commentNumUp(blogID);
        return 1;
    }

    // 添加点赞
    @Override
    public int addLike(int userID, int blogID) {
        System.out.println("点赞");
        blogDao.addLike(userID, blogID);
        blogDao.likeNumUp(blogID);
        return 1;
    }

    // 取消点赞
    @Override
    public int removeLike(int userID, int blogID) {
        System.out.println("取消点赞");
        blogDao.removeLike(userID, blogID);
        blogDao.likeNumDown(blogID);
        return 0;
    }


    // 修改动态
    @Override
    public int editBlog(int blogID, String textContent) {
        System.out.println("修改动态");
        return blogDao.editBlog(blogID, new Date(), textContent);
    }

    @Override
    public int deleteBlog(int blogID) {
        blogDao.deleteBlog(blogID);
        blogDao.deleteBlogComment(blogID);
        blogDao.deleteBlogImage(blogID);
        blogDao.deleteBlogLikes(blogID);
        return 1;
    }

    @Override
    public int reportBlog(int blogID, String reason) {
        return blogDao.reportBlog(blogID,reason,new Date());
    }


    // 获取图像对象存储的链接
    private String getUrl(MultipartFile multfile){
        String imgUrl = "";
        // 获取文件名
        String fileName = multfile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        try {
            final File excelFile = File.createTempFile("imagesFile-"+System.currentTimeMillis(), prefix);
            // 将MultipartFile转为File
            multfile.transferTo(excelFile);
            //调用腾讯云工具上传文件
            imgUrl = TencentCOS.uploadfile(excelFile);
            //程序结束时，删除临时文件
            deleteFile(excelFile);
        }catch (Exception e){ }
        finally {
            return imgUrl;
        }
    }

    /**
     * 删除临时文件
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
