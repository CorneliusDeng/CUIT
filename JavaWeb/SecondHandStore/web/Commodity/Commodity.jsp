<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="commodity.*, java.util.*,sort.*, java.lang.*" %>
<%
    ArrayList<CommodityInfo> commodityList = (ArrayList<CommodityInfo>)session.getAttribute("commodityList");

%>

<div class="col-md-10 col-md-offset-1">
    <div class="row">
        <h1>商品管理</h1>
    </div>
    <div class="row">
        <table class="table table-striped table-hover">
            <thead>
            <tr><th>商品名称</th><th>商品类别</th><th>价格</th></tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < commodityList.size(); i++)
                {
                    System.out.println("size:"+commodityList.size());
                    CommodityInfo testcommodity = commodityList.get(i);
                    SortInfo sort = new SortDB().getSortById(testcommodity.getSort_id());
            %>
            <tr>
                <td><%=testcommodity.getCom_name() %></td>
                <td><%=sort.getSort_name() %></td>
                <td><%=testcommodity.getCom_money() %></td>
                <td><a href="#" data-toggle="modal" data-target="#modify-modal" onclick="javascript:getCommodityInfo('<%=testcommodity.getCom_id()%>')"><span class="glyphicon glyphicon-pencil"> 详情</span></a></td>
                <td><a href="<%=request.getContextPath()%>/CommodityDelAction?commodityid=<%=testcommodity.getCom_id()%>" onclick="javascript:if(!confirm('确定要删除选择的信息吗？\n此操作不可以恢复！')) { return false; }"><span class="glyphicon glyphicon-trash"> 删除</span></a></td>
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
                <form class="form-signin">
                    <span>商品编号</span>
                    <input class="form-control" id="comid" readonly="readonly" type="text" name="id" placeholder="商品编号">
                    <span>商品名称</span>
                    <input class="form-control" id="name" readonly="readonly" type="text" name="name" placeholder="商品名称" >
                    <span>用户ID</span>
                    <input class="form-control" id="userid" readonly="readonly" type="text" name="userid" placeholder="用户编号" >
                    <span>商品介绍</span>
                    <input class="form-control" id="description" readonly="readonly" type="text" name="description" placeholder="商品介绍" >
                    <span>商品价格</span>
                    <input class="form-control" id="money" readonly="readonly" type="text" name="money" placeholder="金额" >
                    <span>类别</span>
                    <input class="form-control" id="sortid" readonly="readonly" type="text" name="sortid" placeholder="状态" >
                    <span>商品状态</span>
                    <input class="form-control" id="status" readonly="readonly" type="text" name="status" placeholder="状态" >
                    <span>图片1</span>
                    <input class="form-control" id="img1" readonly="readonly" type="text" name="img1" placeholder="图片1" >
                    <span>图片2</span>
                    <input class="form-control" id="img2" readonly="readonly" type="text" name="img2" placeholder="图片2" >
                    <span>图片3</span>
                    <input class="form-control" id="img3" readonly="readonly" type="text" name="img3" placeholder="图片3" >
                    <span>上架时间</span>
                    <input class="form-control" id="time" readonly="readonly" type="text" name="time" placeholder="时间" >
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