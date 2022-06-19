package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.*;

//课程信息添加功能C层
@WebServlet("/CourseInsertAction")
public class CourseInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// 1 获取客户端提交的数据，将获取到的数据保存到一个课程信息对象中
		CourseInfo course = new CourseInfo();
		course.setName(MyTools.toChinese(request.getParameter("coursename")));
		course.setType(MyTools.toint(request.getParameter("nature")));
		course.setCredit(MyTools.toFloat(request.getParameter("credit")));
		course.setGrade(MyTools.toint(request.getParameter("grade")));
		course.setMajor(MyTools.toint(request.getParameter("major")));
		course.setDetail(MyTools.toChinese(request.getParameter("detail")));
		
		// 2 处理客户端提交的数据，调用CourseDB插入新对象的方法实现新课程的添加
		CourseDB courseDB = new CourseDB();
		courseDB.insert(course);
		
		//3 向客户端作出响应，重定向到查询显示课程信息列表的Servlet
		response.sendRedirect(request.getContextPath()+"/CourseListAction");
	}

}
