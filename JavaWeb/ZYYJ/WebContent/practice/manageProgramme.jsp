<%@page import="com.zyyj.bean.PracticeProgramme"%>
<%@page import="java.util.List"%>
<%@page import="com.zyyj.service.practice.PracticeProgrammeService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	PracticeProgrammeService service = ac.getBean("practiceProgrammeServiceImpl", PracticeProgrammeService.class);
	List<String> courses = service.getAllCourses();
	List<PracticeProgramme> list = service.getAllPracticeProgrammes();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>练习方案管理</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="javascript:search('/ZYYJ/searchPracticeProgramme', 'practice/manageProgramme.jsp')">
				<div class="input-group">
      				<input type="text" id="search-input" name="search-input" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
      				<select class="form-control" id="search-option" name="search-option">
      					<option value="1">按方案名搜索</option>
      					<option value="2">按科目搜索</option>
      				</select>
    			</div>
			</form>
		</div>
		<div class="col-md-7" align="right" id="add-button">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新方案</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>方案编号</th><th>方案名</th><th>创建者</th><th>创建日期</th><th>总积分</th><th>所属科目</th><th>备注</th></tr>
		</thead>
		<tbody id="table-tbody">
			<%
			for(PracticeProgramme prog : list){%>
				<tr><td><%=prog.getProgramme_id() %></td><td><%=prog.getName() %></td><td><%=prog.getCreator() %></td><td><%=prog.getCreatedate() %></td>
				<td><%=prog.getScore() %></td><td><%=prog.getCourse() %></td><td><%=prog.getNote() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateModalPracticeProgramme('<%=prog.getProgramme_id()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="deletePracticeProgramme?programme_id=<%= prog.getProgramme_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td></tr>
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
      			<h4 class="modal-title">添加新练习方案</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/addPracticeProgramme" method="post">
					<input class="form-control" type="text" name="name" placeholder="方案名">
					所属科目：<select name="course" class="form-control">
						<%
						for(String course : courses){%>
							<option value="<%=course %>"><%=course %></option>
						<%}%>
					</select>
					<input class="form-control" type="text" name="score" placeholder="总积分">
					<input class="form-control" type="text" name="note" placeholder="备注">
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
      			<h4 class="modal-title">修改练习方案</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/updatePracticeProgramme" method="post">
					方案编号：<input class="form-control" type="text" id="programme_id" name="programme_id" placeholder="方案编号" readonly="readonly">
					方案名：<input class="form-control" type="text" id="name" name="name" placeholder="方案名">
					所属科目：<select name="course" class="form-control" id="course">
						<%
						for(String course : courses){%>
							<option value="<%=course %>"><%=course %></option>
						<%}%>
					</select>
					总积分：<input class="form-control" type="text" name="score" id="score" placeholder="总积分">
					备注：<input class="form-control" type="text" name="note" id="note" placeholder="备注">
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