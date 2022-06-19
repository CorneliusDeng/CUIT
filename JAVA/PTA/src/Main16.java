
import java.util.*;
import java.text.DecimalFormat;
public class Main16 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		DecimalFormat d = new DecimalFormat("#.##");
		System.out.println("请输入长方形长 宽");
		double length = reader.nextDouble();
		double width = reader.nextDouble();
		
		Rectangle18 rectangle = new Rectangle18(length, width);
		System.out.println(d.format(rectangle.getArea()));
		System.out.println(d.format(rectangle.getPerimeter()));
		
		reader.close();
	}

}

abstract class Shape18 
{// 抽象类

    // 抽象方法 求面积 
   public abstract double getArea( );

  //抽象方法 求周长
   public abstract double getPerimeter( );
}

class Rectangle18 extends Shape18
{
	private double length, width;
	
	public Rectangle18(double l, double w)
	{
		length = l;
		width = w;
	}
	@Override
	public double getArea() 
	{
		return length * width;
	}

	@Override
	public double getPerimeter() 
	{
		return (length + width) * 2;
	}
	
}

