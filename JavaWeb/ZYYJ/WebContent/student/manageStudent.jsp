<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Class.*, Grade.*, Major.*, College.*, Student.*" %>
<%
	ArrayList<StudentInfo> studentlist = (ArrayList<StudentInfo>)session.getAttribute("studentList");
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>学生管理</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="javascript:search('/ZYYJ/searchStudent', 'StudentListAction')">
				<div class="input-group">
      				<input type="text" id="search-input" name="search-input" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
      				<select class="form-control" id="search-option" name="search-option">
      					<option value="1">按班级名搜索</option>
      					<option value="2">按年级名搜索</option>
      					<option value="3">按专业名搜索</option>
      					<option value="4">按学院名搜索</option>
      				</select>
    			</div>
			</form>
		</div>
		
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加学生</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>学生编号</th>
				<th>学号</th>
				<th>所属班级</th>
				<th>所属年级</th>
				<th>所属专业</th>
				<th>所属学院</th>
				<th>姓名</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>电话</th>
				
		</thead>
		<tbody>
			
			<%
				for (int i = 0; i < studentlist.size(); i++)
				{
					StudentInfo teststudent = studentlist.get(i);
					ClassInfo testclass = new ClassDB().getClassById(teststudent.getCalssid());
					GradeInfo grade = new GradeDB().getGradeById(testclass.getGradeid());
					MajorInfo major = new MajorDB().getMajorById(grade.getMajorid());
					CollegeInfo college = new CollegeDB().getCollegeById(major.getCollegeid());
			%>
					<tr>
						<td><%=teststudent.getStuid() %></td>
						<td><%=teststudent.getAccount() %></td>
						<td><%=testclass.getName() %></td>
						<td><%=grade.getName() %></td>
						<td><%=major.getName() %></td>
						<td><%=college.getCollegename() %></td>
						<td><%=teststudent.getName() %></td>
						<td><%=teststudent.getGender()==1?"男":"女" %></td>
						<td><%=teststudent.getEmail() %></td>
						<td><%=teststudent.getPhone() %></td>
						<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateStudentInfo('<%=teststudent.getStuid() %>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
						<td><a href="<%=request.getContextPath()%>/StudentDelAction?studentid=<%=teststudent.getStuid()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
      			<h4 class="modal-title">添加学生</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/StudentInsertAction" method="get">
      				<span>学生编号</span>
      				<input class="form-control" type="text" name="id" placeholder="学生编号">
					<span>学号</span>
					<input class="form-control" type="text" name="account" placeholder="学号">
					<span>密码</span>
					<input class="form-control" type="text" name="password" placeholder="密码">
					<span>姓名</span>
					<input class="form-control" type="text" name="name" placeholder="姓名">
					<span>班级</span>
					<select name="class" class="form-control">
					<%
						ArrayList<ClassInfo> classlist1 = new ClassDB().getAll();
						for (int i = 0; i < classlist1.size(); i++)
						{
							ClassInfo testclass1 = classlist1.get(i);
					%>		
							<option value="<%=testclass1.getClassid()%>"><%=testclass1.getName() %></option>	
					<%
						}
					%>					
					</select>
					<span>性别</span>
					<select name="gender" class="form-control" size ="1">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
					<span>邮箱</span>
					<input class="form-control" type="text" name="email" placeholder="邮箱">
					<span>电话</span>
					<input class="form-control" type="text" name="phone" placeholder="电话">
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
      			<h4 class="modal-title">修改学生信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/StudentUpdateAction" method="get">
      				<span>学生编号</span>
					<input class="form-control" type="text" readonly="readonly" id="studentid" name="id" placeholder="学生编号">
					<span>学号</span>
					<input class="form-control" type="text" readonly="readonly" id="account" name="account" placeholder="学号">
					<span>密码</span>
					<input class="form-control" type="text" readonly="readonly" id="password" name="password" placeholder="密码">
					<span>姓名</span>
					<input class="form-control" type="text" readonly="readonly" id="name" name="name" placeholder="姓名">
					<span>班级</span>
					<select name="class" id="classid" class="form-control" size="1">
					<%
						ArrayList<ClassInfo> classlist2 = new ClassDB().getAll();
						for (int i = 0; i < classlist2.size(); i++)
						{
							ClassInfo testclass2 = classlist2.get(i);
					%>		
							<option value="<%=testclass2.getClassid()%>"><%=testclass2.getName() %></option>	
					<%
						}
					%>					
					</select>
					<span>性别</span>
					<select name="gender" readonly="readonly" id="gender" class="form-control" size ="1">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
					<span>邮箱</span>
					<input class="form-control" type="text" id="email" name="email" placeholder="邮箱">
					<span>电话</span>
					<input class="form-control" type="text" id="phone" name="phone" placeholder="电话">
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
