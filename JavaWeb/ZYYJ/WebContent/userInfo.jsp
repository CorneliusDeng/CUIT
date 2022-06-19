<%@page import="common.MyTools"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="SingleUser.*"  %>

<%
	String userid = (String)session.getAttribute("SingleUserInfoId");
	session.setAttribute("change-userid", userid);
	SingleUserInfo user = new SingleUserDB().GetUserbyId(userid);
	String post = "";
	String gender = "";
	String status = "";
	if (user.getPost_id() == 1)
	{
		post = "管理员";
	}
	else if (user.getPost_id() == 2)
	{
		post = "教师";
	}
	
	if (user.getGender() == 1)
	{
		gender = "男";
	}
	else if (user.getGender() == 2)
	{
		gender = "女";
	}
	if (user.getStatus() == 1)
	{
		status = "在职";
	}
	else
	{
		status = "离职";
	}
%>
<div class="col-md-8 col-md-offset-2">
	<div class="row">
		<h1>用户中心</h1>
		<div class="col-md-2" align="center">
			<img class="img-circle" src="image/user.png" alt="用户头像" width="100px" height="100px"><br>
			<a href="#" data-toggle="modal" data-target="#upload-modal">修改头像</a>
		</div>
		<div class="col-md-10">
			<ul>
			<li>用户ID: <%=user.getUser_id() %></li>
			<li>角色: <%=post %></li>
			<li>用户名：<%=user.getName() %></li>
			</ul>
		</div>
	</div>
	
	<div class="row" align="right">
		<a href="#" data-toggle="modal" data-target="#changepassword-modal">修改密码</a>
		<a href="#" data-toggle="modal" data-target="#modify-modal">修改个人信息</a>
	</div>
	
	<div class="row">
		<table class="table table-striped table-hover">
		<tbody>
			<tr><td>真实姓名</td><td><%=user.getRealname() %></td></tr>
			<tr><td>性别</td><td><%=gender %></td></tr>
			<tr><td>电话</td><td><%=user.getPhone() %></td></tr>
			<tr><td>邮箱</td><td><%=user.getEmail() %></td></tr>
			<tr><td>状态</td><td><%=status %></td></tr>
		</tbody>
		</table>
	</div>
</div>


<!-- 弹出框，上传头像 -->
<div class="modal fade" id="upload-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">上传头像</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/servlet/upload" method="get">
					<input type="file" name="file">
					<button class="btn btn-primary" type="submit">上传</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">取消</a>
      		</div>
    	</div>
  	</div>
</div>


<!-- 弹出框，修改 个人信息-->
<div class="modal fade" id="changepassword-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改密码</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/ChangePassword" method="get">
					<input class="form-control" type="password" name="oldPassword" placeholder="原密码">
					<input class="form-control" type="password" name="newPassword1" placeholder="新密码">
					<input class="form-control" type="password" name="newPassword2" placeholder="确认密码">
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
<!-- 弹出框，修改 个人信息-->
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改个人信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/UserUpdateAction" method="get">
      				<input class="form-control" type="text" readonly="readonly" name="userid" placeholder="用户ID" value="<%=user.getUser_id() %>">
      				<input class="form-control" type="text" readonly="readonly" name="userpost" placeholder="用户身份" value="<%=user.getPost_id()==1?"管理员":"教师" %>">
      				<input class="form-control" type="hidden" name="userpassword" placeholder="密码" value="<%=user.getPassword()%>">
					<input class="form-control" type="text" name="uesename" placeholder="用户名" value="<%=user.getName() %>">
					<input class="form-control" type="text" name="realname" placeholder="真实姓名" value="<%=user.getRealname() %>">
					<input class="form-control" type="text"  readonly="readonly" name="gender" placeholder="性别" value="<%=user.getGender() == 1?"男":"女" %>">
					<input class="form-control" type="text" name="phone" placeholder="电话" value="<%=user.getPhone() %>">
					<input class="form-control" type="text" name="email" placeholder="邮箱" value="<%=user.getEmail() %>">
					<input class="form-control" type="text"  readonly="readonly" name="status" placeholder="状态" value="<%=user.getStatus()==1?"在职":"离职" %>">
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
