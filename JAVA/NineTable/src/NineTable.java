
public class NineTable {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++)
		{
			for (int j = 1; j <= 9; j++)
			{
				//输出a*b=c形式
				System.out.println(j + "*" + i + "=" + i * j + "");
			}
			//输出空行
			System.out.println();
		}

	}

}
