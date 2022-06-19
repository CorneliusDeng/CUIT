package Student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDelAction
 */
@WebServlet("/StudentDelAction")
public class StudentDelAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		StudentDB studentdb = new StudentDB();
		String id = request.getParameter("studentid"); 
		int count = studentdb.deleteStudent(id);
		response.sendRedirect(request.getContextPath()+"/StudentListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
