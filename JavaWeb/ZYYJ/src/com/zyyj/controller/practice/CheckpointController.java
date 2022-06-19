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

import com.zyyj.bean.Checkpoint;
import com.zyyj.service.practice.CheckpointService;

import User.UserInfo;

@Controller
public class CheckpointController {
	
	@Autowired
	private CheckpointService service;
	
	@RequestMapping(value="addCheckpoint", method=RequestMethod.POST)
	public void addCheckpoint(Checkpoint checkpoint, HttpServletResponse resp, HttpSession session) throws IOException{
		UserInfo user = (UserInfo)session.getAttribute("user");
		
		checkpoint.setCreator(user.getRealname());
		int status = service.addCheckpoint(checkpoint);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(status > 0) {
			out.println("<script>alert('添加成功');");
		}
		else {
			out.println("<script>alert('添加失败');");
		}
		if(user.getPost_id() == 1) {
			out.println(" window.location='/ZYYJ/admin.jsp?externalPage=practice/manageCheckpoint.jsp'</script>");
		}
		else {
			out.println(" window.location='/ZYYJ/teacher.jsp?externalPage=practice/manageCheckpoint.jsp'</script>");
		}
		out.close();
	}
	
	@RequestMapping(value="deleteCheckpoint", method=RequestMethod.GET)
	public void deleteCheckpoint(String checkpoint_id, HttpServletResponse resp, HttpSession session) throws IOException{
		UserInfo user = (UserInfo)session.getAttribute("user");
		int status = service.deleteCheckpoint(checkpoint_id);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(status > 0) {
			out.println("<script>alert('删除成功');");
		}
		else {
			out.println("<script>alert('删除失败');");
		}
		if(user.getPost_id() == 1) {
			out.println(" window.location='/ZYYJ/admin.jsp?externalPage=practice/manageCheckpoint.jsp'</script>");
		}
		else {
			out.println(" window.location='/ZYYJ/teacher.jsp?externalPage=practice/manageCheckpoint.jsp'</script>");
		}
		out.close();
	}
	
	@RequestMapping(value="getCheckpointJSON", method=RequestMethod.POST)
	@ResponseBody
	public void getCheckpointJSON(String checkpoint_id, HttpServletResponse resp) throws IOException{
		String json = service.getCheckpointJSON(checkpoint_id);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.write(json);
		out.close();
	}
	
	@RequestMapping(value="updateCheckpoint", method=RequestMethod.POST)
	public void updateCheckpoint(Checkpoint checkpoint, HttpServletResponse resp, HttpSession session) throws IOException{
		UserInfo user = (UserInfo)session.getAttribute("user");
		int status = service.updateCheckpoint(checkpoint);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(status > 0) {
			out.println("<script>alert('修改成功');");
		}
		else {
			out.println("<script>alert('修改失败');");
		}
		if(user.getPost_id() == 1) {
			out.println(" window.location='/ZYYJ/admin.jsp?externalPage=practice/manageCheckpoint.jsp'</script>");
		}
		else {
			out.println(" window.location='/ZYYJ/teacher.jsp?externalPage=practice/manageCheckpoint.jsp'</script>");
		}
		out.close();
	}
}
