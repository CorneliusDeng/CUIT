<%@ page import="java.util.*,eg5_10.*" contentType="text/html;charset=gb2312"%>
<%
	ShopCar myCar=new ShopCar();

	String action=request.getParameter("action");
	//System.out.println("action="+action);
	if(action==null)
		action="";	
	if(action.equals("buy")){									//������Ʒ
	ArrayList goodslist=(ArrayList)session.getAttribute("goodslist");	
	int id=MyTools.strToint(request.getParameter("id"));		
	//System.out.println("id="+id);
		GoodsSingle single=(GoodsSingle)goodslist.get(id);
		myCar.addItem(single);		//����ShopCar���е�addItem()���������Ʒ
		response.sendRedirect("show.jsp");		
	}
	else if(action.equals("remove")){							//�Ƴ���Ʒ
		String name=request.getParameter("name");		//��ȡ��Ʒ����
		myCar.removeItem(name);		//����ShopCar���е�removeItem()�����Ƴ���Ʒ
		response.sendRedirect("shopcar.jsp");		
	}
	else if(action.equals("clear")){							//��չ��ﳵ
		myCar.clearCar();				//����ShopCar���е�clearCar()������չ��ﳵ
		response.sendRedirect("shopcar.jsp");
	}
	else{
		response.sendRedirect("show.jsp");		
	}	
%>