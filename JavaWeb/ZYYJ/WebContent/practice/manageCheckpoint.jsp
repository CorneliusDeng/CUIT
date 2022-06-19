<%@page import="com.zyyj.bean.Checkpoint"%>
<%@page import="java.util.List"%>
<%@page import="com.zyyj.service.practice.CheckpointService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	CheckpointService service = ac.getBean("checkpointServiceImpl", CheckpointService.class);
	List<Checkpoint> list = service.getAllCheckpoints();
	List<String> programmes = service.getAllProgrammes();
	
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>练习关卡管理</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<!-- <div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="search" method="get">
				<div class="input-group">
      				<input type="text" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
    			</div>
			</form>
		</div> -->
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新关卡</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>关卡编号</th><th>关卡名</th><th>创建者</th><th>所属方案</th><th>限制时间（分钟）</th><th>各种难度题目量</th><th>总分</th><th>通关分数</th><th>备注</th></tr>
		</thead>
		<tbody>
			<%
			for(Checkpoint c : list){%>
				<tr><td><%=c.getCheckpoint_id() %></td><td><%=c.getName() %></td><td><%=c.getCreator() %></td><td><%=c.getProgramme() %></td>
				<td><%=c.getLimit_time() %></td><td><%=c.getQuestion_num() %></td><td><%=c.getTotal_score() %></td><td><%=c.getPass_score() %></td><td><%=c.getComment() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateModalCheckpoint('<%=c.getCheckpoint_id()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="/ZYYJ/deleteCheckpoint?checkpoint_id=<%=c.getCheckpoint_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td></tr>
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
      			<h4 class="modal-title">添加新关卡</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/addCheckpoint" method="post">
					<input class="form-control" type="text" name="name" placeholder="关卡名">
					所属练习方案：<select class="form-control" name="programme">
					<%
					for(String p : programmes){%>
						<option value="<%=p %>"><%=p %></option>	
					<%}
					%>
					</select>
					<input class="form-control" type="text" name="limit_time" placeholder="限制时间（分钟)">
					<input class="form-control" type="text" name="question_num" placeholder="各种难度题目数量（；隔开）">
					<input class="form-control" type="text" name="total_score" placeholder="总分">
					<input class="form-control" type="text" name="pass_score" placeholder="通关分数">
					<input class="form-control" type="text" name="comment" placeholder="备注">
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
      			<h4 class="modal-title">修改关卡信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/updateCheckpoint" method="post">
      				关卡编号：<input class="form-control" id="checkpoint_id" name="checkpoint_id" readonly="readonly">
					关卡名：<input class="form-control" type="text" id="name" name="name" placeholder="关卡名">
					所属练习方案：<select class="form-control" id="programme" name="programme">
					<%
					for(String p : programmes){%>
						<option value="<%=p %>"><%=p %></option>	
					<%}
					%>
					</select>
					限制时间（分钟）<input class="form-control" type="text" id="limit_time" name="limit_time" placeholder="限制时间（分钟)">
					各种难度题目数（；隔开）：<input class="form-control" type="text" id="question_num" name="question_num" placeholder="各种难度题目数量（；隔开）">
					总分：<input class="form-control" type="text" id="total_score" name="total_score" placeholder="总分">
					通关分数：<input class="form-control" type="text" id="pass_score" name="pass_score" placeholder="通关分数">
					备注：<input class="form-control" type="text" id="comment" name="comment" placeholder="备注">
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