package knowledgepoint;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/knowledgeListAction")
public class knowledgeListAction extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		knowledgeDB knowledgeDB = new knowledgeDB();
		request.getSession().setAttribute("knowledgeList1",knowledgeDB.getAll());
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='teacher.jsp?externalPage=study/manageKnowledgepoint.jsp';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
