<%@ page import="com.zyyj.bean.ExchangeIntegral, com.zyyj.service.credit.ExchangeIntegralService" %>
<%@ page import="org.springframework.context.ApplicationContext, org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	ExchangeIntegralService service = ac.getBean("exchangeIntegralServiceImpl", ExchangeIntegralService.class);
	List<ExchangeIntegral> list = service.getAllExchangeIntegrals();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>积分兑换记录</h1>
	</div>
	<div class="row" align="right">
			<!-- 搜索框 -->
		<div class="row" align="right">
			<div class="col-md-5" style="padding:0px;">
				<form class="nav-form" name="search-frm" action="javascript:search('searchExchangeIntegral', 'credit/exchangeIntegral.jsp')">
					<div class="input-group">
      					<input type="text" class="form-control" name="search-input" id="search-input" placeholder="搜索...">
      					<span class="input-group-btn">
       				 		<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      					</span>
      					<select id="search-option" name="search-option" class="form-control" style="margin-left:20px;">
							<option value="1">按学生姓名搜索</option>
							<option value="2">按兑换规则搜索</option>
							<option value="3">按班级搜索</option>
							<option value="4">按学号搜索</option>
						</select>
    				</div>
				</form>
			</div>
			<div class="col-md-7" align="right" id="add-button">
				
			</div>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>积分兑换编号</th><th>兑换规则</th><th>学生姓名</th><th>兑换日期</th><th>得分</th><th>消耗积分</th></tr>
		</thead>
		<tbody id="table-tbody">
			<%
			for(ExchangeIntegral e : list){%>
				<tr><td><%=e.getExchange_id() %></td><td><%=e.getRule_name() %></td><td><%=e.getStu_name() %></td><td><%=e.getCreatedate() %></td><td><%=e.getScore() %></td><td><%=e.getIntegral() %></td></tr>	
			<%}
			%>
		</tbody>
		</table>
		
	</div>
</div>
</body>
</html>