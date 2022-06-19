package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//import login.UserInfo;

public class StudentDelAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
		//1、获取客户端请求
		int id=Integer.parseInt(request.getParameter("id"));		//获取客户端提交数据
		//2、进行数据处理
	 	int count=beanDB.deleteStudent(id);							//调用业务处理Bean的方法处理数据
	 	//3、向客户端做出响应
		response.sendRedirect(request.getContextPath()+"/servlet/StudentListAction" );//重定向
	}
}
