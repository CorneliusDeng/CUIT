package Class;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassInsertAction
 */
@WebServlet("/ClassInsertAction")
public class ClassInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		ClassInfo testclass = new ClassInfo();
		ClassDB classdb = new ClassDB();
		testclass.setClassid(request.getParameter("id"));
		testclass.setGradeid(request.getParameter("grade"));
		testclass.setName(request.getParameter("name"));
		testclass.setComment(request.getParameter("note"));
		classdb.Classinsert(testclass);
		response.sendRedirect(request.getContextPath()+"/ClassListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
