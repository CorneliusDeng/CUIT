<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>管理平台</title>
    <meta charset="utf-8">
    <script src="utility.js" charset="utf-8"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- jQuery -->
	<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<%
	String externalpage = request.getParameter("externalPage");
%>
<body onload="loadExternalPage('<%=externalpage==null?"userInfo.jsp" : externalpage%>')">
   <div class="container-fluid">
       <div class="row">
            <div class="col-md-2 sidebar">
                <ul class="nav sidebar-nav">
                    <li class="nav-item"><h4 id="header">中医药方记忆系统管理平台</h4></li>
                    
                    <li class="nav-item">
                    	<a class="nav-text" data-toggle="collapse" href="#study" aria-expanded="true" aria-controls="study">
            				<span class="glyphicon glyphicon-th-list">  学习布置</span>
            				<span class="glyphicon glyphicon-chevron-down menu-arrow"></span>
          				</a>
          				<div class="collapse" id="study">
          					<ul class="nav sidebar-nav">
          						<li class="nav-item">
          							<a href="<%=request.getContextPath()%>/CourseListAction" class="nav-text">
          							<span class="glyphicon glyphicon-education">  科目管理</span></a>
          						</li>
                    			<li class="nav-item">
          							<a href="<%=request.getContextPath()%>/chapterListAction" class="nav-text">
          							<span class="glyphicon glyphicon-education">  章节管理</span></a>
          						</li>
                    			<li class="nav-item">
          							<a href="<%=request.getContextPath()%>/knowledgeListAction" class="nav-text">
          							<span class="glyphicon glyphicon-education">  知识点管理</span></a>
          						</li>
                    			<li class="nav-item">
          							<a href="<%=request.getContextPath()%>/questionListAction" class="nav-text">
          							<span class="glyphicon glyphicon-education">  题目管理</span></a>
          						</li>
          					</ul>
          				</div>
                    </li>
                    
                    <hr class="sidebar-divider">
                    <li class="nav-item">
                    	<a class="nav-text" data-toggle="collapse" href="#practice" aria-expanded="true" aria-controls="practice">
            				<span class="glyphicon glyphicon-th-list">  练习管理</span>
            				<span class="glyphicon glyphicon-chevron-down menu-arrow"></span>
          				</a>
          				<div class="collapse" id="practice">
          					<ul class="nav sidebar-nav">
          						<li class="nav-item">
          							<a href="#" class="nav-text" onclick="loadExternalPage('practice/manageProgramme.jsp')">
                    				<span class="glyphicon glyphicon-list-alt">  练习方案管理</span></a>
                    			</li>
                    
                    			<li class="nav-item">
                    				<a href="#" class="nav-text" onclick="loadExternalPage('practice/manageCheckpoint.jsp')">
                    				<span class="glyphicon glyphicon-ok">  练习关卡管理</span></a>
                    			</li>
                    
                    
                    			<li class="nav-item">
                    				<a href="#" class="nav-text" onclick="loadExternalPage('practice/studentPractice.jsp')">
                    				<span class="glyphicon glyphicon-folder-open">  练习记录查看</span></a>
                    			</li>
          					</ul>
          				</div>
                    </li>
                    
                    <hr class="sidebar-divider">
                    <li class="nav-item">
                    	<a class="nav-text" data-toggle="collapse" href="#exam" aria-expanded="true" aria-controls="exam">
            				<span class="glyphicon glyphicon-th-list">  考试管理</span>
            				<span class="glyphicon glyphicon-chevron-down menu-arrow"></span>
          				</a>
          				<div class="collapse" id="exam">
          					<ul class="nav sidebar-nav">
          						<li class="nav-item">
          							<a href="#" class="nav-text" onclick="loadExternalPage('exam/manageExamProgramme.jsp')">
                    				<span class="glyphicon glyphicon-calendar">  考试方案管理</span></a>
                    			</li>
                    
                    			<li class="nav-item">
                    				<a href="#" class="nav-text" onclick="loadExternalPage('exam/studentExam.jsp')">
                    				<span class="glyphicon glyphicon-folder-open">  考试记录查看</span></a>
                    			</li>
          					</ul>
          				</div>
                    </li>
                    <hr class="sidebar-divider">
                    
                    
                    <li class="nav-item">
                    	<a class="nav-text" data-toggle="collapse" href="#credit" aria-expanded="true" aria-controls="credit">
            				<span class="glyphicon glyphicon-th-list">  积分管理</span>
            				<span class="glyphicon glyphicon-chevron-down menu-arrow"></span>
          				</a>
          				<div class="collapse" id="credit">
          					<ul class="nav sidebar-nav">
          						<li class="nav-item">
          							<a href="#" class="nav-text" onclick="loadExternalPage('credit/studentScore.jsp')">
                    				<span class="glyphicon glyphicon-stats">  积分排行榜</span></a>
                    			</li>
                    
                    			<li class="nav-item">
                    				<a href="#" class="nav-text" onclick="loadExternalPage('credit/exchangerule.jsp')">
                    				<span class="glyphicon glyphicon-wrench">  积分兑换规则</span></a>
                    			</li>
                    
                    			<li class="nav-item">
                    				<a href="#" class="nav-text" onclick="loadExternalPage('credit/exchangeIntegral.jsp')">
                    				<span class="glyphicon glyphicon-folder-open">  积分兑换记录</span></a>
                    			</li>
          					</ul>
          				</div>
                    </li>
                          
                    <hr class="sidebar-divider">
                    <li class="nav-item">
                    	<a class="nav-text" data-toggle="collapse" href="#mark" aria-expanded="true" aria-controls="mark">
            				<span class="glyphicon glyphicon-th-list">  成绩管理</span>
            				<span class="glyphicon glyphicon-chevron-down menu-arrow"></span>
          				</a>
          				<div class="collapse" id="mark">
          					<ul class="nav sidebar-nav">
          						<li class="nav-item">
          							<a href="<%=request.getContextPath()%>/markListAction" class="nav-text">
          							<span class="glyphicon glyphicon-education">  成绩查看</span></a>
          						</li>
     
          					</ul>
          				</div>
                    </li>
                    <hr class="sidebar-divider">
                    
                    <hr class="sidebar-divider">
                    <li class="nav-item"><a href="#" class="nav-text" onclick="loadExternalPage('userInfo.jsp')">
                    <span class="glyphicon glyphicon-home">  个人中心</span></a></li>
                    <hr class="sidebar-divider">
                    <li class="nav-item"><a href="login.jsp" style="color:white">注销</a></li>
                </ul>
            </div>

        <!--主内容接口，后期用ajax显示其他页面-->
        	<div class="col-md-9" id="main">
	
        	</div>
       </div>
   </div>
 	
</body>
<style>
.sidebar{background-color:#4e73df; height:800px;}
.nav-item{padding:10px;}
.nav-text{color:white;}
#header{color:white;}
.sidebar-divider{margin:0px; border-top:1px solid rgba(255,255,255,.15)}
body{background-color:#efecec;}
#main{background-color:white; margin:20px; padding:20px;
	border-radius:10px 10px 10px 10px;}
</style>
</html>