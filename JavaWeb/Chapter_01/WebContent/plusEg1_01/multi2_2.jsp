<%
    int i,j;
%>
<html>
<body>
    <table border=1>
<% 
   for(i=1;i<=9;i++){ 
%>   
       <tr>
<%
       for(j=1;j<=i;j++){
%>
	<td><%=i%>*<%=j%>=<%=i*j%></td>
<%
       }
%>
       </tr>
<%
   }
%>
    </table>  
</body>
</html>