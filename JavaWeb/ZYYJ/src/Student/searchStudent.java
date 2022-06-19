package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchPracticeProgramme
 */
@WebServlet("/searchStudent")
public class searchStudent extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String input = (String)request.getParameter("input");
		String option = (String)request.getParameter("option");
		ArrayList<SearchStudentInfo> studentlist = new ArrayList<SearchStudentInfo>();
		StudentDB studentdb = new StudentDB();
		studentlist = studentdb.getSearchStuInfo(input, option);
		StringBuilder table = new StringBuilder();
		for (SearchStudentInfo tempInfo : studentlist)
		{
			table.append("<tr><td>" + tempInfo.getStuid() + "</td>");
			table.append("<td>"+ tempInfo.getAccount() + "</td>");
			table.append("<td>"+ tempInfo.getClassname() + "</td>");
			table.append("<td>"+ tempInfo.getGradename() + "</td>");
			table.append("<td>"+ tempInfo.getMajorname() + "</td>");
			table.append("<td>"+ tempInfo.getCollegename() + "</td>");
			table.append("<td>"+ tempInfo.getName() + "</td>");
			table.append("<td>"+ (tempInfo.getGender()==1?"男":"女") + "</td>");
			table.append("<td>"+ tempInfo.getEmail() + "</td>");
			table.append("<td>"+ tempInfo.getPhone() + "</td>");
			table.append("<td><a href=\"#\" data-toggle=\"modal\" data-target=\"#modify-modal\" onclick=\"javascript:updateStudentInfo('<%=teststudent.getStuid() %>')\"><span class=\"glyphicon glyphicon-pencil\"> 修改</span></a></td>");
			table.append("<td><a href=\"<%=request.getContextPath()%>/StudentDelAction?studentid=<%=teststudent.getStuid()%>\"><span class=\"glyphicon glyphicon-trash\"> 删除</span></a></td>");
		}
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(table.toString());
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
