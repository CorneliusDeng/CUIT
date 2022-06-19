<%
    int i,j;
%>
<html>
<body>
    <table border=1>
<% 
   for(i=1;i<=9;i++)
   {    
       out.println("<tr>");
       for(j=1;j<=i;j++)
       { 
           out.println("<td>"+i+"*"+j+"="+(i*j)+"</td>");
       }
       out.println("</tr>");
   }
 %>
    </table>  
</body>
</html>