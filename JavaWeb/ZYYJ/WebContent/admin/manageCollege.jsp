<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="College.*, java.util.*" %>
<%
	ArrayList<CollegeInfo> collegelist = (ArrayList<CollegeInfo>)session.getAttribute("collegeList1");
%>

<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>学院管理</h1>
	</div>
	<div class="row" align="right">
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新学院</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>学院编号</th><th>学院名称</th><th>备注</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < collegelist.size(); i++)
			{
				CollegeInfo testcollege = collegelist.get(i);
		%>
			<tr>
				<td><%=testcollege.getCollegid() %></td>
				<td><%=testcollege.getCollegename() %></td>
				<td><%=testcollege.getCollegedetail() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateCollegeInfo('<%=testcollege.getCollegid()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="<%=request.getContextPath()%>/CollegeDelAction?collegeid=<%=testcollege.getCollegid()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
			</tr>
		<%
			}
		%>
		</tbody>
		</table>
		
		<!-- 页码按钮-->
		<!-- <nav aria-label="Page navigation">
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
		</nav> -->
	</div>
</div>


<!-- 弹出框，添加 -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新学院</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/CollegeInsertAction" method="get">
					<span>学院编号</span>
					<input class="form-control" type="text" name="id" placeholder="学院编号">
					<span>学院名称</span>
					<input class="form-control" type="text" name="name" placeholder="学院名称">
					<span>备注</span>
					<input class="form-control" type="text" name="note" placeholder="备注">
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
      			<h4 class="modal-title">修改学院信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/CollegeUpdateAction" method="post">
      				<span>学院编号</span>
      				<input class="form-control" id="college_id" readonly="readonly" type="text" name="collegeid" placeholder="学院编号">
					<span>学院名称</span>
					<input class="form-control" id="name" type="text" name="collegename" placeholder="学院名称" >
					<span>备注</span>
					<input class="form-control" id="comment" type="text" name="collegenote" placeholder="备注" >
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