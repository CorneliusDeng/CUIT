<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Class.*, Grade.*, Major.*, College.*" %>

<%
	ArrayList<ClassInfo> classlist = (ArrayList<ClassInfo>)session.getAttribute("classList");
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>班级管理</h1>
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
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新班级</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>班级编号</th><th>所属年级</th><th>所属专业</th><th>所属学院</th><th>班级名称</th><th>备注</th></tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < classlist.size(); i++)
				{
					ClassInfo testclass = classlist.get(i);
					GradeInfo grade = new GradeDB().getGradeById(testclass.getGradeid());
					MajorInfo major = new MajorDB().getMajorById(grade.getMajorid());
					CollegeInfo college = new CollegeDB().getCollegeById(major.getCollegeid());
					
			%>
					<tr>
						<td><%=testclass.getClassid() %></td>
						<td><%=grade.getName() %></td>
						<td><%=major.getName() %></td>
						<td><%=college.getCollegename() %></td>
						<td><%=testclass.getName() %></td>
						<td><%=testclass.getComment() %></td>
						<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateClassInfo('<%=testclass.getClassid() %>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
						<td><a href="<%=request.getContextPath()%>/ClassDelAction?classid=<%=testclass.getClassid()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新班级</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/ClassInsertAction" method="get">
					<span>班级编号</span>
					<input class="form-control" type="text" name="id" placeholder="班级编号">
					<span>所属年级</span>
					<select name="grade" class="form-control" size="1">
						<%
							ArrayList<GradeInfo> gradelist1 = new GradeDB().getAll();
							for (int i = 0; i < gradelist1.size(); i++)
							{
								GradeInfo testgrade1 = gradelist1.get(i);
						%>		
								<option value="<%=testgrade1.getGradeid()%>"><%=testgrade1.getName() %></option>	
						<%
							}
						%>		
					</select>
					<span>班级名称</span>
					<input class="form-control" type="text" name="name" placeholder="班级名称">
					<span>备注</span>
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
      			<h4 class="modal-title">修改班级信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/ClassUpdateAction" method="get">
					<span>班级编号</span>
					<input class="form-control" type="text" id="class_id" name="id" placeholder="班级编号">
					<span>所属年级</span>
					<select name="grade" id="grade_id" class="form-control" size="1">
						<%
							ArrayList<GradeInfo> gradelist2 = new GradeDB().getAll();
							for (int i = 0; i < gradelist2.size(); i++)
							{
								GradeInfo testgrade2 = gradelist2.get(i);
						%>		
								<option value="<%=testgrade2.getGradeid()%>"><%=testgrade2.getName() %></option>	
						<%
							}
						%>		
					</select>
					<span>班级名称</span>
					<input class="form-control" id="name" type="text" name="name" placeholder="班级名称">
					<span>备注</span>
					<input class="form-control" id="comment" type="text" name="note" placeholder="备注">
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
