package com.zyyj.controller.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyyj.service.practice.StudentPracticeService;

@Controller
public class StudentPracticeController {
	
	@Autowired
	private StudentPracticeService service;
	
	@RequestMapping(value="searchStudentPractice", method=RequestMethod.POST)
	public void searchStudentPractice(String input, String option, HttpServletResponse resp) throws IOException {
		String result = service.getSearchResult(input, option);
		
		resp.setHeader("Content-Type", "text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write(result);
	}
}
