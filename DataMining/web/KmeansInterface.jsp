<%--Kmeans界面--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Kmeans.*"  %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<String> result = (ArrayList<String>)session.getAttribute("result");
%>

<div class="col-md-10 col-md-offset-1">
    <div class="row">
        <h2>K-means model</h2>
    </div>
    <div class="row">
        <p><font size="2"  color="OrangeRed">请输入本次实验预定义的三个中心点数据</font></p>
    </div>

    <div class="row">
        <form action="<%=request.getContextPath() %>/KmeansGetAction" onsubmit="return KmeansCheck(this)" method="post">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>初始化聚类中心序号</th>
                    <th>最近一次消费时间间隔R</th>
                    <th>消费频率F</th>
                    <th>消费总金额M</th>
                    <td>
                        <button class="btn btn-warning" type="submit" >开始分析</button>
                    </td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        初始化聚类中心1
                    </td>
                    <td>
                        <input type="text" name="c1_R" id="c1_R">
                    </td>
                    <td>
                        <input type="text" name="c1_F" id="c1_F">
                    </td>
                    <td>
                        <input type="text" name="c1_M" id="c1_M">
                    </td>
                </tr>
                <tr>
                    <td>
                        初始化聚类中心2
                    </td>
                    <td>
                        <input type="text" name="c2_R" id="c2_R">
                    </td>
                    <td>
                        <input type="text" name="c2_F" id="c2_F">
                    </td>
                    <td>
                        <input type="text" name="c2_M" id="c2_M">
                    </td>
                </tr>
                <tr>
                    <td>
                        初始化聚类中心3
                    </td>
                    <td>
                        <input type="text" name="c3_R" id="c3_R">
                    </td>
                    <td>
                        <input type="text" name="c3_F" id="c3_F">
                    </td>
                    <td>
                        <input type="text" name="c3_M" id="c3_M">
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>


    <%
        if (result != null && result.size() > 0)
        {
    %>
            <div class="row">
                <p>由K-means聚类算法分析，经过<%=result.get(4)%></p>
                <p><%=result.get(1)%></p>
                <p><%=result.get(2)%></p>
                <p><%=result.get(3)%></p>
                <p><%=result.get(0)%></p>

                <hr width=100%, color="#deb887">
                <p>综合R、F、M考量，第三簇内用户为优质客户</p>
            </div>
    <%
        }
    %>

</div>

