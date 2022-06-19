package question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/questionDelAction")
public class questionDelAction extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		questionDB questiondb = new questionDB();
		String id = request.getParameter("question_id");  
		int count = questiondb.deleteQuestion(id); 
		response.sendRedirect(request.getContextPath()+"/questionListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
