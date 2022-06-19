package Course;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseListAction
 */
@WebServlet("/CourseListAction")
public class CourseListAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CourseDB courseDB = new CourseDB();
		request.getSession().setAttribute("courseList1",courseDB.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='teacher.jsp?externalPage=study/manageCourse.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
