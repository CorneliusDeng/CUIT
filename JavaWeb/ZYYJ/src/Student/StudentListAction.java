package Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentListAction
 */
@WebServlet("/StudentListAction")
public class StudentListAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		StudentDB studentdb = new StudentDB();
		request.getSession().setAttribute("studentList",studentdb.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='admin.jsp?externalPage=student/manageStudent.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
