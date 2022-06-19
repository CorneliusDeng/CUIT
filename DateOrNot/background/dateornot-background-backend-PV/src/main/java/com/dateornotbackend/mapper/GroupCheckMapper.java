package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.GroupCheck;

import java.util.List;

public interface GroupCheckMapper {

    int DeleteGroupCheck(int serial_num); //删除待审核表中的记录

    List<GroupCheck> QueryGroupCheckApplication(); // 查询待申请所有流水记录

    List<GroupCheck> QueryGroupCheckWarn(); // 查询举报待审核所有流水记录

    GroupCheck DetailGroupApplicationCheck(int serial_num); // 返回申请单个流水记录

    GroupCheck DetailGroupWarnCheck(int serial_num); // 返回举报单个流水记录

}
