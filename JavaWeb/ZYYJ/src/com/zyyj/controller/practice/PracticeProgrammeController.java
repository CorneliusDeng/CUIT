package com.zyyj.controller.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyyj.bean.PracticeProgramme;
import com.zyyj.service.practice.PracticeProgrammeService;

import User.UserInfo;

@Controller
public class PracticeProgrammeController {
	@Autowired
	private PracticeProgrammeService service;
	
	@RequestMapping(value="addPracticeProgramme", method=RequestMethod.POST)
	public void addPracticeProgramme(PracticeProgramme programme, HttpServletResponse resp, HttpSession session) throws IOException {
		UserInfo user = (UserInfo)session.getAttribute("user");
		
		programme.setCreator(user.getRealname());                      // 登录功能完成后从session获取添加者名字
		int status = service.addPracticeProgramme(programme);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		if(status > 0) {
			out.println("<script>alert('添加成功');");
		}
		else {
			out.println("<script>alert('添加失败');");
		}
		if(user.getPost_id() == 1) {
			out.println(" window.location='admin.jsp?externalPage=practice/manageProgramme.jsp';</script>");
		}
		else {
			out.println(" window.location='teacher.jsp?externalPage=practice/manageProgramme.jsp';</script>");
		}
		out.close();
	}
	
	@RequestMapping(value="deletePracticeProgramme", method=RequestMethod.GET)
	public void deletePracticeProgramme(String programme_id, HttpServletResponse resp, HttpSession session) throws IOException{
		UserInfo user = (UserInfo)session.getAttribute("user");
		int status = service.deletePracticeProgramme(programme_id);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(status > 0) {
			out.println("<script>alert('删除成功');");
		}
		else {
			out.println("<script>alert('删除失败');");
		}
		if(user.getPost_id() == 1) {
			out.println(" window.location='admin.jsp?externalPage=practice/manageProgramme.jsp';</script>");
		}
		else {
			out.println(" window.location='teacher.jsp?externalPage=practice/manageProgramme.jsp';</script>");
		}
		out.close();
	}
	
	
	@RequestMapping(value="updatePracticeProgramme", method=RequestMethod.POST)
	public void updatePracticeProgramme(PracticeProgramme programme, HttpServletResponse resp, HttpSession session) throws IOException{
		UserInfo user = (UserInfo)session.getAttribute("user");
		int status = service.updatePracticeProgramme(programme);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(status > 0) {
			out.println("<script>alert('修改成功');");
		}
		else {
			out.println("<script>alert('修改失败');");
		}
		if(user.getPost_id() == 1) {
			out.println(" window.location='admin.jsp?externalPage=practice/manageProgramme.jsp';</script>");
		}
		else {
			out.println(" window.location='teacher.jsp?externalPage=practice/manageProgramme.jsp';</script>");
		}
		out.close();
	}
	
	
	@RequestMapping(value="getPracticeProgramme", method=RequestMethod.POST)
	@ResponseBody
	public void getPracticeProgramme(String programme_id, HttpServletResponse resp) throws IOException{
		String json = service.getPracticeProgramme(programme_id);
		System.out.println(json);
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write(json);
		out.close();
	}
	
	@RequestMapping(value="searchPracticeProgramme", method=RequestMethod.POST)
	@ResponseBody
	public void searchPracticeProgramme(String input, String option, HttpServletResponse resp) throws IOException{
		String result = service.getSearchResult(input, option);
		resp.setContentType("text/plaine;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write(result);
		out.close();
	}
}
