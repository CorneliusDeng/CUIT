package Major;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajorGetAction
 */
@WebServlet("/MajorGetAction")
public class MajorGetAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String majorid = request.getParameter("majorid"); 
		MajorDB majordb = new MajorDB();
		String json = majordb.UpdategetMajorById(majorid);
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
