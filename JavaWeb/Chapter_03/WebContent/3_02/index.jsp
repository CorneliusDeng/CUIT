<%@ page contentType="text/html;charset=gb2312" %>
<%!
    int num=0;                      		//����һ����������
    synchronized void add(){     		//�÷���ʵ�ַ��ʴ������ۼӲ���
       num++;
    }
%>
<% add(); %>                      	<%-- �ýű��������ʵ�ַ��ʴ����ۼӵķ��� --%>
<html>
<body><center>���ǵ�<%=num%>λ���ʸ�ҳ���οͣ�</center></body>
</html>
