package question;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class questionListAction
 */
@WebServlet("/questionListAction")//ע�ͷ�����Servlet
public class questionListAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		questionDB questionDB = new questionDB();
		request.getSession().setAttribute("questionList1",questionDB.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='teacher.jsp?externalPage=study/manageQuestion.jsp';</script>");/***************************/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
