package com.dateornotbackend.controller;

import com.dateornotbackend.entity.Log;
import com.dateornotbackend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Log")
public class LogController {
    @Autowired
    private LogService logService;

    // 创建一条操作日志
    @GetMapping("Create")
    public void CreateLog(Log log) {
        log.setTime(log.nowtime());
        logService.CreateLog(log);
    }

    // 删除日志
    @GetMapping("Delete")
    public void DeleteLog(int serial_num) {
        logService.DeleteLog(serial_num);
    }

    // 更新日志
    @GetMapping("Update")
    public void UpdateLog(Log log) {
        log.setTime(log.nowtime());
        logService.UpdateLog(log);
    }

    // 查询所有日志记录
    @GetMapping("Query")
    public List<Log> QueryLog() {
        return logService.QueryLog();
    }

    // 查询单条日志记录
    @GetMapping("Detail")
    public Log DetailLog(int serial_num) {
        return logService.DetailLog(serial_num);
    }

     // 查询所有操作用户日志记录
    @GetMapping("QueryUser")
    public List<Log> QueryLogUser() {
        return logService.QueryLogUser();
    }

    // 查询所有操作动态日志记录
    @GetMapping("QueryBlog")
    public List<Log> QueryLogBlog() {
        return logService.QueryLogBlog();
    }

    // 查询所有操作群日志记录
    @GetMapping("QueryGroup")
    public List<Log> QueryLogGroup() {
        return logService.QueryLogGroup();
    }
}
