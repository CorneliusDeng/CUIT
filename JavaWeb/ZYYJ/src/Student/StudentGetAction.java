package Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentGetAction
 */
@WebServlet("/StudentGetAction")
public class StudentGetAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String id = request.getParameter("studentID");
		StudentDB studentdb = new StudentDB();
		String json = studentdb.UpdategetStudentById(id);
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
