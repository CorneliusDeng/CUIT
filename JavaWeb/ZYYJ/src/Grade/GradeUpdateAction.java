package Grade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeUpdateAction
 */
@WebServlet("/GradeUpdateAction")
public class GradeUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		GradeDB gradedb = new GradeDB();
		GradeInfo grade = new GradeInfo();
		grade.setGradeid(request.getParameter("id"));
		grade.setMajorid(request.getParameter("major"));
		grade.setName(request.getParameter("name"));
		grade.setComment(request.getParameter("note"));
		gradedb.update(grade);
		response.sendRedirect(request.getContextPath()+"/GradeListAction");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
