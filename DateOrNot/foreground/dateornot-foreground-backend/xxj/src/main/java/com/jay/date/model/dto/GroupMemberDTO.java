package com.jay.date.model.dto;

/**
 * @author Jay
 */
public class GroupMemberDTO {
    private Integer userId;
    private Integer groupId;

    public GroupMemberDTO(Integer userId, Integer groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "GroupMemberDTO{" +
                "userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}
