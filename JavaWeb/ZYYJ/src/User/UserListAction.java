package User;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.*;

/**
 * Servlet implementation class UserListAction
 */
@WebServlet("/UserListAction")
public class UserListAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		UserDB userDB = new UserDB();
		request.getSession().setAttribute("UserList",userDB.GetAllUsers());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='admin.jsp?externalPage=/ZYYJ/admin/manageUser.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
