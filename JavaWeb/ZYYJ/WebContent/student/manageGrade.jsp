<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Grade.*, Major.*, College.*" %>

<%
	ArrayList<GradeInfo> gradelist = (ArrayList<GradeInfo>)session.getAttribute("gradeList");
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>年级管理</h1>
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
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新年级</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>年级编号</th><th>所属专业</th><th>所属学院</th><th>年级名称</th><th>备注</th></tr>
		</thead>
		<tbody>
			
			<%
				for (int i = 0; i < gradelist.size(); i++)
				{
					GradeInfo testgrade = gradelist.get(i);
					MajorInfo major = new MajorDB().getMajorById(testgrade.getMajorid());
					CollegeInfo college = new CollegeDB().getCollegeById(major.getCollegeid());
			%>
					<tr>
						<td><%=testgrade.getGradeid() %></td>
						<td><%=major.getName() %></td>
						<td><%=college.getCollegename() %></td>
						<td><%=testgrade.getName() %></td>
						<td><%=testgrade.getComment() %></td>
						<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateGradeInfo('<%=testgrade.getGradeid() %>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
						<td><a href="<%=request.getContextPath()%>/GradeDelAction?gradeid=<%=testgrade.getGradeid()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
      			<h4 class="modal-title">添加新年级</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/GradeInsertAction" method="get">
					<span>年级编号</span>
					<input class="form-control" type="text" name="gradeid" placeholder="年级编号">
					<span>所属专业</span>
   				 	<select name="majorid" class="form-control">
						<%
							ArrayList<MajorInfo> majorlist1 = new MajorDB().getAll();
							for (int i = 0; i < majorlist1.size(); i++)
							{
								MajorInfo testmajor1 = majorlist1.get(i);
						%>		
								<option value="<%=testmajor1.getMajorid()%>"><%=testmajor1.getName() %></option>	
						<%
							}
						%>					
					</select>
					<span>年级名称</span>
					<input class="form-control" type="text" name="name" placeholder="年级名称">
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
      			<h4 class="modal-title">修改年级信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/GradeUpdateAction" method="get">
					<span>年级编号</span>
					<input class="form-control" type="text" readonly="readonly" id="grade_id" name="id" placeholder="年级编号">
   				 	<span>所属专业</span>
   				 	<select name="major" id="major_id" class="form-control" size="1">
						<%
							ArrayList<MajorInfo> majorlist2 = new MajorDB().getAll();
							for (int i = 0; i < majorlist2.size(); i++)
							{
								MajorInfo testmajor2 = majorlist2.get(i);
						%>		
								<option value="<%=testmajor2.getMajorid()%>"><%=testmajor2.getName() %></option>	
						<%
							}
						%>											
					</select>
					<span>年级名称</span>
					<input class="form-control" id="name" type="text" name="name" placeholder="年级名称">
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
