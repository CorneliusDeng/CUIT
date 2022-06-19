<%@ page contentType="text/html;charset=GB2312" %>
<%
String path = request.getContextPath();
%>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">
<script type="text/javascript" src = "<%=path%>/js/datacheck.js"></script>
  <body>
  <center>									 
   <form name="frm" method="post" >
   <table border=0 width="60%">
	<tr class="td_header"><td >���γ̲�ѯ</td></tr>
   <tr><td>
        רҵ
      <select name="major" id="majorID" onchange="getGrade();">
      <option value="0">- -</option>
      <option value="1">�������</option>
      <option value="2">�ռ���Ϣ</option>
      </select>
       �꼶
      <select name="grade" id="gradeID"  onchange="getCourse();">
      <option value="0">- -</option>
      </select>
      �γ�
      <select name="course" id="courseID" onchange="getScore();">
      <option value="0">- -</option>
      </select>
   </table>   
   </form>
  
   
   <table border="1" bordercolor="#000000" cellpadding="5" cellspacing="0" width="60%" >
  <tr>
    <td width="60%"  id="dataTable" align="center">��ʾ��ȡ������</td>
  </tr>

</table>
 </center>
  </body>
</html>
<script>
	//1������Ajax����XMLHttpRequest����ʵ��	
    var http_request = false;
    function createRequest() {
        http_request = false;
        if (window.XMLHttpRequest) {     // Mozilla�������IE7����
            http_request = new XMLHttpRequest();
            if (http_request.overrideMimeType) {
                http_request.overrideMimeType('text/xml');     //����MIME���
            }
        } else if (window.ActiveXObject) {     // IE5��IE6�����
        
         var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
            for(var n=0; n<MSXML.length; n++){
                try{
                    var objXMLHttp = new ActiveXObject(MSXML[n]);
                    break;
                }catch(e){}
            }
            
 //           try {
 //               http_request = new ActiveXObject("Msxml2.XMLHTTP");
 //           } catch (e) {
 //               try {
 //                   http_request = new ActiveXObject("Microsoft.XMLHTTP");
 //              } catch (e) {}
 //           }
        }
  }
   function getGrade() { 
	var selectObj=document.getElementById("majorID");
	var major=selectObj[selectObj.selectedIndex].value;
	if(major==0) return;
	
    if(http_request==false){//XMLHttpRequest����δ����
    	createRequest();//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
    var url="<%=path%>/ScoreAction?Action=GetGradesByAjax&major="+major;
	
    http_request.onreadystatechange = callback_grade;
  	http_request.open("POST", url, true);
  	http_request.send(null);
  	
  }
 
  function callback_grade() { 
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ
    	 //alert(http_request.responseText);
     	 createGrade(http_request.responseXML);
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
  function createGrade(xml){ 
	var selectObj=document.getElementById("gradeID");
	//ɾ���б���ԭ������
	for(var i=selectObj.length-1;i>0;i--){
		selectObj.options.remove(i);
	}
	var selectObj1=document.getElementById("courseID");
	//ɾ���б���ԭ������
	for(var i=selectObj1.length-1;i>0;i--){
		selectObj1.options.remove(i);
	}

	//����XML�ڵ�
	var grades=xml.getElementsByTagName("grade");//alert(grades.length);
	if(grades.length>0){
		for(i=0;i<grades.length;i++){
			op=new Option(grades[i].childNodes[0].childNodes[0].nodeValue,grades[i].childNodes[0].childNodes[0].nodeValue);
			selectObj.options.add(op);
		}
		selectObj.selectedIndex=0;
	}
  } 
  function getCourse() {
	var selectObj=document.getElementById("majorID");
	var major=selectObj[selectObj.selectedIndex].value;
	selectObj=document.getElementById("gradeID");
	grade=selectObj[selectObj.selectedIndex].value;
	if(grade==0) return;

    if(http_request==false){//XMLHttpRequest����δ����
    	createRequest();//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
   
    var url="<%=path%>/ScoreAction?Action=GetCoursesByAjax&major="+major+"&grade="+grade;
    http_request.onreadystatechange = callback_course;
  	http_request.open("POST", url, true);
  	http_request.send(null);
  	
  }
 
  function callback_course() { 
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ
     	 createCourse(http_request.responseXML);
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
  function createCourse(xml){ 
	var selectObj=document.getElementById("courseID");
	//ɾ���б���ԭ������
	for(var i=selectObj.length-1;i>0;i--){
		selectObj.options.remove(i);
	}
	//����XML�ڵ�
	var courses=xml.getElementsByTagName("course");
	if(courses.length>0){
		for(i=0;i<courses.length;i++){
			op=new Option(courses[i].childNodes[1].childNodes[0].nodeValue,courses[i].childNodes[0].childNodes[0].nodeValue);
			selectObj.options.add(op);
		}
	}   
  } 
 
  function getScore() { 
	  document.getElementById("dataTable").innerHTML="��ʾ��ȡ������";
		var selectObj=document.getElementById("courseID");
		var courseID=selectObj[selectObj.selectedIndex].value;
		if(courseID==0) return;

		if(http_request==false){//XMLHttpRequest����δ����
	    	createRequest();//����XMLHttpRequest����
	    	if(http_request==false){return;} //�������ɹ�   	
	    }
	   
	    var url="<%=path%>/ScoreAction?Action=GetCourseAllScoresByAjax&courseID="+courseID;
	    http_request.onreadystatechange = callback_score;
	  	http_request.open("POST", url, true);
	  	http_request.send(null);
	  	
	  }
	 
	  function callback_score() { 
	    if (http_request.readyState == 4) { // ���
	      if (http_request.status == 200) { // ������Ӧ
	     	 createScore(http_request.responseXML);
	      } else {
	        alert("Problem: " + http_request.statusText);
	      }
	    }
	  }
	  function createScore(xml){ 
		  	var html="<table border='1' width='90%' align='center'><tr class='td_header' align='center'><td>���</td><td>ѧ��</td><td>����</td><td>����</td></tr>";
		    //��ȡXML�е�����score��ǩ���ŵ�scores����
		    var scores=xml.getElementsByTagName("score");
		    //��scores������б�������ȡÿ���ӽڵ������
		    if (scores.length != 0) {
		        for (var i = 0; i < scores.length; i++) {
		            var score = scores[i];
					html+="<tr align='center'><td>"+(i+1)+"</td>"+
					"<td>"+score.childNodes[0].childNodes[0].nodeValue+"</td>"+
					"<td>"+score.childNodes[1].childNodes[0].nodeValue+"</td>"+
					"<td>"+score.childNodes[2].childNodes[0].nodeValue+"</td></tr>";
		        }
			   	html+="</table>" ;
			   //	alert(html);
				document.getElementById("dataTable").innerHTML=html;
		    }else{
		    	document.getElementById("dataTable").innerHTML="�ÿγ�û��ѧ���ɼ���Ϣ��";
		    }
	  } 
	 
</script>