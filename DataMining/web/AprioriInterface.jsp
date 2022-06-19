<%--Apriori界面--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Apriori.*"  %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<%
    ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>)session.getAttribute("AprioriDataList");
    HashMap<ArrayList<String>, Integer> MaxL = (HashMap<ArrayList<String>, Integer>)session.getAttribute("MaxL");
    ArrayList<String> RulesResult = (ArrayList<String>)session.getAttribute("RulesResult");
    float[] InputData = (float[])session.getAttribute("InputData");
%>

<div class="col-md-10 col-md-offset-1">
    <div class="row">
        <h2>Apriori model</h2>
    </div>
    <div class="row">
        <p><font size="2"  color="OrangeRed">训练集数据如下：</font></p>
    </div>
    <div class="row">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>交易ID</th><th>顾客购买的商品信息</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < list.size(); i++)
                {
                    ArrayList<String> temp = list.get(i);
            %>
            <tr>
                <td>T<%=i+1%></td>
                <td><%=temp %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <hr width=100%, color="#deb887">
    </div>

    <div class="row">
        <p><font size="2"  color="OrangeRed">请输入本次实验的最小支持度和置信度</font></p>
    </div>

    <div class="row">
        <form action="<%=request.getContextPath() %>/AprioriGetAction" onsubmit="return check(this)" method="post">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>最小支持度</th><th>最小置信度</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <input type="text" name="min_support" id="min_support">
                    </td>
                    <td>
                        <input type="text" name="min_confidence" id="min_confidence">
                    </td>
                    <td>
                        <button class="btn btn-warning" type="submit" >开始分析</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <%
        if (RulesResult != null && RulesResult.size() > 0)
        {
    %>
            <div class="row">
                <p>在最小支持度为<%=InputData[0]%>最小置信度为<%=InputData[1]%>的条件下</p>
                <p>最大频繁项集为：<%=MaxL%></p>
                <p>分析得出的关联规则如下：</p>
                <%
                    for (int i = 0; i < RulesResult.size(); i++)
                    {
                        String temp = RulesResult.get(i);
                %>
                <table>
                <tr>
                    <td>
                        <%=temp%>
                    </td>
                </tr>
                </table>
                <%
                    }
                %>
                <hr width=100%, color="#deb887">
                <p>综上所述，将<%=MaxL.keySet()%>这几件货品一起售卖或将它们摆放在一起有助于提高销售额</p>
            </div>
    <%
        }
    %>


</div>

