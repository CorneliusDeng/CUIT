package com.dateme.demo.pojo;

import java.util.List;

public class BlogDetailCard {
    public BlogCard getBlogCard() {
        return blogCard;
    }

    public void setBlogCard(BlogCard blogCard) {
        this.blogCard = blogCard;
    }

    public List<CommentCard> getComments() {
        return comments;
    }

    public void setComments(List<CommentCard> comments) {
        this.comments = comments;
    }

    private BlogCard blogCard;
    private List<CommentCard> comments;
}
