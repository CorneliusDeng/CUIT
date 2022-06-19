package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//课程信息修改功能C层
@WebServlet("/CourseUpdateAction")
public class CourseUpdateAction extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//1、获取客户端提交数据，存放在一个课程信息对象中
		CourseDB beanDB=new CourseDB();
		CourseInfo course=new CourseInfo();
		course.setCourseID(MyTools.toint(request.getParameter("id")));
		course.setName(MyTools.toChinese(request.getParameter("coursename")));
		course.setType(MyTools.toint(request.getParameter("nature")));
		course.setCredit(MyTools.toFloat(request.getParameter("credit")));
		course.setGrade(MyTools.toint(request.getParameter("grade")));
		course.setMajor(MyTools.toint(request.getParameter("major")));
		course.setDetail(MyTools.toChinese(request.getParameter("detail")));
		//2、更新数据
		beanDB.update(course);	
		//3、向客户端做出响应，重定向到课程信息列表显示界面 
		response.sendRedirect(request.getContextPath()+"/CourseListAction");

	}
}
