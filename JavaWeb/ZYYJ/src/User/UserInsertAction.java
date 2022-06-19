package User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import User.*;
import common.MyTools;;

/**
 * Servlet implementation class UserInsertAction
 */
@WebServlet("/UserInsertAction")
public class UserInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		UserInfo user = new UserInfo();
		user.setUser_id(request.getParameter("id"));
		user.setPost_id(MyTools.toint(request.getParameter("post")));
		user.setName(request.getParameter("name"));
		user.setRealname(request.getParameter("realname"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("eamil"));
		user.setGender(MyTools.toint(request.getParameter("gender")));
		user.setStatus(MyTools.toint(request.getParameter("status")));
		UserDB userdb = new UserDB();
		userdb.inserUser(user);
		response.sendRedirect(request.getContextPath()+"/UserListAction");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
