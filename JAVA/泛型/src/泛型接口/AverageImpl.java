package 泛型接口;

public class AverageImpl<T extends Number> implements Average<T>
{
	T[] array;
	
	public AverageImpl(T[] array)
	{
		this.array = array;
	}
	
	@Override//重写实现接口方法
	public double avg() 
	{
		double sum = 0.0;
		for (T element : array) 
		{
			sum = sum + element.doubleValue();
		}
		
		return sum / array.length;
	}
	
}
