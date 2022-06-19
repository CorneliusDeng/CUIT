public class AverageTest {

	public static void main(String[] args) 
	{
		String a = args[0];
		String b = args[1];
		String c = args[2];
		int number1 = Integer.valueOf(a);
		int number2 = Integer.valueOf(b);
		int number3 = Integer.valueOf(c);
		
		int d;
		
		d = (number1 + number2 +number3) / 3;
		
		System.out.println(d);

	}

}
