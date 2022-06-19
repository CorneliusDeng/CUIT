package course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 查询出待修改的课程信息C层
@WebServlet("/CourseGetAction")
public class CourseGetAction extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		CourseDB beanDB=new CourseDB();
		//1、获取客户端请求的课程信息ID
		int id = Integer.parseInt(request.getParameter("id"));
		//2、进行数据处理，获取指定课程的其他信息
		CourseInfo course = beanDB.getCourseById(id);
		//3、向客户端做出响应，发送出数据，重定向到课程信息列表
		request.getSession().setAttribute("Courseinfo", course);
		response.sendRedirect(request.getContextPath()+"/course/course_edit.jsp" );
	}
}
