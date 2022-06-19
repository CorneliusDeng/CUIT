package College;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import common.MyTools;

/**
 * Servlet implementation class CollegeUpdateAction
 */
@WebServlet("/CollegeUpdateAction")
public class CollegeUpdateAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CollegeDB collegedb = new CollegeDB();
		CollegeInfo college = new CollegeInfo();
		college.setCollegid(request.getParameter("collegeid"));
		college.setCollegename(request.getParameter("collegename"));
		college.setCollegedetail(request.getParameter("collegenote"));
		collegedb.update(college);
		response.sendRedirect(request.getContextPath()+"/CollegeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
