package ch9;
//基于UDP的简单的Client/Server程序设计

public class QuoteServer{
	public static void main(String args[]) throws java.io.IOException{
		new QuoteServerThread().start();
		//启动一个QuoteServerThread线程
	}
}
