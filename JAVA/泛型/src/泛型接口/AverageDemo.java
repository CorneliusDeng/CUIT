package 泛型接口;

public class AverageDemo 
{

	public static void main(String[] args) 
	{
		// 使用整型数组构造泛型对象
		Integer []intArray = {1,2,3,4};
		AverageImpl<Integer> iobj = new AverageImpl<Integer>(intArray);
		System.out.println("iobj的平均值：" +iobj.avg());
		
		// 使用Double型数组构造泛型对象
		Double []dArray={1.0,2.0,3.0,4.0};
		AverageImpl<Double> dobj = new AverageImpl<Double>(dArray);
		System.out.println("dobj的平均值："+dobj.avg());
	}

}
