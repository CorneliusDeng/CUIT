package 泛型方法;

public class GenericMethod 
{
	// 根据传递的数组计算数组总和
	public static <T extends Number> double sum(T[ ] arrays) 
	{
		double sum = 0.0;
		for (T element : arrays) 
		{
			sum = sum + element.doubleValue();
		}
		
		return sum;
	}
	// 根据传递的数组比较数组总和是否相等，如果相等返回0，
	// 如果第一个数组的和大于第二个数组返回1，否则返回-1
	public static <T extends Number> int sumEquals(T[] arrays1, T[] arrays2) 
	{
		double sum1= sum(arrays1);
		double sum2 = sum(arrays2);
		if (sum1 ==sum2) return 0;
		else if (sum1>sum2) return 1;
		else return -1;
	}
}
