package question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class questionUpdateAction
 */
@WebServlet("/questionUpdateAction")
public class questionUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		questionDB questiondb = new questionDB();
		questionInfo question = new questionInfo();
		question.setQuestion_id(request.getParameter("question_id"));
		question.setCourse_id(request.getParameter("course_id"));
		question.setProgramme_id(request.getParameter("programme_id"));
		question.setExam_id(request.getParameter("exam_id"));
		question.setQuestion_type(request.getParameter("question_type"));
		question.setLevel(MyTools.toint(request.getParameter("level")));
		question.setQuestion(request.getParameter("question"));
		question.setAnswer1(request.getParameter("answer1"));
		question.setAnswer2(request.getParameter("answer2"));
		question.setAnswer3(request.getParameter("answer3"));
		question.setAnswer4(request.getParameter("answer4"));
		question.setRightanswer(request.getParameter("rightanswer"));
		question.setComment(request.getParameter("comment"));
		questiondb.update(question);/*****************************************************/
		response.sendRedirect(request.getContextPath()+"/questionListAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
