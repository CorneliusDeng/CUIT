package question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.*;

@WebServlet("/questionInsertAction")
public class questionInsertAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		questionInfo question = new questionInfo();
		question.setQuestion_id(MyTools.toChinese(request.getParameter("question_id")));
		question.setCourse_id(MyTools.toChinese(request.getParameter("course_id")));
		question.setProgramme_id(MyTools.toChinese(request.getParameter("programme_id")));
		question.setExam_id(MyTools.toChinese(request.getParameter("exam_id")));
		question.setQuestion_type(MyTools.toChinese(request.getParameter("question_type")));
		question.setLevel(MyTools.toint(request.getParameter("level")));
		question.setQuestion(MyTools.toChinese(request.getParameter("question")));
		question.setAnswer1(MyTools.toChinese(request.getParameter("answer1")));
		question.setAnswer2(MyTools.toChinese(request.getParameter("answer2")));
		question.setAnswer3(MyTools.toChinese(request.getParameter("answer3")));
		question.setAnswer4(MyTools.toChinese(request.getParameter("answer4")));
		question.setRightanswer(MyTools.toChinese(request.getParameter("rightanswer")));
		question.setComment(MyTools.toChinese(request.getParameter("comment")));
		
		questionDB questiondb = new questionDB();
		questiondb.questioninsert(question);/*************************************************/
		response.sendRedirect(request.getContextPath()+"/questionListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
