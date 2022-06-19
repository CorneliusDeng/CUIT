package Class;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClassListAction")
public class ClassListAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		ClassDB classdb = new ClassDB();
		request.getSession().setAttribute("classList",classdb.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='admin.jsp?externalPage=student/manageClass.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
