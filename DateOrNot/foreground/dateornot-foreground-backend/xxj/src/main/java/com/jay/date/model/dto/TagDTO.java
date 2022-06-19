package com.jay.date.model.dto;

/**
 * @author Jay
 */
public class TagDTO {
    private Integer tagId;
    private String content;

    public TagDTO(Integer tagId, String content) {
        this.tagId = tagId;
        this.content = content;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "tagId=" + tagId +
                ", content='" + content + '\'' +
                '}';
    }
}
