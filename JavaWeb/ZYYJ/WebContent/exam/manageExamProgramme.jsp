<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.zyyj.bean.ExamProgramme, java.util.List" %>
<%@ page import="com.zyyj.service.exam.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	ExamProgrammeService service = ac.getBean("examProgrammeServiceImpl", ExamProgrammeService.class);
	List<ExamProgramme> list = service.getAllExamProgrammes();
	List<String> courses = service.getAllCourses();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>考试方案管理</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="javascript:search('/ZYYJ/searchExamProgramme', 'exam/manageExamProgramme.jsp')">
				<div class="input-group">
      				<input type="text" id="search-input" name="search-input" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
      				<select class="form-control" id="search-option" name="search-option">
      					<option value="1">按考试名搜索</option>
      					<option value="2">按科目搜索</option>
      				</select>
    			</div>
			</form>
		</div>
		<div class="col-md-7" align="right" id="add-button">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>编号</th><th>名称</th><th>创建者</th><th>题目数</th><th>总分</th><th>通过分数</th><th>各难度题目</th><th>答题时长</th><th>创建日期</th><th>科目</th><th>开始时间</th><th>操作</th></tr>
		</thead>
		<tbody id="table-tbody">
			<%
			for(ExamProgramme e : list){%>
				<tr><td><%=e.getExam_id() %></td><td><%=e.getName() %></td><td><%=e.getCreator()%></td><td><%=e.getTotal_question() %></td><td><%=e.getTotal_score() %></td>
				<td><%=e.getPass_score() %></td><td><%=e.getQuestion_num() %></td><td><%=e.getLimit_time() %>分钟</td><td><%=e.getCreatedate() %></td><td><%=e.getCourse() %></td>
				<td><%=e.getStart_time() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateModalExamProgramme('<%=e.getExam_id()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a>
				<a href="/ZYYJ/deleteExamProgramme?exam_id=<%=e.getExam_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td></tr>
			<%}
			%>
		</tbody>
		</table>
	</div>
</div>


<!-- 弹出框，添加 -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新考试方案</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/addExamProgramme" method="post">
					<input class="form-control" type="text" name="name" placeholder="考试方案名">
					<input class="form-control" type="text" name="total_question" placeholder="题目总数">
					<input class="form-control" type="text" name="total_score" placeholder="总分">
					<input class="form-control" type="text" name="pass_score" placeholder="通过分数">
					<input class="form-control" type="text" name="question_num" placeholder="各种难度题目数（;隔开）">
					<input class="form-control" type="text" name="limit_time" placeholder="答题时长（分钟）">
					科目：<select class="form-control" name="course">
						<%
						for(String course : courses){%>
							<option value="<%=course %>"><%=course %></option>	
						<%}
						%>
					</select>
					开始时间：
					<input class="form-control" type="date" name="start_time">
					<button class="btn btn-primary btn-block" type="submit">添加</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">取消</a>
      		</div>
    	</div>
  	</div>
  	<style>
  	.form-control{margin-bottom:20px;}
  	</style>
</div>

<!-- 弹出框，修改 -->
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改考试方案信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/updateExamProgramme" method="post">
      				方案编号：<input class="form-control" type="text" name="exam_id" id="exam_id" readonly>
					考试方案名：<input class="form-control" type="text" id="name" name="name" placeholder="考试方案名">
					题目总数：<input class="form-control" type="text" id="total_question" name="total_question" placeholder="题目总数">
					总分：<input class="form-control" type="text" id="total_score" name="total_score" placeholder="总分">
					通过分数：<input class="form-control" type="text" id="pass_score" name="pass_score" placeholder="通过分数">
					各种难度题目数：<input class="form-control" type="text" id="question_num" name="question_num" placeholder="各种难度题目数（;隔开）">
					答题时长：<input class="form-control" type="text" id="limit_time" name="limit_time" placeholder="答题时长（分钟）">
					科目：<select class="form-control" id="course" name="course">
						<%
						for(String course : courses){%>
							<option value="<%=course %>"><%=course %></option>	
						<%}
						%>
					</select>
					开始时间：
					<input class="form-control" type="date" name="start_time" id="start_time">
					<button class="btn btn-primary btn-block" type="submit">修改</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">取消</a>
      		</div>
    	</div>
  	</div>
  	<style>
  	.form-control{margin-bottom:20px;}
  	</style>
</div>