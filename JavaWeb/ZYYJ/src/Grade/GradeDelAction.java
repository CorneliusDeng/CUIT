package Grade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeDelAction
 */
@WebServlet("/GradeDelAction")
public class GradeDelAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		GradeDB gradedb = new GradeDB();
		String id = request.getParameter("gradeid");
		int count = gradedb.deleteGrade(id);
		response.sendRedirect(request.getContextPath()+"/GradeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
