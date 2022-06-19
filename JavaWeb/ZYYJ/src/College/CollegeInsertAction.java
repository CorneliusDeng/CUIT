package College;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.*;

@WebServlet("/CollegeInsertAction")
public class CollegeInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CollegeInfo college = new CollegeInfo();
		college.setCollegid(request.getParameter("id"));
		college.setCollegename(request.getParameter("name"));
		college.setCollegedetail(request.getParameter("note"));
		
		CollegeDB collegedb = new CollegeDB();
		collegedb.Collegeinsert(college);
		response.sendRedirect(request.getContextPath()+"/CollegeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
