package com.dateornotbackend.controller;

import com.dateornotbackend.common.CommonResult;
import com.dateornotbackend.entity.Log;
import com.dateornotbackend.entity.User;
import com.dateornotbackend.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Log")
@CrossOrigin
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
    @PostMapping("Query")
    @ResponseBody
    public CommonResult QueryLog(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryLog();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询所有操作用户日志记录
    @PostMapping("QueryUser")
    @ResponseBody
    public CommonResult QueryLogUser(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryLogUser();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询所有操作动态日志记录
    @PostMapping("QueryBlog")
    @ResponseBody
    public CommonResult QueryLogBlog(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryLogBlog();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询所有操作群日志记录
    @PostMapping("QueryGroup")
    @ResponseBody
    public CommonResult QueryLogGroup(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryLogGroup();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询单条日志记录
    @PostMapping("Detail")
    @ResponseBody
    public CommonResult DetailLog(HttpServletRequest request) {
        int serial_num = Integer.parseInt(request.getParameter("id"));
        List<Log> listAll = logService.QueryLog();   //遍历所有
        List<Integer> ids = new ArrayList();    //存放所有id
        List<Log> list = new ArrayList<>(); //返回数据

        //获取所有id
        for (Log log : listAll) {
            int id = log.getSerial_num();
            ids.add(id);
        }
        //id是否存在
        for (Integer id : ids) {
            while(serial_num == id){
                Log log = logService.DetailLog(serial_num);
                list.add(log); //关键--解决前端报错：Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '0'
                return new CommonResult("0","success",1,list);
            }
        }
        return new CommonResult("0","success",1,null);
    }

    // 查询三天内日志记录
    @PostMapping("QueryThreeDays")
    @ResponseBody
    public CommonResult QueryThreeDays(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryThreeDays();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询一周内日志记录
    @PostMapping("QueryWeek")
    @ResponseBody
    public CommonResult QueryWeek(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryWeek();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }

    // 查询三天内日志记录
    @PostMapping("QueryMonth")
    @ResponseBody
    public CommonResult QueryMonth(@RequestParam(required=false,defaultValue="1") int page,@RequestParam(required=false) int limit) {
        PageHelper.startPage(page, limit);
        List<Log> list = logService.QueryMonth();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return new CommonResult("0","success",pageInfo.getTotal(),pageInfo.getList());
    }
}
