package Grade;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeListAction
 */
@WebServlet("/GradeListAction")
public class GradeListAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		GradeDB gradedb = new GradeDB();
		request.getSession().setAttribute("gradeList",gradedb.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='admin.jsp?externalPage=student/manageGrade.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
