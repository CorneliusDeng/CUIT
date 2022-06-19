package Course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CourseDelAction")
public class CourseDelAction extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		CourseDB coursedb = new CourseDB();
		String id = request.getParameter("course_id");  
		int count = coursedb.deleteCourse(id); 
		response.sendRedirect(request.getContextPath()+"/CourseListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
