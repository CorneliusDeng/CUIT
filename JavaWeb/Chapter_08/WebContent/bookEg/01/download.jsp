<%@ page contentType="text/html; charset=gb2312" language="java"%>
<jsp:useBean id="upFile" scope="page" class="com.jspsmart.upload.SmartUpload" />
<%
try{
	response.reset();
	out.clear();
	out=pageContext.pushBody();
	upFile.initialize(pageContext);
	upFile.setContentDisposition(null);
	String file="/bookEg/01/upload/"+request.getParameter("filename");
	upFile.downloadFile(file);
}catch(Exception e){
	out.println("<script>alert('文件下载失败：请检查选择的文件是否存在？')</script>");
}
%>