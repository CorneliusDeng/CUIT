package com.dateme.demo.dao;

import com.dateme.demo.bean.BlogBean;
import com.dateme.demo.bean.CommentBean;
import com.dateme.demo.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface BlogDaoInterface {
    // 查询全部BLog
    @Select("select * from Blog where state = 1")
    List<BlogBean> findAllBlogs();

    // 根据blogID查找评论
    @Select("select * from Comment where blog_id = #{blogID}")
    List<CommentBean> findCommentsByBlogID(@Param("blogID")int blogID);


    // 根据userID查找所有Blog
    @Select("select * from Blog where user_id = #{userID} AND state=1")
    List<BlogBean> findBlogsByUserID(@Param("userID")int userID);

    @Select("select * from Blog where blog_id in " +
            " (select blog_id from Likes where Likes.user_id=#{userID})")
    List<BlogBean> findLikedBlogs(@Param("userID")int userID);

    // 根据blogID查找BLog
    @Select("select * from Blog where blog_id = #{blogID}")
    BlogBean findBlogByID(@Param("blogID")int blogID);

    // 添加BLog（无图片）
    @Insert("insert into Blog(user_id, release_time, text_content)" +
            "values(#{userID}, #{time}, #{content})")
    int addNewBlog(@Param("userID")int userID,
                @Param("time") Date time,
                @Param("content")String content);

    // 添加BLog（有图片）
    @Insert("insert into Blog(user_id, release_time, text_content, img_links)" +
            "values(#{userID}, #{time}, #{content}, #{imgLinks})")
    int addNewBlogWithImg(@Param("userID")int userID,
                   @Param("time") Date time,
                   @Param("content")String content,
                   @Param("imgLinks")String imgLinks);

    // 获取用户最新的Blog的id
    @Select("select blog_id from Blog" +
            " where user_id = #{userID}" +
            " order by release_time desc limit 1;")
    int getBlogIDByUser(@Param("userID")int userID);

    // 添加图片
    @Insert("insert into BlogImage(blog_id, link)" +
            " values(#{blogID}, #{link})")
    int addImage(@Param("blogID")int blogID,
                 @Param("link")String link);

    // 增加评论
    @Insert("insert into Comment(blog_id, user_id, comment_content, comment_time)\n" +
            " values(#{blogID},#{userID},#{content},#{date})")
    int addComment(@Param("userID")int userID,
                   @Param("blogID")int blogID,
                   @Param("content")String content,
                   @Param("date")Date date);

    // 评论数增加
    @Update("update Blog set comments_num = comments_num + 1 where blog_id = #{blogID}")
    int commentNumUp(@Param("blogID")int blogID);

    // 增加点赞
    @Insert("insert into Likes(user_id, blog_id) values(#{userID}, #{blogID})")
    int addLike(@Param("userID")int userID,
                @Param("blogID")int blogID);

    // 点赞数增加
    @Update("update Blog set thumbs_up = thumbs_up + 1 where blog_id = #{blogID}")
    int likeNumUp(@Param("blogID")int blogID);

    // 检查是否点赞
    @Select("select COUNT(*) from Likes where user_id=#{userID} and blog_id=#{blogID}")
    int checkLike(@Param("userID")int userID, @Param("blogID")int blogID);

    // 取消点赞
    @Delete("delete from Likes where user_id=#{userID} and blog_id=#{blogID}")
    int removeLike(@Param("userID")int userID,
                   @Param("blogID")int blogID);
    // 点赞数减少
    @Update("update Blog set thumbs_up = thumbs_up - 1 where blog_id = #{blogID}")
    int likeNumDown(@Param("blogID")int blogID);

    // 修改动态（无图片）
    @Update("update Blog " +
            "set text_content = #{textContent}, " +
            "release_time = #{time} " +
            "where blog_id=#{blogID}")
    int editBlog(@Param("blogID")int blogID,
                 @Param("time")Date time,
                 @Param("textContent")String textContent);

    // 删除动态
    @Delete("delete from Blog where blog_id = #{blogID}")
    int deleteBlog(@Param("blogID")int blogID);

    // 删除动态相关Image
    @Delete("delete from BlogImage where blog_id = #{blogID}")
    int deleteBlogImage(@Param("blogID")int blogID);

    // 删除动态相关评论
    @Delete("delete from Comment where blog_id = #{blogID}")
    int deleteBlogComment(@Param("blogID")int blogID);

    // 删除动态Likes
    @Delete("delete from Likes where blog_id = #{blogID}")
    int deleteBlogLikes(@Param("blogID")int blogID);

    // 举报处理
    @Insert("insert into BlogCheck(blog_id,status,reason,time)" +
            " values(#{blogID}, 0, #{reason}, #{time})")
    int reportBlog(@Param("blogID")int blogID,
                   @Param("reason")String reason,
                   @Param("time")Date time);
}
