<%@page import="com.github.pagehelper.PageInfo"%>
<%@page import="com.zyyj.bean.StudentExam"%>
<%@page import="java.util.List"%>
<%@page import="com.zyyj.service.exam.StudentExamService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	StudentExamService service = ac.getBean("studentExamServiceImpl", StudentExamService.class);
	
	List<StudentExam> list = service.getAllStudentExams();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>学生考试记录</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="javascript:search('searchStudentExam', 'exam/studentExam.jsp')">
				<div class="input-group">
      				<input type="text" id="search-input" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
      				<select name="search-type" id="search-option" class="form-control" style="margin-left:20px;">
						<option value="1">按学生姓名搜索</option>
						<option value="2">按班级搜索</option>
						<option value="3">按考试方案搜索</option>
					</select>
    			</div>
			</form>
		</div>
		<div class="col-md-7" align="right" id="add-button">
		
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>记录编号</th><th>学生</th><th>考试方案</th><th>是否通过</th><th>创建时间</th><th>分数</th><th>科目</th></tr>
		</thead>
		<tbody id="table-tbody">
			<%
			for(StudentExam s : list){%>
				<tr><td><%=s.getPractice_id() %></td><td><%=s.getStu_name() %></td><td><%=s.getExam_name() %></td>
				<td><%=s.getStatus()==1?"是":"否" %></td><td><%=s.getCreatetime() %></td><td><%=s.getScore() %></td><td><%=s.getCourse_name() %></td></tr>
			<%}
			%>
		</tbody>
		</table>
	</div>
</div>