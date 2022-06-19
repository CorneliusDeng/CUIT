package department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import College.CollegeDB;
import College.CollegeInfo;
import common.MyTools;

/**
 * Servlet implementation class DepartmentUpdateAction
 */
@WebServlet("/DepartmentUpdateAction")
public class DepartmentUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		DepartmentDB departmentdb = new DepartmentDB();
		DepartmentInfo department = new DepartmentInfo();
		department.setDepartmentid(request.getParameter("id"));
		department.setCollegeid(request.getParameter("college"));
		department.setName(request.getParameter("name"));
		department.setComment(request.getParameter("note"));
		departmentdb.update(department);
		response.sendRedirect(request.getContextPath()+"/DepartmentListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
