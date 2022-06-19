import java.util.Scanner;

public class TemperatureChange 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		double centigrade, fahrenheit;
		System.out.print("请输入想要转换的摄氏度：");
		centigrade = scanner.nextDouble();
		fahrenheit = centigrade * 1.8 + 32;
		System.out.println("转换成华氏度之后是："+fahrenheit);
		scanner.close();
	}

}
