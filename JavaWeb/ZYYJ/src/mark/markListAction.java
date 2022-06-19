package mark;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class markListAction
 */
@WebServlet("/markListAction")
public class markListAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		markDB gradeDB = new markDB();
		request.getSession().setAttribute("markList1",gradeDB.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='teacher.jsp?externalPage=mark/manageMark.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
