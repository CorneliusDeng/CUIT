package com.ylm.demo.pojo;

/**
 * 群用户映射
 */
public class GroupUser {
    int userId;
    int groupId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "GroupUser{" +
                "userID=" + userId +
                ", groupID=" + groupId +
                '}';
    }
}
