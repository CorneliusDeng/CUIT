package 有界类型;

public class BoundGeneric <T extends Number>
{
	// 定义泛型数组
	T [] array;
	public BoundGeneric(T [] array) 
	{
		this.array=array;
	}
	// 计算总和
	public double sum()
	{
		double sum = 0.0;
		for(T element : array)
		{
				sum = sum + element.doubleValue();
		}
			return sum;
	}

}
