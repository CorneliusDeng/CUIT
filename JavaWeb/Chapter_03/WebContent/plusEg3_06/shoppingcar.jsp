<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>
<%
String userName=session.getAttribute("name").toString();//��ȡseesion�е��û�����Ϣ
Hashtable shoppingCar=(Hashtable)session.getAttribute("ShoppingCar");//��ȡseesion�еĹ��ﳵ��Ϣ
if(shoppingCar==null){
	shoppingCar=new Hashtable();
}
request.setCharacterEncoding("GB2312");  
String vegetable[]=request.getParameterValues("vegetable"); //��ȡ�ͻ���ѡ����߲�������
if(vegetable!=null){ 
	for(int i=0;i<vegetable.length;i++) {//�����߲�������
		String str=(String)shoppingCar.get(vegetable[i]);
        	int count= str==null?0:Integer.parseInt(str);//��ȡָ���߲˵�����
		count++;
		shoppingCar.put(vegetable[i],count+"");//�޸�ָ���߲˵�����
        }
}
session.setAttribute("ShoppingCar",shoppingCar);//�����޸ĺ�Ĺ��ﳵ��Ϣ
%> 
<HTML><BODY >
<P>�˿͡�<%=userName%>�����ã����Ĺ��ﳵ��Ϣ���£�
<table border=1><tr><td>�ײ�</td><td>���</td><td>�ܲ�</td><td>����</td></tr>
<tr><td><%=shoppingCar.get("�ײ�")==null?0:shoppingCar.get("�ײ�")%></td>
<td><%=shoppingCar.get("���")==null?0:shoppingCar.get("���")%></td>
<td><%=shoppingCar.get("�ܲ�")==null?0:shoppingCar.get("�ܲ�")%></td>
<td><%=shoppingCar.get("����")==null?0:shoppingCar.get("����")%></td></tr>
</table>
<a href="goodslist.jsp">��������</a>
</BODY></HTML>
