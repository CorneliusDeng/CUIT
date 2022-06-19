package Grade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeInsertAction
 */
@WebServlet("/GradeInsertAction")
public class GradeInsertAction extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		GradeInfo grade = new GradeInfo();
		GradeDB gradedb = new GradeDB();
		grade.setGradeid(request.getParameter("gradeid"));
		grade.setMajorid(request.getParameter("majorid"));
		grade.setName(request.getParameter("name"));
		grade.setComment(request.getParameter("note"));
		gradedb.Gradeinsert(grade);
		response.sendRedirect(request.getContextPath()+"/GradeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
