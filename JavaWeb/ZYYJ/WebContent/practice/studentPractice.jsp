<%@page import="com.zyyj.bean.StudentPractice"%>
<%@page import="java.util.List"%>
<%@page import="com.zyyj.service.practice.StudentPracticeService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	StudentPracticeService service = ac.getBean("studentPracticeServiceImpl", StudentPracticeService.class);
	List<StudentPractice> list = service.getAllStudentPractice();
	
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>学生练习记录</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="javascript:search('searchStudentPractice', 'practice/studentPractice.jsp')">
				<div class="input-group">
      				<input type="text" id="search-input" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
      				<select name="search-type" id="search-option" class="form-control" style="margin-left:20px;">
						<option value="1">按学生姓名搜索</option>
						<option value="2">按班级搜索</option>
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
			<tr><th>记录编号</th><th>学生</th><th>是否通关</th><th>创建时间</th><th>分数</th><th>方案</th><th>科目</th></tr>
		</thead>
		<tbody id="table-tbody">
			<%
			for(StudentPractice p : list){%>
				<tr><td><%=p.getPractice_id() %></td><td><%=p.getStuName() %></td>
				<td><%=p.getStatus()==1?"是":"否" %></td><td><%=p.getCreatetime() %></td><td><%=p.getScore() %></td>
				<td><%=p.getProgramme() %></td><td><%=p.getCourse() %></td></tr>
			<%}
			%>
		</tbody>
		</table>
	</div>
</div>