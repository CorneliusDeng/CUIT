package CircleRing;

import java.util.Scanner;

public class Test {

	public static void main(String args[])
	{
		CircleRing ringA = new CircleRing();
		CircleRing ringB = new CircleRing();
		Scanner reader = new Scanner(System.in);
		
		ringA.setInnerRadius(15);
		ringA.setOuterRadius(20);
		ringA.setColor("Red");
		
		double area =  Math.pow(ringA.outerRadius - ringA.innerRadius,2) * CircleRing.PI;
		
		System.out.println("由我提供的内外半径数据，得出这个圆环的面积与颜色是：");
		System.out.printf("%.7f\n", area);
		System.out.println("Color:"+ ringA.getColor());
		
		System.out.println("现在，屏幕面前的你也可以重新输入内外圆环半径以调整圆环大小");
		System.out.print("内圆环：");
		double innerradius = reader.nextDouble();
		System.out.print("外圆环：");
		double outerradius = reader.nextDouble();
		System.out.print("颜色：");
		String co = reader.next();
		
		ringB.setInnerRadius(innerradius);
		ringB.setOuterRadius(outerradius);
		ringB.setColor(co);
		
		double area1 =  Math.pow(outerradius - innerradius,2) * CircleRing.PI;
		System.out.printf("面积是：%.7f\n", area1);
		System.out.println("Color:"+ ringB.getColor());
		System.out.println("当前圆环对象的个数是" + CircleRing.CirNum);
		
		reader.close();//以消除Resource leak: 'reader' is never closed，释放内存
	}

}
