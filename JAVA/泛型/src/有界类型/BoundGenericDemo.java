package 有界类型;

public class BoundGenericDemo 
{

	public static void main(String[] args) 
	{
		Integer [] intArray = {1,2,3,4};
		// 使用整型数组构造泛型对象
		
		BoundGeneric<Integer> iobj = new BoundGeneric<Integer>(intArray);
		System.out.println("iobj的和为："+iobj.sum());
		Double []dArray={1.0,2.0,3.0,4.0};
		// 使用Double型数组构造泛型对象
		BoundGeneric<Double> dobj = new BoundGeneric<Double>(dArray);
		System.out.println("dobj的和为："+dobj.sum());
		
		/*
		 *  下面语句将报错，String不是Number的子类
		 *  BoundGeneric<String> sobj = new BoundGeneric<String>(strArray);
		 * */
		


	}

}
