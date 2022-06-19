package com.dateornotbackend.service;

import com.dateornotbackend.entity.Log;
import com.dateornotbackend.mapper.LogMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public int CreateLog(Log log){
        return logMapper.CreateLog(log);
    }

    public int DeleteLog(int serial_num){
        return logMapper.DeleteLog(serial_num);
    }

    public int UpdateLog(Log log){
        return logMapper.UpdateLog(log);
    }

    public List<Log> QueryLog(){
        return logMapper.QueryLog();
    }

    public Log DetailLog(int serial_num){
        return logMapper.DetailLog(serial_num);
    }

    public List<Log> QueryLogUser(){
        return logMapper.QueryLogUser();
    }

    public List<Log> QueryLogBlog(){
        return logMapper.QueryLogBlog();
    }

    public List<Log> QueryLogGroup(){
        return logMapper.QueryLogGroup();
    }

    public List<Log> QueryThreeDays() {
        return logMapper.QueryThreeDays();
    }

    public List<Log> QueryWeek() {
        return logMapper.QueryWeek();
    }

    public List<Log> QueryMonth() {
        return logMapper.QueryMonth();
    }

}
