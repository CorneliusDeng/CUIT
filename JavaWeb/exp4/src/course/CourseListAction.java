package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

//课程信息查询显示功能C层
@WebServlet("/CourseListAction")
public class CourseListAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//调用doPost方法
		doPost(request,response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//先调用CourseDB中的方法获取所有课程信息集合数组，将此数组保存为会话级变量，重定向到V层
		CourseDB beanDB=new CourseDB();
		request.getSession().setAttribute("courseList",beanDB.getAll());
		response.sendRedirect(request.getContextPath()+"/course/course_list.jsp");
	}
}
