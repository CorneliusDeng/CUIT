
import java.util.*;
public class Main8 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int l = reader.nextInt();
		int w = reader.nextInt();
		Rectangle rectangle = new Rectangle(l, w);
		
		System.out.printf("长方形的面积为：%.1f\n", rectangle.area());
		System.out.printf("长方形的周长为：%.1f\n", rectangle.C());

		reader.close();
	}

}

class Rectangle
{
	int length, width;
	
	Rectangle(int l, int w)
	{
		length = l;
		width = w;
	}
	
	int getLength()
	{
		return length;
	}
	void setLength(int l)
	{
		length = l;
	}
	
	int getWidth()
	{
		return width;
	}
	void setWidth(int w)
	{
		width = w;
	}
	
	float area()
	{
		return length * width;
	}
	
	float C()
	{
		return (length + width) * 2;
	}
}
