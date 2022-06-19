<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="chapter.*, java.util.*" %>
<%
	ArrayList<chapterInfo> chapterlist = (ArrayList<chapterInfo>)session.getAttribute("chapterList1");
%>

<%!
	String editid = "";
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>章节管理</h1>
	</div>
	<div class="row" align="right">
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新章节</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>章节编号</th><th>科目编号</th><th>章节名</th><th>图片</th><th>备注</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < chapterlist.size(); i++)
			{
				chapterInfo testchapter = chapterlist.get(i);
		%>
			<tr>
				<td><%=testchapter.getChapter_id() %></td>
				<td><%=testchapter.getCourse_id() %></td>
				<td><%=testchapter.getName() %></td>
				<td><%=testchapter.getPhoto() %></td>
				<td><%=testchapter.getComment() %></td>
				
				<td><a href="#" data-toggle="modal" data-target="#modify-modal"><span class="glyphicon glyphicon-pencil" onclick="javascript:updateChapterInfo('<%=testchapter.getChapter_id()%>')"> 修改</span></a></td>
				<td><a href="<%=request.getContextPath()%>/chapterDelAction?chapter_id=<%=testchapter.getChapter_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
      			<h4 class="modal-title">添加新章节</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/chapterInsertAction" method="get">
					<input class="form-control" type="text" name="chapter_id" placeholder="章节编号">
					<input class="form-control" type="text" name="course_id" placeholder="科目编号">
					<input class="form-control" type="text" name="name" placeholder="章节名">
					<input class="form-control" type="text" name="photo" placeholder="图片">
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
      			<h4 class="modal-title">修改学院信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/chapterUpdateAction" method="get">
      				<input class="form-control" id="chapter_id" type="text" name="chapter_id" placeholder="章节编号" >
      				<input class="form-control" id="course_id" type="text" name="course_id" placeholder="科目编号" >
      				<input class="form-control" id="name" type="text" name="name" placeholder="章节名" >
      				<input class="form-control" id="photo" type="text" name="photo" placeholder="图片" >
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