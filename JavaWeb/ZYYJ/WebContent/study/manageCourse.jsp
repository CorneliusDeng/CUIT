<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Course.*, java.util.*" %>
<%
	ArrayList<CourseInfo> courselist = (ArrayList<CourseInfo>)session.getAttribute("courseList1");
%>

<%!
	String editid = "";
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>科目管理</h1>
	</div>
	<div class="row" align="right">
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新科目</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>科目编号</th><th>用户编号</th><th>科目名</th><th>说明</th><th>图片</th><th>练习次数</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < courselist.size(); i++)
			{
				CourseInfo testcourse = courselist.get(i);
		%>
			<tr>
				<td><%=testcourse.getCourse_id() %></td>
				<td><%=testcourse.getUser_id() %></td>
				<td><%=testcourse.getName() %></td>
				<td><%=(testcourse.getIntroduction()==null)?"":testcourse.getIntroduction() %></td>
				<td><%=testcourse.getPhoto() %></td>
				<td><%=testcourse.getPractice_count() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal"><span class="glyphicon glyphicon-pencil" onclick="javascript:updateCourseInfo('<%=testcourse.getCourse_id()%>')"> 修改</span></a></td>
				<td><a href="<%=request.getContextPath()%>/CourseDelAction?course_id=<%=testcourse.getCourse_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
			</tr>
		<%
				System.out.println("editid:"+editid);
			}
		%>
		</tbody>
		</table>
		
		<!-- 页码按钮-->
		<nav aria-label="Page navigation">
  			<ul class="pagination">
    			<li>
      				<a href="#" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
      				</a>
    			</li>
    			<li><a href="#">1</a></li>
    			<li><a href="#">2</a></li>
    			<li><a href="#">3</a></li>
    			<li><a href="#">4</a></li>
    			<li><a href="#">5</a></li>
    			<li>
      				<a href="#" aria-label="Next">
        			<span aria-hidden="true">&raquo;</span>
      				</a>
    			</li>
  			</ul>
		</nav>
	</div>
</div>


<!-- 弹出框，添加 -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新科目</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/CourseInsertAction" method="get">
					<input class="form-control" type="text" name="course_id" placeholder="科目编号">
					<input class="form-control" type="text" name="user_id" placeholder="用户编号">
					<input class="form-control" type="text" name="name" placeholder="科目名">
					<input class="form-control" type="text" name="introduction" placeholder="说明">
					<input class="form-control" type="text" name="photo" placeholder="图片">
					<input class="form-control" type="text" name="practice_count" placeholder="练习次数">
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
<!-- 弹出框，修改 -->
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改科目信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/CourseUpdateAction" method="get">
      				<input class="form-control" id="course_id" type="text" name="course_id" placeholder="科目编号" >
      				<input class="form-control" id="user_id" type="text" name="user_id" placeholder="用户编号" >
      				<input class="form-control" id="name" type="text" name="name" placeholder="科目名" >
      				<input class="form-control" id="introduction" type="text" name="introduction" placeholder="说明" >
      				<input class="form-control" id="photo" type="text" name="photo" placeholder="图片" >
      				<input class="form-control" id="practice_count" type="text" name="practice_count" placeholder="练习次数" >
      		
					<button class="btn btn-block btn-primary" type="submit">修改</button>
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