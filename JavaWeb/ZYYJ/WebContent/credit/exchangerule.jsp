<%@page import="com.zyyj.bean.ExchangeRule, java.util.List" %>
<%@ page import="org.springframework.context.ApplicationContext, org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import="com.zyyj.service.credit.ExchangeRuleService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	ExchangeRuleService service = ac.getBean("exchangeRuleServiceImpl", ExchangeRuleService.class);
	List<ExchangeRule> list = service.getAllExchangeRules();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>积分兑换规则</h1>
	</div>
	<div class="row" align="right">
		<div class="col-md-7 col-md-offset-5" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新规则</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>规则编号</th><th>规则名</th><th>创建日期</th><th>得分</th><th>消耗积分</th></tr>
		</thead>
		<tbody>
			<%
			for(ExchangeRule e : list){%>
				<tr><td><%=e.getRule_id() %></td><td><%=e.getName() %></td><td><%=e.getCreatedate() %></td><td><%=e.getScore() %></td><td><%=e.getIntegral() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:updateModalExchangeRule('<%=e.getRule_id()%>')"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="deleteExchangeRule?rule_id=<%=e.getRule_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td></tr>
			<%}
			%>
		</tbody>
		</table>
		
	</div>
</div>


<!-- 弹出框，添加 -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新规则</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/ZYYJ/addExchangeRule" method="post">
					<input class="form-control" type="text" name="name" placeholder="规则名">
					<input class="form-control" type="text" name="score" placeholder="得分">
					<input class="form-control" type="text" name="integral" placeholder="消耗积分">
					<button class="btn btn-lg btn-primary btn-block" type="submit">添加</button>
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
      			<h4 class="modal-title">修改兑换规则</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="updateExchangeRule" method="post">
					规则编号：<input class="form-control" type="text" id="rule_id" name="rule_id" placeholder="规则编号" value="" readonly>
					规则名：<input class="form-control" type="text" id="name" name="name" placeholder="规则名">
					得学分：<input class="form-control" type="text" id="score" name="score" placeholder="得分">
					消耗积分：<input class="form-control" type="text" id="integral" name="integral" placeholder="消耗积分">
					<button class="btn btn-lg btn-primary btn-block" type="submit">修改</button>
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

<script>

</script>