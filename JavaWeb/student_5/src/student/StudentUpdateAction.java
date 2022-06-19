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
		//1、获取客户端请求
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
		//2、进行数据处理
	 	int count=0;
	 	if(student.getStID()==-1) {
	 		count=beanDB.insertStudent(student);		
	 	}else {
	 		count=beanDB.updateStudent(student);			//调用业务处理Bean的方法处理数据	 		
	 	}
	 	//3、向客户端做出响应
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
	    if(count!=0){
	    	out.print("1");//out.println("1");  
	    	//用于直接比较的简单数据不能用out.println，包含隐藏的换行符
	    }else{
	    	out.print("0");
	    }	
	 }

}
