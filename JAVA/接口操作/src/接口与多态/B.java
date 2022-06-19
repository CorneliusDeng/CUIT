package 接口与多态;

public class B implements CompurerAverage
{
	public double average(double a, double b)
	{
		double aver = 0;
		aver = Math.sqrt(a * b);
		return aver;
	}
}
