package SingleUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SingleUser.*; 

@WebServlet("/UserInfoAction")
public class UserInfoAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String userid = (String)request.getSession().getAttribute("SingleUserInfoId");
		SingleUserInfo user = new SingleUserDB().GetUserbyId(userid);
		System.out.println("USERINFOACTION USERID:"+user.getUser_id());
		request.getSession().setAttribute("SingleUserInfoId", user.getUser_id());
		PrintWriter out = response.getWriter(); out.println("<script>window.location='admin.jsp?externalPage=userInfo.jsp';</script>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
