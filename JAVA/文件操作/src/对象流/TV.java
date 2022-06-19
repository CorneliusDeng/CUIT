package 对象流;

public class TV //implements Serializable
//一个类实现了Serializable接口，那么这个类创建的对象就是序列化对象
{
	//private static final long serialVersionUID = -5863919511562612946L;
	String name;
	int price;
	
	public void setName(String s )
	{
		name = s;
	}
	public void setPrice(int n)
	{
		price = n;
	}
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
	}
}
