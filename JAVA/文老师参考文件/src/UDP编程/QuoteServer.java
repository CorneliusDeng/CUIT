package UDP编程;

public class QuoteServer 
{
	public static void main(String args[]) throws java.io.IOException
	{
		new QuoteServerThread().start();
		//启动一个QuoteServerThread线程
	}
}
