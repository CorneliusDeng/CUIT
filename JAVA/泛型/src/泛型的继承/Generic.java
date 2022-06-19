package 泛型的继承;

public class Generic <T> //T表示一个占位符
{
	private T ob; // 定义泛型成员变量
	public Generic(T ob) 
	{
		this.ob = ob;
	}
	public T getOb() 
	{
		return ob;
	}
	public void setOb(T ob) 
	{
		this.ob = ob;
	}
	public void showType() 
	{
		System.out.println("T的实际类型是: " + ob.getClass().getName());
	}
}
