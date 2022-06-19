package Major;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajorUpdateAction
 */
@WebServlet("/MajorUpdateAction")
public class MajorUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		MajorDB majordb = new MajorDB();
		MajorInfo major = new MajorInfo();  
		major.setMajorid(request.getParameter("id"));
		major.setCollegeid(request.getParameter("collegeid"));
		major.setName(request.getParameter("name"));
		major.setComment(request.getParameter("note"));
		majordb.update(major);
		response.sendRedirect(request.getContextPath()+"/MajorListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
