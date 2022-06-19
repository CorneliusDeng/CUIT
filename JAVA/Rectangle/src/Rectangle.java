
public class Rectangle
{
	private double width;
	private double length;
	
	public double getwidth()
	{
		return width;
	} 
	
	public void setwidth(double width)
	{
		this.width = width;
	}
	
	public double getlength()
	{
		return length;
	}
	
	public void setlength(double length)
	{
		this.length = length;
	}

	
	public static void main(String[] args) 
	{
		Rectangle rectangle = new Rectangle();
		rectangle.setwidth(5);
		rectangle.setlength(10);
		System.out.println("长方形的面积="+(rectangle.length * rectangle.width));
	}

}
