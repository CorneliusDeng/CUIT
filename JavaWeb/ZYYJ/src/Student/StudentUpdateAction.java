package Student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class StudentUpdateAction
 */
@WebServlet("/StudentUpdateAction")
public class StudentUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		StudentInfo student = new StudentInfo();
		StudentDB studentdb = new StudentDB();
		student.setStuid(request.getParameter("id"));
		student.setAccount(request.getParameter("account"));
		student.setPassword(request.getParameter("password"));
		student.setName(request.getParameter("name"));
		student.setCalssid(request.getParameter("class"));
		student.setGender(MyTools.toint(request.getParameter("gender")));
		student.setEmail(request.getParameter("email"));
		student.setPhone(request.getParameter("phone"));
		studentdb.update(student);
		response.sendRedirect(request.getContextPath()+"/StudentListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
