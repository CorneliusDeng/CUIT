package teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class StudentCodeCheckAction
 */
@WebServlet("/servlet/TeacherNameCheckAction")
public class TeacherNameCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherNameCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Teacherid=MyTools.strToint(request.getParameter("id"));
		String TeacherName=request.getParameter("name");
		TeacherDB beanDB=new TeacherDB();	
		int count=beanDB.getTeacherCountByName(TeacherName, Teacherid);
		response.setContentType("text/html;charset=UTF-8");	//����text 
		PrintWriter out = response.getWriter();
	    if(count!=0){
	    	out.print("1");//out.println("1");  
	    	//����ֱ�ӱȽϵļ����ݲ�����out.println���������صĻ��з�
	    }else{
	    	out.print("0");
	    }	
	}

}
