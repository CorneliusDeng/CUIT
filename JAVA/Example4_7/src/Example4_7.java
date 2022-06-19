import java.util.Arrays;
public class Example4_7 
{

	public static void main(String[] args) 
	{
		char[] a = {'a', 'b', 'c', 'd'};
		
		for (int n = 0; n < a.length; n++)//传统方式遍历数组
		{
			System.out.print(a[n]+"");
		}
		
		System.out.println("");
		
		for (char ch : a)//循环变量ch依次取数组a中的每一个元素的值（非传统方式遍历数组）
		{
			System.out.print(ch+"");
		}
		
		System.out.println("");
		System.out.println(Arrays.toString(a));//要引入包java.util.Arrays
		//Arrays类调用public static String toString（int [] a）方法，可以得到参数指定的一维数组a的特定格式字符串表示
	}

}
