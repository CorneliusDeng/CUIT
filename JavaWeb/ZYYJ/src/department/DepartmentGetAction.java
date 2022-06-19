package department;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import College.CollegeDB;

/**
 * Servlet implementation class DepartmentGetAction
 */
@WebServlet("/DepartmentGetAction")
public class DepartmentGetAction extends HttpServlet 
{
	private DepartmentDB departmentdb = new DepartmentDB();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String departmentid = request.getParameter("departmentid"); 
		String json = departmentdb.UpdategetDepartmentById(departmentid);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
