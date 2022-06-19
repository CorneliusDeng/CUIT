package College;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import College.*;

/**
 * Servlet implementation class CollegeListAction
 */
public class CollegeListAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CollegeDB collegeDB = new CollegeDB();
		request.getSession().setAttribute("collegeList1",collegeDB.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='admin.jsp?externalPage=/ZYYJ/admin/manageCollege.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
