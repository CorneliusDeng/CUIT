package knowledgepoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.*;

@WebServlet("/knowledgeInsertAction")
public class knowledgeInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		knowledgepointInfo knowledge = new knowledgepointInfo();
		knowledge.setKnow_id(request.getParameter("know_id"));
		knowledge.setCourse_id(request.getParameter("course_id"));
		knowledge.setName(request.getParameter("name"));
		knowledge.setComment(request.getParameter("comment"));
		
		knowledgeDB knowledgedb = new knowledgeDB();
		knowledgedb.knowledgepointinsert(knowledge);
		response.sendRedirect(request.getContextPath()+"/knowledgeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
