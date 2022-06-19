<%@ page import="java.util.*,eg5_10.*" contentType="text/html;charset=gb2312"%>
<%
	ShopCar myCar=new ShopCar();

	String action=request.getParameter("action");
	//System.out.println("action="+action);
	if(action==null)
		action="";	
	if(action.equals("buy")){									//购买商品
	ArrayList goodslist=(ArrayList)session.getAttribute("goodslist");	
	int id=MyTools.strToint(request.getParameter("id"));		
	//System.out.println("id="+id);
		GoodsSingle single=(GoodsSingle)goodslist.get(id);
		myCar.addItem(single);		//调用ShopCar类中的addItem()方法添加商品
		response.sendRedirect("show.jsp");		
	}
	else if(action.equals("remove")){							//移除商品
		String name=request.getParameter("name");		//获取商品名称
		myCar.removeItem(name);		//调用ShopCar类中的removeItem()方法移除商品
		response.sendRedirect("shopcar.jsp");		
	}
	else if(action.equals("clear")){							//清空购物车
		myCar.clearCar();				//调用ShopCar类中的clearCar()方法清空购物车
		response.sendRedirect("shopcar.jsp");
	}
	else{
		response.sendRedirect("show.jsp");		
	}	
%>