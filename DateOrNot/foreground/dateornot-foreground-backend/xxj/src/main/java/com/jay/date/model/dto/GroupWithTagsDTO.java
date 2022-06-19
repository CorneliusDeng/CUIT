package com.jay.date.model.dto;

import java.util.Arrays;

/**
 * @author Jay
 */
public class GroupWithTagsDTO {
    private Integer groupId;
    private String groupName;
    private Integer ownerId;
    private Integer memberCount;
    private String createTime;
    private String description;
    private String headImageUrl;
    private Integer status;
    private TagDTO[] groupTags;

    public GroupWithTagsDTO(Integer groupId, String groupName, Integer ownerId, Integer memberCount, String createTime, String description, String headImageUrl, Integer status, TagDTO[] groupTags) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.ownerId = ownerId;
        this.memberCount = memberCount;
        this.createTime = createTime;
        this.description = description;
        this.headImageUrl = headImageUrl;
        this.status = status;
        this.groupTags = groupTags;
    }

    public GroupWithTagsDTO() {
    }

    @Override
    public String toString() {
        return "GroupWithTagsDTO{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", ownerId=" + ownerId +
                ", memberCount=" + memberCount +
                ", createTime='" + createTime + '\'' +
                ", description='" + description + '\'' +
                ", headImageUrl='" + headImageUrl + '\'' +
                ", status=" + status +
                ", groupTags=" + Arrays.toString(groupTags) +
                '}';
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TagDTO[] getGroupTags() {
        return groupTags;
    }

    public void setGroupTags(TagDTO[] groupTags) {
        this.groupTags = groupTags;
    }
}
