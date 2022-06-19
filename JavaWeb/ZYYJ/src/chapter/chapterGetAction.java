package chapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chapterGetAction
 */
@WebServlet("/chapterGetAction")
public class chapterGetAction extends HttpServlet 
{
	private chapterDB chapterdb = new chapterDB();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String chapter_id = request.getParameter("chapter_id"); 
		String json = chapterdb.UpdategetChapterById(chapter_id);
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
