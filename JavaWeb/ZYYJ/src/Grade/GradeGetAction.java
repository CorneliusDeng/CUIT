package Grade;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeGetAction
 */
@WebServlet("/GradeGetAction")
public class GradeGetAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String gradeid = request.getParameter("gradeID");
		GradeDB gradedb = new GradeDB();
		String json = gradedb.UpdategetGradeById(gradeid);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
