<%--主界面--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>邓棋的数据挖掘实验</title>
  <meta charset="utf-8">
  <!-- jQuery -->
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
  <script src="utility.js" charset="utf-8"></script>
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <!-- 自定义样式表 -->
  <link rel="stylesheet" href="./style.css" type="text/css">
</head>
<%
  //该变量用来接收各servlet指定加载的界面地址，如果它为空，则系统加载欢迎界面
  String externalpage = request.getParameter("externalPage");
%>
<body onload="loadExternalPage('<%=externalpage==null? "welcome.jsp" : externalpage%>')">
<div class="container-fluid">
  <div class="row">
    <div class="col-md-2 sidebar">
      <ul class="nav sidebar-nav">
        <li class="nav-item"><h4 id="header">DataMining</h4></li>

        <li class="nav-item">
          <a href="<%=request.getContextPath() %>/BayesGetList" class="nav-text">
            <span class="glyphicon glyphicon-asterisk">  朴素贝叶斯</span>
          </a>
        </li>

        <li class="nav-item">
          <a href="<%=request.getContextPath() %>/AprioriGetList" class="nav-text" >
            <span class="glyphicon glyphicon-th">  关联规则</span>
          </a>
        </li>

        <li class="nav-item">
          <a href="<%=request.getContextPath() %>/KmeansGetList" class="nav-text" >
            <span class="glyphicon glyphicon-th-list">  K-Means聚类算法</span></a>
        </li>
      </ul>
    </div>

    <!--  外部页面接口 -->
    <div class="col-md-9" id="main">

    </div>
  </div>
</div>
</body>
</html>