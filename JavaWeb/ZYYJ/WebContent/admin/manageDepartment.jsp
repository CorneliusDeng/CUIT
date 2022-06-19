<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="department.*, java.util.*, College.*" %>

<%
	ArrayList<DepartmentInfo> departmentlist = (ArrayList<DepartmentInfo>)session.getAttribute("departmentList1");
%>

<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>部门管理</h1>
	</div>
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
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新部门</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>部门编号</th><th>所属学院</th><th>部门名称</th><th>备注</th></tr>
		</thead>
		<tbody>
		
		<%
			for (int i = 0; i < departmentlist.size(); i++)
			{
				DepartmentInfo testdepartment = departmentlist.get(i);
				CollegeInfo college = new CollegeDB().getCollegeById(testdepartment.getCollegeid());
		%>
			<tr>
				<td><%=testdepartment.getDepartmentid() %></td>
				<td><%=college.getCollegename() %></td>
				<td><%=testdepartment.getName() %></td>
				<td><%=testdepartment.getComment() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateDepartmentInfo('<%=testdepartment.getDepartmentid()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="<%=request.getContextPath()%>/DepartmentDelAction?departmentid=<%=testdepartment.getDepartmentid()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
			</tr>
		<%
			}
		%>
			
		</tbody>
		</table>
	</div>
</div>


<!-- 弹出框，添加 -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新部门</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/DepartmentInsertAction" method="get">
					<span>部门编号</span>
					<input class="form-control" type="text" name="departmentid" placeholder="部门编号">
					<span>所属学院</span>
					<select class="form-control" name="collegeid" size="1">
						<%
							ArrayList<CollegeInfo> collegelist1 = new CollegeDB().getAll();
							for (int i = 0; i < collegelist1.size(); i++)
							{
								CollegeInfo testcollege1 = collegelist1.get(i);
						%>		
								<option value="<%=testcollege1.getCollegid()%>"><%=testcollege1.getCollegename() %></option>	
						<%
							}
						%>		
					</select>
					<span>部门名称</span>
					<input class="form-control" type="text" name="name" placeholder="部门名称">
					<span>备注</span>
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
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改部门信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/DepartmentUpdateAction" method="get">
					<span>部门编号</span>
					<input class="form-control" id="department_id" readonly="readonly" type="text" name="id" placeholder="部门编号">
					<span>所属学院</span>
					<select class="form-control" size="1" id="college_id" name="college">
						<%
							ArrayList<CollegeInfo> collegelist2 = new CollegeDB().getAll();
							for (int i = 0; i < collegelist2.size(); i++)
							{
								CollegeInfo testcollege2 = collegelist2.get(i);
						%>		
								<option value="<%=testcollege2.getCollegid()%>"><%=testcollege2.getCollegename() %></option>	
						<%
							}
						%>	
					</select>
					<span>部门名称</span>
					<input class="form-control" id="name" type="text" name="name" placeholder="部门名称">
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
