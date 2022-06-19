<%--贝叶斯界面--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Bayes.*"  %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<BayesBean> list = (ArrayList<BayesBean>)session.getAttribute("BayesDataList");
    String[] TestData = (String[]) session.getAttribute("TestData");
    double[] result = (double[])session.getAttribute("Result");

%>
<div class="col-md-10 col-md-offset-1">
    <div class="row">
        <h2>Naive Bayes model</h2>
    </div>
    <div class="row">
        <p><font size="2"  color="OrangeRed">训练集数据如下：</font></p>
    </div>
    <div class="row">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>色泽</th><th>根蒂</th><th>敲声</th><th>纹理</th><th>脐部</th><th>触感</th><th>判断</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < list.size(); i++)
                {
                    BayesBean bean = list.get(i);
            %>
            <tr>
                <td><%=bean.getColor() %></td>
                <td><%=bean.getRoot() %></td>
                <td><%=bean.getSound() %></td>
                <td><%=bean.getVein() %></td>
                <td><%=bean.getNavel() %></td>
                <td><%=bean.getTouch() %></td>
                <td><%=bean.getResult() == true?"好瓜":"坏瓜"%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <hr width=100%, color="#deb887">


    </div>

    <div class="row">
        <p><font size="2"  color="OrangeRed">请选择测试数据</font></p>
        <p>本次实验的测试集为：青绿，稍蜷，浊响，清晰，凹陷，硬滑</p>
    </div>

    <div class="row">
        <form action="<%=request.getContextPath() %>/BayesGetAction" method="post">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>色泽</th><th>根蒂</th><th>敲声</th><th>纹理</th><th>脐部</th><th>触感</th><th>判断</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <select name="color" class="myself">
                            <option value="1">青绿</option>
                            <option value="2">乌黑</option>
                            <option value="3">浅白</option>
                        </select>
                    </td>
                    <td>
                        <select name="root" class="myself">
                            <option value="1">蜷缩</option>
                            <option value="2">稍蜷</option>
                            <option value="3">硬挺</option>
                        </select>
                    </td>
                    <td>
                        <select name="sound" class="myself">
                            <option value="1">浊响</option>
                            <option value="2">沉闷</option>
                            <option value="3">清脆</option>
                        </select>
                    </td>
                    <td>
                        <select name="vein" class="myself">
                            <option value="1">清晰</option>
                            <option value="2">稍糊</option>
                            <option value="3">模糊</option>
                        </select>
                    </td>
                    <td>
                        <select name="navel" class="myself">
                            <option value="1">凹陷</option>
                            <option value="2">稍凹</option>
                            <option value="3">平坦</option>
                        </select>
                    </td>
                    <td>
                        <select name="touch" class="myself">
                            <option value="1">硬滑</option>
                            <option value="2">软粘</option>
                        </select>
                    </td>
                    <td>
                        <button class="btn btn-warning" type="submit">测算</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <%
        if (TestData != null && TestData.length > 0)
        {

    %>
            <div class="row">
                <p>由朴素贝叶斯算法</p>
                <p>该瓜为好瓜的概率为：<%=result[0]%></p>
                <p>该瓜为坏瓜的概率为：<%=result[1]%></p>
                <%
                    String color = "色泽" + TestData[0];
                    String root = " 根蒂" + TestData[1];
                    String sound = " 敲声" + TestData[2];
                    String vein = " 纹理" + TestData[3];
                    String navel = " 脐部" + TestData[4];
                    String touch = " 触感" + TestData[5];
                    if (result[0] > result[1])
                    {
                %>
                <p>因此这个<%=color+root+sound+vein+navel+touch%>的瓜为：好瓜！</p>
                <%
                }
                else
                {
                %>
                <p>因此这个<%=color+root+sound+vein+navel+touch%>的瓜为：坏瓜！</p>
                <%
                    }
                %>
            </div>
    <%
        }
    %>
</div>
