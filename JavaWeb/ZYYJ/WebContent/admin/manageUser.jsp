<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,User.*" %>
<%
	ArrayList<UserInfo> userlist = (ArrayList<UserInfo>)session.getAttribute("UserList");
	
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>用户管理</h1>
	</div>
	<div class="row">
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
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加用户</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>真实姓名</th>
			<th>角色</th>
			<th>性别</th>
			<th>电话</th>
			<th>邮箱</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < userlist.size(); i++)
			{
				UserInfo testuser = userlist.get(i);
		%>
			<tr>
				<td><%=testuser.getUser_id() %></td>
				<td><%=testuser.getName() %></td>
				<td><%=testuser.getRealname() %></td>
				<td><%=testuser.getPost_id() == 1?"管理员":"教师"%></td>
				<td><%=testuser.getGender() == 1?"女":"男" %></td>
				<td><%=testuser.getPhone() %></td>
				<td><%=testuser.getEmail() %></td>
				<td><a href="<%=request.getContextPath()%>/UserDelAction?userid=<%=testuser.getUser_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
			</tr>
		<%
			}
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
      			<h4 class="modal-title">添加新用户</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/UserInsertAction" method="post">
					<span>用户ID</span>
					<input class="form-control" type="text" name="id" placeholder="ID">
					<span>用户名</span>
					<input class="form-control" type="text" name="name" placeholder="用户名">
					<span>真实姓名</span>
					<input class="form-control" type="text" name="realname" placeholder="真实姓名">
					<span>用户身份</span>
					<select class="form-control" name="post" size="1">
						<option value="1">管理员</option>
						<option value="2">教师</option>
					</select>
					<span>用户性别</span>
					<select class="form-control" name="gender" size="1">
						<option value="1">女</option>
						<option value="2">男</option>
					</select>
					<span>登陆密码</span>
					<input class="form-control" type="text" name="password" placeholder="密码">
					<span>电话</span>
					<input class="form-control" type="text" name="phone" placeholder="电话">
					<span>邮箱</span>
					<input class="form-control" type="text" name="email" placeholder="邮箱">
					<span>用户状态</span>
					<select class="form-control" name="status" size="1">
						<option value="1">在职</option>
						<option value="2">离职</option>
					</select>
					<button class="btn btn-block btn-primary" type="submit">添加</button>
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
