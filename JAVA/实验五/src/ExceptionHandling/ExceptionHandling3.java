package ExceptionHandling;
import java.util.*;

public class ExceptionHandling3 
{
	
	public static double CD(double a, double b) throws MyException 
	{
		if (Math.abs(b) < 0.0001)
		{
			throw new MyException("除零异常");
		}
		else
		{
			return a / b;
		}
	}
	
	
	public static void main(String[] args) 
	{

		Scanner reader = new Scanner(System.in);
		double x, y, z;
		System.out.println("现在请您输入双精度浮点型的被除数与除数");
		try
		{
			/*
			 * Double.parseDouble方法是把数字类型的字符串，转换成double类型
			 *Double.valueOf方法是把数字类型的字符串，转换成Double类型  
			 * 不直接用reader.nextDouble()的原因是避免两次输入的空格或者回车影响了异常的判断*/
			x = Double.valueOf(reader.next());
			y = Double.valueOf(reader.next());
			z = CD(x,y);
			System.out.println("计算之后的结果是："+ z);
		}
		catch(MyException e)
		{
			System.out.println("(0做除数无意义！)");
		}
		catch(NumberFormatException e)
		{
			System.out.println("发生异常， 数字格式错误");
		}
		catch(Exception e)
		{
			System.out.println("程序发生异常");
		}
		finally
		{
			System.out.println("程序结束");
		}
		
		
		reader.close();
	}

}
