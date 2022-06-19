import java.util.*;
public class Main2 
{
	static class MyException extends Exception
	{
		public MyException(String message)
		{
			super(message);
			System.out.println(message);
		}
	}
	public static float CD (float a, float b) throws MyException
	{
		if (b == 0)
		{
			throw new MyException("0做除数无意义!");
		}
		return a / b;
	}

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		float a, b, c;
		
		try
		{
			System.out.println("请输入被除数和除数");
			a = reader.nextFloat();
			b = reader.nextFloat();
			c = CD(a, b);
			System.out.println("the result is " + c);
		}
		catch(MyException e)
		{
			
		}
		reader.close();
	}

}

