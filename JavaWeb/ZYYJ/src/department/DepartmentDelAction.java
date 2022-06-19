package department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import College.CollegeDB;

/**
 * Servlet implementation class DepartmentDelAction
 */
@WebServlet("/DepartmentDelAction")
public class DepartmentDelAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		DepartmentDB departmentdb = new DepartmentDB();
		String id = request.getParameter("departmentid");  
		int count = departmentdb.deleteDepartment(id); 
		response.sendRedirect(request.getContextPath()+"/DepartmentListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
