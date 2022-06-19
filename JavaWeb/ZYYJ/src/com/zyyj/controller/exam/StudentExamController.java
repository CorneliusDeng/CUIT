package com.zyyj.controller.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyyj.service.exam.StudentExamService;

@Controller
public class StudentExamController {
	@Autowired
	private StudentExamService service;
	
	// 搜索学生考试记录，ajax传入搜索字段和搜索方式。
	// service模块获取转换成html表格的搜索结果，controller再传回ajax
	@RequestMapping(value="searchStudentExam", method=RequestMethod.POST)
	@ResponseBody
	public void searchStudentExam(String input, String option, HttpServletResponse resp) throws IOException {
		String result = service.getSearchResult(input, option);
		
		resp.setHeader("Content-Type", "text/plain;charset=utf-8");       // 设置编码类型
		PrintWriter out = resp.getWriter();
		
		out.write(result);  // 写入request
	}
}
