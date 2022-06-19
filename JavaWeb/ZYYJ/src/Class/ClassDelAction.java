package Class;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassDelAction
 */
@WebServlet("/ClassDelAction")
public class ClassDelAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		ClassDB classdb = new ClassDB();
		String id = request.getParameter("classid"); 
		int count = classdb.deleteClass(id);
		response.sendRedirect(request.getContextPath()+"/ClassListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
