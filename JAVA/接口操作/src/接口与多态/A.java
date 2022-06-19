package 接口与多态;

public class A implements CompurerAverage
{
	public double average(double a, double b)
	{
		double aver = 0;
		aver = (a + b) / 2;
		return aver;
	}
}
