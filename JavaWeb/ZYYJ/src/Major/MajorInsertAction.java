package Major;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajorInsertAction
 */
@WebServlet("/MajorInsertAction")
public class MajorInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		MajorInfo major = new MajorInfo();
		major.setMajorid(request.getParameter("majorid"));
		major.setCollegeid(request.getParameter("collegeid"));
		major.setName(request.getParameter("name"));
		major.setComment(request.getParameter("note"));
		MajorDB majordb = new MajorDB();
		majordb.Majorinsert(major); 
		response.sendRedirect(request.getContextPath()+"/MajorListAction");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
