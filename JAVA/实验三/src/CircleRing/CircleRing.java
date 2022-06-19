package CircleRing;

public class CircleRing 
{
	public double innerRadius, outerRadius;
	public String color;
	public static final double PI = 3.1415926;
	public static int CirNum = 0;
	
	public CircleRing()//构造函数,一般用来初始化成员属性和成员方法的，即new对象产生后，就调用了对象了属性和方法。
	{
		CirNum++;
	}
	
	public double getInnerRadius()
	{
		return innerRadius;
	}
	public void setInnerRadius(double inrad)
	{
		this.innerRadius = inrad;
	}
	
	public double getOuterRadius()
	{
		return outerRadius;
	}
	public void setOuterRadius(double outrad)
	{
		this.outerRadius = outrad;
	}
	
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
}
	
	
	
