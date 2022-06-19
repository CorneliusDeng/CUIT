package Class;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassGetAction
 */
@WebServlet("/ClassGetAction")
public class ClassGetAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String classid = request.getParameter("classID");
		ClassDB classdb = new ClassDB();
		String json = classdb.UpdategetClassById(classid);
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
