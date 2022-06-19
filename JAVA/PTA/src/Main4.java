
public class Main4 
{
	public static void table1()
	{
		//左下三角
		for (int i = 1; i <= 9; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void table2()
	{
		//左上三角
		for (int i = 1; i <= 9; i++)
		{
			for (int j = 9; j >= i; j--)
			{
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void table3()
	{
		//右下三角
		for (int i = 1; i <= 9; i++)
		{
			for (int k = 1; k <= 9 - i; k++)
			{
				System.out.print("\t");
			}
			for (int j = 1; j <= i; j++)
			{
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void table4()
	{
		//右上三角
		for (int i = 9; i >= 1; i--)
		{
			for (int k = 1; k <= 9 - i; k++)
			{
				System.out.print("\t");
			}
			for (int j = 1; j <= i; j++)
			{
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		
		table1();
		System.out.println();
		table2();
		System.out.println();
		table3();
		System.out.println();
		table4();

	}

}

