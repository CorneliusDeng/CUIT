package question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CollegeGetAction
 */
@WebServlet("/questionGetAction")
public class questionGetAction extends HttpServlet 
{
	private questionDB questiondb = new questionDB();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String question_id = request.getParameter("question_id"); 
		String json = questiondb.UpdategetQuestionById(question_id);
		System.out.println(json);
		resp.setContentType("text/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(json);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
