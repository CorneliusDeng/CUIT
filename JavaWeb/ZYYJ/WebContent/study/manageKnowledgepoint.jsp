<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="knowledgepoint.*, java.util.*" %>
<%
	ArrayList<knowledgepointInfo> knowledgelist = (ArrayList<knowledgepointInfo>)session.getAttribute("knowledgeList1");
%>

<%!
	String editid = "";
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>知识点管理</h1>
	</div>
	<div class="row" align="right">
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新知识点</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>知识点编号</th><th>科目编号</th><th>名称</th><th>备注</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < knowledgelist.size(); i++)
			{
				knowledgepointInfo testknowledge = knowledgelist.get(i);
		%>
			<tr>
				<td><%=testknowledge.getKnow_id() %></td>
				<td><%=testknowledge.getCourse_id() %></td>
				<td><%=testknowledge.getName() %></td>
				<td><%=testknowledge.getComment() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal"><span class="glyphicon glyphicon-pencil" onclick="javascript:updateKnowledgeInfo('<%=testknowledge.getKnow_id()%>')"> 修改</span></a></td>
				<td><a href="<%=request.getContextPath()%>/knowledgeDelAction?know_id=<%=testknowledge.getKnow_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
			</tr>
		<%
				System.out.println("editid:"+editid);
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
      			<h4 class="modal-title">添加新知识点</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/knowledgeInsertAction" method="get">
					<input class="form-control" type="text" name="know_id" placeholder="知识点编号">
					<input class="form-control" type="text" name="course_id" placeholder="科目编号">
					<input class="form-control" type="text" name="name" placeholder="名称">
					<input class="form-control" type="text" name="comment" placeholder="备注">
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
      			<h4 class="modal-title">修改知识点信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/knowledgeUpdateAction" method="get">
      			<input class="form-control" id="know_id" type="text" name="know_id" placeholder="知识点编号" >
      				<input class="form-control" id="course_id" type="text" name="course_id" placeholder="科目编号" >
      				<input class="form-control" id="name" type="text" name="name" placeholder="名称" >
      				<input class="form-control" id="comment" type="text" name="comment" placeholder="备注" >
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