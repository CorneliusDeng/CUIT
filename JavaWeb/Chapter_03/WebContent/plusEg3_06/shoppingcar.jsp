<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>
<%
String userName=session.getAttribute("name").toString();//获取seesion中的用户名信息
Hashtable shoppingCar=(Hashtable)session.getAttribute("ShoppingCar");//获取seesion中的购物车信息
if(shoppingCar==null){
	shoppingCar=new Hashtable();
}
request.setCharacterEncoding("GB2312");  
String vegetable[]=request.getParameterValues("vegetable"); //获取客户端选择的蔬菜名数组
if(vegetable!=null){ 
	for(int i=0;i<vegetable.length;i++) {//遍历蔬菜名数组
		String str=(String)shoppingCar.get(vegetable[i]);
        	int count= str==null?0:Integer.parseInt(str);//获取指定蔬菜的数量
		count++;
		shoppingCar.put(vegetable[i],count+"");//修改指定蔬菜的数量
        }
}
session.setAttribute("ShoppingCar",shoppingCar);//保存修改后的购物车信息
%> 
<HTML><BODY >
<P>顾客【<%=userName%>】您好，您的购物车信息如下：
<table border=1><tr><td>白菜</td><td>青菜</td><td>萝卜</td><td>蒜苗</td></tr>
<tr><td><%=shoppingCar.get("白菜")==null?0:shoppingCar.get("白菜")%></td>
<td><%=shoppingCar.get("青菜")==null?0:shoppingCar.get("青菜")%></td>
<td><%=shoppingCar.get("萝卜")==null?0:shoppingCar.get("萝卜")%></td>
<td><%=shoppingCar.get("蒜苗")==null?0:shoppingCar.get("蒜苗")%></td></tr>
</table>
<a href="goodslist.jsp">继续购物</a>
</BODY></HTML>
