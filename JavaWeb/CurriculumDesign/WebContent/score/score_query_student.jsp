<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
</head>  
<body>
	<center>									 
		<form name="frm" method="post" >
			<table border=0>
				<tr class="td_header">
					<td colspan="2"> 请输入用于查询的学生学号：</td>
				</tr>
				<tr>
					<td><input type="text" name="code" value="" size="20" maxlength="5"></td>
					<td><input type="button"  value="查询" onclick="return check();"></td>
				</tr>
			</table>   
		</form>

		<table border="1" bordercolor="#000000" cellpadding="5" cellspacing="0" width="60%" >
			<tr>
				<td width="60%"  id="dataTable" align="center">显示获取的数据</td>
			</tr>
		</table>
	</center>
</body>
</html>
<script language="JavaScript">
	function check()
	{ 
		if(frm.code.value.length!=5)
		{
			alert("请输入5位字符数字的学号!");
			frm.code.focus();
			return ;
		}
		retrieveXML();
	}

	//创建Ajax核心XMLHttpRequest对象实例	
	var http_request = false;
	function createRequest() 
	{
	    http_request = false;
	    if (window.XMLHttpRequest) 
	    {// Mozilla浏览器、IE7以上
	        http_request = new XMLHttpRequest();
	        if (http_request.overrideMimeType) 
	        {
	            http_request.overrideMimeType('text/xml');     // 设置MIME类别
	        }
	    } 
	    else if (window.ActiveXObject) 
	    {     // IE5、IE6浏览器
	    
		     var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
		     for(var n=0; n<MSXML.length; n++)
		     {
		    	 try
		    	 {
		    		 var objXMLHttp = new ActiveXObject(MSXML[n]);
		                break;
		         }
		    	 catch(e){}
		      }   
	    }
	}
	        
	
	function retrieveXML() 
	{
	    if(http_request==false)
	    { // XMLHttpRequest对象未创建
	   		createRequest(); // 创建XMLHttpRequest对象
	   		if(http_request==false){return;} // 创建不成功   	
	    }
	   	var url="<%=request.getContextPath()%>/ScoreAction?Action=GetStudentScoresByAjax&code="+frm.code.value;
	    http_request.onreadystatechange = callbackforXML;
	 	http_request.open("post", url, true);
	 	http_request.send();
	}
	
	function callbackforXML() 
	{ 
		if (http_request.readyState == 4) 
		{ // 完成
	  		if (http_request.status == 200) 
	  		{ // 正常响应
	    		var xml=http_request.responseXML;
	  			var html="<table border='1' width='90%' align='center'><tr class='td_header' align='center'><td>序号</td><td>课程名称</td><td>分数</td></tr>";
	  			
	  			//获取XML中的所有score标签，放到scores数组
	    		var scores = xml.getElementsByTagName("score");
	    
	  			//对scores数组进行遍历，获取每个子节点的内容
	    		if (scores.length != 0) 
	    		{
	    			for (var i = 0; i < scores.length; i++) 
	    			{
	            		var score = scores[i];
						html+="<tr align='center'><td>"+(i+1)+"</td>"+
						"<td>"+score.childNodes[0].childNodes[0].nodeValue+"</td>"+
						"<td>"+score.childNodes[1].childNodes[0].nodeValue+"</td></tr>";
	        		}
		   			html+="</table>" ;
					document.getElementById("dataTable").innerHTML=html;
	    		}
	    		else
	    		{
	    			document.getElementById("dataTable").innerHTML="该学号不存在，或者该学生没有成绩信息！";
	   			}gai
			} 
		  	else 
		  	{
		    	alert("Problem: " + http_request.statusText);
		  	}
		}
	}
</script>
