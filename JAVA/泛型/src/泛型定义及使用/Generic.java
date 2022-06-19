package 泛型定义及使用;

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
    public void showTyep() 
    {
    	System.out.println("实际类型是: " + ob.getClass().getName());
    }
}
