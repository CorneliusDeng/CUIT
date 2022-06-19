package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class UserDeleteAction
 */
@WebServlet("/UserDeleteAction")
public class UserDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = MyTools.strToint(request.getParameter("userId"));
		UserDB bean = new UserDB();
		bean.delete(userid);
		response.sendRedirect(request.getContextPath()+"/UserListAction");
		
	}

}
