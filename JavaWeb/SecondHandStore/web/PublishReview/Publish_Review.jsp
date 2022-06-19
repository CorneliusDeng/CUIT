<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="temporary.*, java.util.*,sort.*, java.lang.*" %>
<%
    ArrayList<TemporaryInfo> temcommodityList = (ArrayList<TemporaryInfo>)session.getAttribute("TemcommodityList");

%>

<div class="col-md-10 col-md-offset-1">
    <div class="row">
        <h1>发布审查</h1>
    </div>
    <div class="row">
        <table class="table table-striped table-hover">
            <thead>
            <tr><th>商品名称</th><th>商品类别</th><th>价格</th></tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < temcommodityList.size(); i++)
                {
                    TemporaryInfo testtemcommodity = temcommodityList.get(i);
                    SortInfo sort = new SortDB().getSortById(testtemcommodity.getSort_id());
            %>
            <tr>
                <td><%=testtemcommodity.getTem_name() %></td>
                <td><%=sort.getSort_name() %></td>
                <td><%=testtemcommodity.getTem_money() %></td>
                <td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:getTemCommodityInfo('<%=testtemcommodity.getTem_id()%>')"><span class="glyphicon glyphicon-pencil"> 详情</span></a></td>
                <td><a href="<%=request.getContextPath()%>/TemporaryDelAction?temcommodityid=<%=testtemcommodity.getTem_id()%>" onclick="javascript:if(!confirm('确定要删除选择的信息吗？\n此操作不可以恢复！')) { return false; }"><span class="glyphicon glyphicon-trash"> 审核不通过</span></a></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<!-- 弹出框，详情 -->
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改学院信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-signin" action="<%=request.getContextPath()%>/CommodityInsertAction" method="get">
                    <span>商品编号</span>
                    <input class="form-control" id="temid" type="text" name="id" placeholder="商品编号">
                    <span>商品名称</span>
                    <input class="form-control" id="name" type="text" name="name" placeholder="商品名称" >
                    <span>用户ID</span>
                    <input class="form-control" id="userid" type="text" name="userid" placeholder="用户编号" >
                    <span>商品介绍</span>
                    <input class="form-control" id="description" type="text" name="description" placeholder="商品介绍" >
                    <span>商品价格</span>
                    <input class="form-control" id="money" type="text" name="money" placeholder="金额" >
                    <span>类别</span>
                    <input class="form-control" id="sortid" type="text" name="sortid" placeholder="状态" >
                    <span>商品状态</span>
                    <input class="form-control" id="status" type="text" name="status" placeholder="状态" >
                    <span>图片1</span>
                    <input class="form-control" id="img1" readonly="readonly" type="text" name="img1" placeholder="图片1" >
                    <span>图片2</span>
                    <input class="form-control" id="img2" readonly="readonly" type="text" name="img2" placeholder="图片2" >
                    <span>图片3</span>
                    <input class="form-control" id="img3" readonly="readonly" type="text" name="img3" placeholder="图片3" >
                    <button class="btn btn-block btn-primary" type="submit">通过</button>
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