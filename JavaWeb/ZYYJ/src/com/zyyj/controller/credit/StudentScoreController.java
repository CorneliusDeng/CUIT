package com.zyyj.controller.credit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyyj.service.credit.StudentScoreService;

@Controller
public class StudentScoreController {
	@Autowired
	private StudentScoreService service;
	
	@RequestMapping(value="searchStudentScore", method=RequestMethod.POST)
	@ResponseBody
	public void searchStudentScore(String input, String option, HttpServletResponse resp) throws IOException {
		String result = service.getSearchResult(input, option);
		
		resp.setHeader("Content-Type", "text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write(result);
		out.close();
	}
}
