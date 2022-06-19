package course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;

//删除课程信息功能C层
@WebServlet("/CourseDelAction")
public class CourseDelAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CourseDB beanDB=new CourseDB();
		//1、获取客户端请求
		int id=Integer.parseInt(request.getParameter("id"));	
		//2、进行数据处理
	 	int count=beanDB.deleteCourse(id);							
	 	//3、向客户端做出响应
		response.sendRedirect(request.getContextPath()+"/CourseListAction");
	 			
	}

}
