package knowledgepoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/knowledgeDelAction")
public class knowledgeDelAction extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		knowledgeDB knowledgedb = new knowledgeDB();
		String id = request.getParameter("know_id");  
		int count = knowledgedb.deleteKnowledgepoint(id); 
		response.sendRedirect(request.getContextPath()+"/knowledgeListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
