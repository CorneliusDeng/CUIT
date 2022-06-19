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
		request.getSession().setAttribute("studentinfo", student);
	 	//3、向客户端做出响应
		response.sendRedirect(request.getContextPath()+"/student/student_edit.jsp" );//重定向
	}
}
