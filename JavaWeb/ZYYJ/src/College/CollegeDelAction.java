package College;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CollegeDelAction")
public class CollegeDelAction extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		CollegeDB collegedb = new CollegeDB();
		String id = request.getParameter("collegeid");  
		int count = collegedb.deleteCollege(id);
		response.sendRedirect(request.getContextPath()+"/CollegeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
