package 接口变量做参数;

public class Example7_4 
{

	public static void main(String[] args)
	{
		KindHello kindhello = new KindHello();
		kindhello.lookHello(new Chinese());
		kindhello.lookHello(new English());
	}

}
