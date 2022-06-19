package teach;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.MyTools;
import java.util.*;

/**
 * Servlet implementation class CourseInsertAction
 */
@WebServlet("/TeachInsertAction")
public class TeachInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response); //调用doPost方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeachInfo teach=new TeachInfo();		
		teach.setTeacherId(MyTools.strToint(request.getParameter("teacherId")));
		teach.setCourseId(MyTools.strToint(request.getParameter("courseId")));
		TeachDB beanDB=new TeachDB();
		beanDB.insert(teach); 
		response.sendRedirect(request.getContextPath()+"/TeachListAction");
	}

}
