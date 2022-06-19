package StudentGrade;
import java.util.*;

public class Test 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		Student[] students = new Student[6];//三名本科生三名研究生
		
		//本科生
		students[0] = new Undergraduate("嬴政", "本科生", 98f, 78.5f, 30f);//子类对象继承父类对象
		students[1] = new Undergraduate("刘邦", "本科生", 75f, 99.5f, 65f);
		students[2] = new Undergraduate("刘秀", "本科生", 45f, 75.5f, 85f);
		
		//研究生
		students[3] = new Postgraduate("乾隆", "研究生", 100f, 75f, 93f);
		students[4] = new Postgraduate("雍正", "研究生", 56f, 84f, 65f);
		students[5] = new Postgraduate("康熙", "研究生", 92f, 53f, 71f);
		
		//计算等级
		for (int i = 0; i < 6; i++)
		{
			students[i].RatingLevel(students[i].scoreJava, students[i].scoreC, students[i].scoreMath); 
		}
		
	
		System.out.println("\t\t【软件工程学院混合班第一学年成绩评定表】\n姓名\t类型\tJava成绩\tJava等级\t"
				+ "C语言成绩\tC语言等级\t"
				+ "高数成绩\t高数等级");
		
		for (int j = 0; j < 6; j++)
		{
			if (students[j].type.equals("本科生"))
			{
				System.out.println(" ");
			}
			if (students[j].type.equals("研究生"))
			{
				System.out.println(" ");
			}
			students[j].display();
		}
		
		reader.close();
	}

}
