package department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import College.CollegeDB;
import College.CollegeInfo;

/**
 * Servlet implementation class DepartmentInsertAction
 */
@WebServlet("/DepartmentInsertAction")
public class DepartmentInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		DepartmentInfo department = new DepartmentInfo();
		department.setDepartmentid(request.getParameter("departmentid"));
		department.setCollegeid(request.getParameter("collegeid"));
		department.setName(request.getParameter("name"));
		department.setComment(request.getParameter("comment"));
		DepartmentDB departmentdb = new DepartmentDB(); 
		departmentdb.Departmentinsert(department);
		response.sendRedirect(request.getContextPath()+"/DepartmentListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
