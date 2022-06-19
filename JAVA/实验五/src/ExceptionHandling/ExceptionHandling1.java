package ExceptionHandling;
import java.util.*;

public class ExceptionHandling1 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int a, b;
		float c;
		
		System.out.println("现在请您输入整型的被除数与除数");
		
		
		try
		{
			/*parseInt()返回的是基本类型int 而valueOf()返回的是包装类Integer  
			 * 不直接用reader.nextInt()的原因是避免两次输入的空格或者回车影响了异常的判断*/
			a = Integer.valueOf(reader.next());
			b = Integer.valueOf(reader.next());
			c = a / b;
			System.out.println("计算之后的结果是："+c);
		}
		catch(ArithmeticException e)
		{
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
