package 泛型方法;

public class GenericMethodDemo 
{
	public static void main(String[] args) 
	{
		Integer[] intArray1 = { 1, 2, 3, 4 };
		Integer[] intArray2 = {-1, 2, 3, 6 };
		// 比较两个整型数组
		int result = GenericMethod.sumEquals(intArray1, intArray2);
		if (result == 0) 
		{
			System.out.println("sum(intArray1) == sum(intArray2)");
		}
		// 比较整型数组和浮点类型数组
		Double []dArray={1.0,2.0,3.0,4.0};
		result = GenericMethod.sumEquals(intArray1, dArray);
		if (result == 0) 
		{
			System.out.println("sum(intArray1) == sum(dArray)");
		}
		
		// 下面语句将报错,String不是Number的子类
//		String []strArray1={"str1","str2"};
		
//		result = GenericMethod.sumEquals(strArray1, intArray1);
	}

}
