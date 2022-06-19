package chapter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chapterListAction
 */
@WebServlet("/chapterListAction")
public class chapterListAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		chapterDB chapterDB = new chapterDB();
		request.getSession().setAttribute("chapterList1",chapterDB.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='teacher.jsp?externalPage=study/manageChapter.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
