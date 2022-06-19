package Major;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MajorListAction")
public class MajorListAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		MajorDB majordb = new MajorDB();
		request.getSession().setAttribute("majorList",majordb.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='admin.jsp?externalPage=student/manageMajor.jsp';</script>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
