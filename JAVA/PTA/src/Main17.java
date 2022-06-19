import java.util.*;
public class Main17 
{
	public static void main(String[] args) 
	{
		person teacher=new Teacher("Jason",28,"男",10000,"外国语学院");
		student stu[]=new student[5];
		for(int i = 0; i < 5; i++)
		{
			stu[i]=new student();
		}
			
		stu[0].setName("张三");
		stu[0].setAge(18);
		stu[0].setGender("男");
		stu[0].setScore(new int[]{120,130,144,110,125});
		stu[0].setGrade("软工2018级");
		stu[1].setName("李四");
		stu[1].setAge(19);
		stu[1].setGender("男");
		stu[1].setScore(new int[]{112,123,122,144,125});
		stu[1].setGrade("软工2018级");
		System.out.println(teacher);
		for(int i=0;i<5;i++) System.out.println(stu[i]);
	}
}

class person
{
	private String name;// 姓名
	private int age;// 年龄
	private String gender;// 性别
	
	public person()
	{
		
	}
	
	public person(String name, int age, String gender)
	{
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//Person
	public String toString() 
	{
		return "name=" + name + ", age=" + age + ", gender=" + gender+", ";
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
}

class Teacher extends person
{
	private float salary;// 薪酬
	private String department;// 部门
	
	public Teacher()
	{
		
	}
	
	public Teacher(String name, int age, String gender, float salary, String department)
	{
		super(name,age,gender);
		this.salary = salary;
		this.department = department;
	}
	//Teacher
	public String toString() 
	{
		return "Teacher: "+super.toString()+"salary=" + salary + ", department=" + department ;
	}
}

class student extends person
{
	private int[] score;// 成绩
	private String grade;// 年级
	
	public student()
	{
		
	}
	public student(String name, int age, String gender, int [] score, String grade)
	{
		super(name,age,gender);
		this.score = score;
		this.grade = grade;
	}
	
	//Student
	public String toString() 
	{
		return "Student: "+super.toString()+"score=" + Arrays.toString(score) + ", grade=" + grade;
	}
	
	public void setScore(int[] score)
	{
		this.score = score;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}

}











