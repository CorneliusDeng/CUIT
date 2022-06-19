package College;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CollegeGetAction
 */
@WebServlet("/CollegeGetAction")
public class CollegeGetAction extends HttpServlet 
{
	private CollegeDB collegedb = new CollegeDB();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String collegeid = request.getParameter("collegid"); 
		String json = collegedb.UpdategetCollegeById(collegeid);
		System.out.println(json);
		resp.setContentType("text/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(json);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
