package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//import login.UserInfo;

public class StudentGetAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
		//1、获取客户端请求
		int id=Integer.parseInt(request.getParameter("id"));
		//2、进行数据处理
		StudentInfo student=beanDB.getStudentById(id);
	 	//3、向客户端做出响应
		response.setContentType("application/json;charset=UTF-8");	//设置响应的内容类型及编码方式
		PrintWriter out = response.getWriter();	//获取输出流对象
		/*********************获取学生信息****************************/
		String jsonData="";	
		jsonData="{\"id\":"+student.getStID()+",\"code\":\""+student.getStCode()+"\",\"name\":\""+student.getStName()+"\",\"sex\":"+student.getSex()+",\"grade\":"+student.getGrade()+",\"major\":\""+student.getMajor()+"\",\"detail\":\""+student.getDetail()+"\"}";
		//System.out.println(jsonData);	
		out.println(jsonData);	
		out.flush();
		out.close();	//关闭输出流对象	
	}
}
