package ExceptionHandling;
import java.util.*;

public class ExceptionHandling2 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		double a, b, c;
		
		System.out.println("现在请您输入双精度浮点型的被除数与除数");
		
		
		try
		{
			/*
			 * Double.parseDouble方法是把数字类型的字符串，转换成double类型
			 *Double.valueOf方法是把数字类型的字符串，转换成Double类型  
			 * 不直接用reader.nextDouble()的原因是避免两次输入的空格或者回车影响了异常的判断*/
			a = Double.valueOf(reader.next());
			b = Double.valueOf(reader.next());
			c = a / b;
			System.out.println("计算之后的结果是："+c);
		}
		catch(ArithmeticException e)
		{//在java中，浮点数double和float可以除0，返回无穷大，(double)0只是一个无限逼近于0的数
			System.out.println("发生异常， 除数不能为0");
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
