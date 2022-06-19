package knowledgepoint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/knowledgeGetAction")
public class knowledgeGetAction extends HttpServlet 
{
	private knowledgeDB knowledgedb = new knowledgeDB();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String knowledgeid = request.getParameter("know_id"); 
		String json = knowledgedb.UpdategetKnowledgepointById(knowledgeid);
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
