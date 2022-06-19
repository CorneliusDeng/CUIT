package knowledgepoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.MyTools;

@WebServlet("/knowledgeUpdateAction")
public class knowledgeUpdateAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		knowledgeDB knowledgedb = new knowledgeDB();
		knowledgepointInfo knowledge = new knowledgepointInfo();
		knowledge.setKnow_id(request.getParameter("know_id"));
		knowledge.setCourse_id(request.getParameter("course_id"));
		knowledge.setName(request.getParameter("name"));
		knowledge.setComment(request.getParameter("comment"));
		knowledgedb.update(knowledge);
		response.sendRedirect(request.getContextPath()+"/knowledgeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
