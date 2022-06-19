package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

//import login.UserInfo;

public class StudentUpdateAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDB beanDB=new StudentDB();
		//1����ȡ�ͻ�������
	   StudentInfo student=new StudentInfo();
	   student.setStID(MyTools.strToint(request.getParameter("id")));
	   student.setStCode(request.getParameter("code"));
//	   student.setStName(MyTools.toChinese(request.getParameter("name")));
	   student.setStName(request.getParameter("name"));
	   student.setSex(MyTools.strToint(request.getParameter("sex")));
	   student.setGrade(MyTools.strToint(request.getParameter("grade")));
	   student.setMajor(MyTools.strToint(request.getParameter("major")));
//	   student.setDetail(MyTools.toChinese(request.getParameter("detail")));
	   student.setDetail(request.getParameter("detail"));
		//2���������ݴ���
	 	int count=0;
	 	if(student.getStID()==-1) {
	 		count=beanDB.insertStudent(student);		
	 	}else {
	 		count=beanDB.updateStudent(student);			//����ҵ����Bean�ķ�����������	 		
	 	}
	 	//3����ͻ���������Ӧ
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
