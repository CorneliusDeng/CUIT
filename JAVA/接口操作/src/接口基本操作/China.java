package 接口基本操作;

public class China implements Computable //China类实现Computable接口
{
	int number;
	public int f(int x)   //不可省略public关键字
	{
		int sum = 0;
		for (int i = 1; i <= x; i++)
		{
			sum += i;
		}
		return sum;
	}
}
