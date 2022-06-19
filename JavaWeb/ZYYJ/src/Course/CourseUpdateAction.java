package Course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class CourseUpdateAction
 */
@WebServlet("/CourseUpdateAction")
public class CourseUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CourseDB coursedb = new CourseDB();
		CourseInfo course = new CourseInfo();
		course.setCourse_id(request.getParameter("course_id"));
		course.setUser_id(request.getParameter("user_id"));
		course.setName(request.getParameter("name"));
		course.setIntroduction(request.getParameter("introduction"));
		course.setPhoto(request.getParameter("photo"));
		course.setPractice_count(MyTools.toint(request.getParameter("pracitice_count")));
		coursedb.update(course);
		response.sendRedirect(request.getContextPath()+"/CourseListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
