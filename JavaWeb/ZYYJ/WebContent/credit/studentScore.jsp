<%@page import="java.util.List"%>
<%@page import="com.zyyj.service.credit.StudentScoreService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.zyyj.service.credit.StudentScoreService, java.util.List, com.zyyj.bean.StudentScore" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	StudentScoreService service = ac.getBean("studentScoreServiceImpl", StudentScoreService.class);
	List<StudentScore> list = service.getAllStudentScore();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>积分排行榜</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="javascript:search('searchStudentScore', 'credit/studentScore.jsp')">
				<div class="input-group">
      				<input type="text" id="search-input" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
      				<select name="search-type" id="search-option" class="form-control" style="margin-left:20px;">
						<option value="1">按学生姓名搜索</option>
						<option value="2">按班级搜索</option>
						<option value="3">按年级搜索</option>
						<option value="4">按专业搜索</option>
						<option value="5">按学号搜索</option>
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
			<tr><th>排名</th><th>学生姓名</th><th>积分</th></tr>
		</thead>
		<tbody id="table-tbody">
			<%
			int i = 1;
			for(StudentScore ss : list){%>
				<tr>
				<td><%=i %><%if(i++ <= 3){%><span class="glyphicon glyphicon-fire top3"><%} %>
				<td><%=ss.getStudentName() %></td>
				<td><%=ss.getScore() %></td></tr>	
			<%}
			%>
		</tbody>
		</table>
	</div>
</div>
<style>
.top3{color:red;}
</style>