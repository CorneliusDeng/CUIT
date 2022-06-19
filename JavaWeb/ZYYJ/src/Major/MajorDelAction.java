package Major;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajorDelAction
 */
@WebServlet("/MajorDelAction")
public class MajorDelAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		MajorDB majordb = new MajorDB();
		String id = request.getParameter("majorid");
		int count = majordb.deleteMajor(id);
		response.sendRedirect(request.getContextPath()+"/MajorListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
