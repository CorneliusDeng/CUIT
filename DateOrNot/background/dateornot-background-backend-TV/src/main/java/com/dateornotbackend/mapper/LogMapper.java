package com.dateornotbackend.mapper;

import com.dateornotbackend.entity.Log;

import java.util.List;

public interface LogMapper {

    int CreateLog(Log log); // 新增流水记录

    int DeleteLog(int serial_num); // 删除流水记录

    int UpdateLog(Log log); // 修改流水记录

    List<Log> QueryLog(); // 查询所有流水记录

    Log DetailLog(int serial_num); // 返回单个流水记录

    List<Log> QueryLogUser(); // 查询所有操作用户的流水记录

    List<Log> QueryLogBlog(); // 查询所有操作动态的流水记录

    List<Log> QueryLogGroup(); // 查询所有操作群的流水记录
}
