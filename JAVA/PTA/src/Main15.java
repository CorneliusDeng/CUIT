import java.util.*;
import java.text.DecimalFormat;
public class Main15 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入半径");
		double r = reader.nextDouble();
		Circle circle = new Circle(r);
        DecimalFormat d = new DecimalFormat("#.###");
		System.out.println(d.format(circle.getArea()));
		System.out.println(d.format(circle.getPerimeter()));
		reader.close();
	}

}

abstract class shape 
{// 抽象类
	public abstract double getArea();// 求面积
	public abstract double getPerimeter(); // 求周长
}

class Circle extends shape
{
	private double r;
	
	public Circle(double r)
	{
		this.r = r;
	}

	public double getArea() 
	{
		return Math.PI * r * r;
	}

	public double getPerimeter() 
	{
		return Math.PI * 2 * r;
	}
}