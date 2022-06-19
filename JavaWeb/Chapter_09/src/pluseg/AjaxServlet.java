package pluseg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxServlet extends HttpServlet {
	private AreaDB beanDB=null;
	private String webPath="";

	public void init() throws ServletException {
		//获取web应用物理路径
		webPath=getServletConfig().getServletContext().getRealPath("");
		//构建业务处理Bean
		beanDB=new AreaDB(webPath); 					
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("Action");
		System.out.println("action="+action);
		if(action==null){
			return;
		}else if(action.equals("GetFlagByText")){//通过文本方式返回简单数据
			getFlagByTextAction(request,response);	
		}else if(action.equals("GetFlagByXML")){	//通过XML方式返回简单数据
			getFlagByXMLAction(request,response);		
		}else if(action.equals("GetDataByText")){//通过文本方式返回数据列表
			getDataByTextAction(request,response);	
		}else if(action.equals("GetDataByXML")){	//通过XML方式返回数据列表
			getDataByXMLAction(request,response);		
		}else if(action.equals("GetArea")){	//获取行政区域
			GetAreaAction(request,response);		
		}
	}
	private void getFlagByTextAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
	    if(code.equals("001")){
	    	out.print("1");//out.println("1");  
	    	//用于直接比较的简单数据不能用out.println，包含隐藏的换行符
	    }else{
	    	out.print("0");//	    	out.println("0");
	    }	
	}
	private void getFlagByXMLAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数中的中文，要进行编码转换
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"gb2312");
		//输出默认用UTF-8可以处理中文
		response.setContentType("text/xml;charset=UTF-8");	//返回xml 
		PrintWriter out = response.getWriter();
	    if(name.equals("李晓华")){
	    	out.print("<flag>1</flag>");
	    }else{
	    	out.print("<flag>0</flag>");
	    }	
	}
	private void getDataByTextAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//有中文输出时，设置格式和获取out对象的语句顺序不能变
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();
		String html="";
		html+="001,王虎,75,78,77";
		html+=";002,李芳,65,78,67";
		html+=";003,李晓明,55,88,74";
		html+=";004,张强,71,80,67";
		out.print(html);
	}
	private void getDataByXMLAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//有中文输出时，设置格式和获取out对象的语句顺序不能变
		response.setContentType("text/xml;charset=UTF-8");	//返回xml 
		PrintWriter out = response.getWriter();
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    out.println("<student><id>001</id><name>王虎</name><math>75</math><english>78</english><physic>77</physic></student>");
	    out.println("<student><id>002</id><name>李芳</name><math>65</math><english>78</english><physic>67</physic></student>");
	    out.println("<student><id>003</id><name>李晓明</name><math>55</math><english>88</english><physic>74</physic></student>");
	    out.println("<student><id>004</id><name>张强</name><math>71</math><english>80</english><physic>67</physic></student>");
	    out.println("</data>");	
	    out.flush();
	}
	private void GetAreaAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("parent="+request.getParameter("parent"));
		System.out.println("level="+request.getParameter("level"));
		int level=Integer.parseInt(request.getParameter("level"));
		int parent=Integer.parseInt(request.getParameter("parent"));
		response.setContentType("text/xml;charset=UTF-8");	 
		PrintWriter out = response.getWriter();
		ArrayList<AreaInfo> list=beanDB.getAreaes(level, parent);
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
	    out.println("<data>");
	    for(int i=0;i<list.size();i++){
	    	AreaInfo area=list.get(i);
	    	out.print("<area><id>"+area.getId()+"</id><name>"+area.getArea()+"</name>");
	    	out.println("<parent>"+area.getParentId()+"</parent><level>"+area.getLevel()+"</level></area>");
	    }
	    out.println("</data>");	
	    out.flush();	
	}

}
