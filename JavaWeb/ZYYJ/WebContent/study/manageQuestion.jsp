<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="question.*, Programme.*,java.util.*" %>
<%
	ArrayList<questionInfo> questionlist = (ArrayList<questionInfo>)session.getAttribute("questionList1");
%>

<%!
	String editid = "";
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>题目管理</h1>
	</div>
	<div class="row" align="right">
		<div class="col-md-12" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新题目</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>题目编号</th><th>科目方案</th><th>练习方案</th><th>考试编号</th><th>题目类型</th><th>题目等级</th>
			<th>题目</th><th>答案1</th><th>答案2</th><th>答案3</th><th>答案4</th><th>正确答案</th><th>备注</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < questionlist.size(); i++)
			{
				questionInfo testquestion = questionlist.get(i);
				ProgrammeInfo prog = new ProgrammeDB().getNameById(testquestion.getProgramme_id());
		%>
			<tr>
				<td><%=testquestion.getQuestion_id() %></td>
				<td><%=testquestion.getCourse_id() %></td>
				<td><%=(testquestion.getProgramme_id()==null)? "":prog.getName()%></td>
				<td><%=testquestion.getExam_id() %></td>
				<td><%=testquestion.getQuestion_type() %></td>
				<td><%=testquestion.getLevel() %></td>
				<td><%=testquestion.getQuestion() %></td>
				<td><%=testquestion.getAnswer1() %></td>
				<td><%=testquestion.getAnswer2() %></td>
				<td><%=testquestion.getAnswer3() %></td>
				<td><%=testquestion.getAnswer4() %></td>
				<td><%=testquestion.getRightanswer() %></td>
				<td><%=testquestion.getComment() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateQuestionInfo('<%=testquestion.getQuestion_id()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="<%=request.getContextPath()%>/questionDelAction?question_id=<%=testquestion.getQuestion_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新题目</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/questionInsertAction" method="get">
					<input class="form-control" type="text" name="question_id" placeholder="题目编号">
					<input class="form-control" type="text" name="course_id" placeholder="科目编号">
					<select class="form-control" name="programme_id" size="1" placeholder="练习方案">
						<%
							ArrayList<ProgrammeInfo> Programmelist1 = new ProgrammeDB().getAll();
							for (int n = 0; n < Programmelist1.size(); n++)
							{
								ProgrammeInfo testProgramme1 = Programmelist1.get(n);
						%>		
								<option value="<%=testProgramme1.getProgramme_id()%>"><%=testProgramme1.getName() %></option>	
						<%
							}
						%>	
					</select>
					<input class="form-control" type="text" name="exam_id" placeholder="考试编号">
					<input class="form-control" type="text" name="question_type" placeholder="题目类型">
					<input class="form-control" type="text" name="level" placeholder="题目等级">
					<input class="form-control" type="text" name="question" placeholder="题目">
					<input class="form-control" type="text" name="answer1" placeholder="答案1">
					<input class="form-control" type="text" name="answer2" placeholder="答案2">
					<input class="form-control" type="text" name="answer3" placeholder="答案3">
					<input class="form-control" type="text" name="answer4" placeholder="答案4">
					<input class="form-control" type="text" name="rightanswer" placeholder="正确答案">
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
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改题目信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath() %>/questionUpdateAction" method="get">	
      				<input class="form-control" readonly="readonly" type="text" id="question_id" name="question_id" placeholder="题目编号">
      				<input class="form-control" type="text" id="course_id" name="course_id" placeholder="科目编号">
      				
      				<select class="form-control" id="programme_id" name="programme_id" size="1">
      					<%
		      				ArrayList<ProgrammeInfo> Programmelist2 = new ProgrammeDB().getAll();
							for (int n = 0; n < Programmelist2.size(); n++)
							{
								ProgrammeInfo testProgramme2 = Programmelist2.get(n);
						%>		
								<option value="<%=testProgramme2.getProgramme_id()%>"><%=testProgramme2.getName() %></option>	
						<%
							}
						%>	
					</select>
      				<input class="form-control" type="text" id="exam_id" name="exam_id" placeholder="考试编号">
      				<input class="form-control" type="text" id="question_type" name="question_type" placeholder="题目类型">
      				<input class="form-control" type="text" id="level" name="level" placeholder="题目等级">
      				<input class="form-control" type="text" id="question" name="question" placeholder="题目">
      				<input class="form-control" type="text" id="answer1" name="answer1" placeholder="答案1">
      				<input class="form-control" type="text" id="answer2" name="answer2" placeholder="答案2">
      				<input class="form-control" type="text" id="answer3" name="answer3" placeholder="答案3">
      				<input class="form-control" type="text" id="answer4" name="answer4" placeholder="答案4">
      				<input class="form-control" type="text" id="rightanswer" name="rightanswer" placeholder="正确答案">
      				<input class="form-control" type="text" id="comment" name="comment" placeholder="备注">
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
