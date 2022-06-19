package 读取线程中的值并打印;

public class TestCounter 
{
	public static void main(String[] args) 
	{
		Storage s = new Storage();
		Printer printer = new Printer(s);
		Counter counter = new Counter(s);
		counter.start();
		printer.start();
	}
}
