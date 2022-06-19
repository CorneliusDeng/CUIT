package chapter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.MyTools;

/**
 * Servlet implementation class chapterUpdateAction
 */
@WebServlet("/chapterUpdateAction")
public class chapterUpdateAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		chapterDB chapterdb = new chapterDB();
		chapterInfo chapter = new chapterInfo();
		chapter.setChapter_id(request.getParameter("chapter_id"));
		chapter.setCourse_id(request.getParameter("course_id"));
		chapter.setName(request.getParameter("name"));
		chapter.setPhoto(request.getParameter("photo"));
		chapter.setComment(request.getParameter("comment"));
		chapterdb.update(chapter);
		response.sendRedirect(request.getContextPath()+"/chapterListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
