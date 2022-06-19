<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Major.*,College.*" %>

<%
	ArrayList<MajorInfo> majorlist = (ArrayList<MajorInfo>)session.getAttribute("majorList");
%>	

<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>专业管理</h1>
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
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新专业</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>专业编号</th><th>所属学院</th><th>专业名称</th><th>备注</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < majorlist.size(); i++)
			{
				MajorInfo testmajor = majorlist.get(i);
				CollegeInfo college = new CollegeDB().getCollegeById(testmajor.getCollegeid());
		%>
				<tr>
					<td><%=testmajor.getMajorid() %></td>
					<td><%=college.getCollegename() %></td>
					<td><%=testmajor.getName() %></td>
					<td><%=testmajor.getComment() %></td>
					<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateMajorInfo('<%=testmajor.getMajorid()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
					<td><a href="<%=request.getContextPath()%>/MajorDelAction?majorid=<%=testmajor.getMajorid()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
      			<h4 class="modal-title">添加新专业</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/MajorInsertAction" method="get">
					<span>专业编号</span>
					<input class="form-control" type="text" name="majorid" placeholder="专业编号">
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
					<span>专业名称</span>
					<input class="form-control" type="text" name="name" placeholder="名称">
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
      			<h4 class="modal-title">修改专业信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/MajorUpdateAction" method="get">
					<span>专业编号</span>
					<input class="form-control" readonly="readonly" type="text" id="major_id" name="id" placeholder="专业编号">
					<span>所属学院</span>
					<select class="form-control" id="college_id" name="collegeid" size="1">
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
					<span>专业名称</span>
					<input class="form-control" type="text" id="name" name="name" placeholder="专业名称">
					<span>备注</span>
					<input class="form-control" type="text" id="comment" name="note" placeholder="备注">
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
