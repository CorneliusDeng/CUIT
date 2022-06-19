package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//import login.UserInfo;

public class StudentInsertAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
	   //1����ȡ�ͻ����ύ����
	   StudentInfo student=new StudentInfo();
	   student.setStCode(request.getParameter("code"));
	   student.setStName(MyTools.toChinese(request.getParameter("name")));
	   student.setSex(MyTools.strToint(request.getParameter("sex")));
	   student.setGrade(MyTools.strToint(request.getParameter("grade")));
	   student.setMajor(MyTools.strToint(request.getParameter("major")));
	   student.setDetail(MyTools.toChinese(request.getParameter("detail")));
	  System.out.println("name="+student.getStName());
	   //2������ͻ����ύ����
		beanDB.insertStudent(student);		    
	   //3����ͻ���������Ӧ 
	   response.sendRedirect(request.getContextPath()+"/servlet/StudentListAction");

	}


}
