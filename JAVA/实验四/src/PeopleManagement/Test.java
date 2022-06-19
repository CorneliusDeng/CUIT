package PeopleManagement;
import java.util.*;

public class Test 
{

	public static void main(String[] args) 
	{
		System.out.println("【您已进入学校人事管理系统】");
		Scanner reader = new Scanner(System.in);
		
		//教师信息
		TeacherInformation[] TeaInfor = new TeacherInformation[10];
		TeaInfor[0] = new TeacherInformation("软件", "男", 1001, "1978-01-01", "软件工程教学部门",
				"特级教师", 23000);
		TeaInfor[1] = new TeacherInformation("工程", "女", 1002, "1978-01-02", "软件工程教学部门",
				"特级教师", 22000);
		TeaInfor[2] = new TeacherInformation("专业", "男", 1003, "1978-01-03", "软件工程教学部门",
				"特级教师", 21000);
		System.out.println("\t\t\t\t教师信息");
		System.out.printf("姓名\t性别\t编号\t生日\t\t教学部门\t\t职称\t工资\n");
		for (int i = 0; i < 3; i++)
		{
			TeaInfor[i].display();
		}
		
		//学生信息
		StudentInformation[] StuInfor = new StudentInformation[10];
		StuInfor[0] = new StudentInformation("中国", "女", 7001, "1949-10-01", 750, 
				"软件工程", "软工182班" );
		StuInfor[1] = new StudentInformation("四川", "男", 7002, "1949-10-02", 730, 
				"软件工程", "软工182班" );
		StuInfor[2] = new StudentInformation("成都", "女", 7003, "1949-10-03", 710, 
				"软件工程", "软工182班" );
		System.out.println("\t\t\t\t学生信息");
		System.out.printf("姓名\t性别\t编号\t生日\t\t高考分数\t所属专业\t班级\n");
		for (int i = 0; i < 3; i++)
		{
			StuInfor[i].display();
		}
	
		
		//增删查改
		int n = 3;//教师信息的计步器
		int m = 3;//学生信息的计步器
		//这两个计步器放在while外面，以免每次循环被重新定义为3，使得自增自减毫无意义
		
		System.out.println("");
		while (true)
		{
			
			System.out.println("如果你想对教师信息进行操作（增、删、查、改），请输入1");
			System.out.println("如果你想对学生信息进行操作（增、删、查、改），请输入2");
			System.out.print("如果你想退出系统，请输入0\t\t");
			
			int option = reader.nextInt();
			
			if (option == 1)//教师信息操作
			{
					
				System.out.print("请输入你想进行操作的教师编号\t");
				System.out.print("增加 1 删除 2 查询 3 改动 4\t");
				int teaoption = reader.nextInt();
				if (teaoption == 1)//增加信息
				{
					TeaInfor[n] = new TeacherInformation();
					System.out.println("请输入教师姓名");
					TeaInfor[n].setName(reader.next());
					System.out.println("请输入教师性别");
					TeaInfor[n].setGender(reader.next());
					System.out.println("请输入教师编号");
					TeaInfor[n].setNum(reader.nextInt());
					System.out.println("请输入教师出生日期");
					TeaInfor[n].setDate(reader.next());
					System.out.println("请输入教师所属部门");
					TeaInfor[n].setDepartment(reader.next());
					System.out.println("请输入教师职称");
					TeaInfor[n].setTechnicalpost(reader.next());
					System.out.println("请输入教师工资");
					TeaInfor[n].setSalary(reader.nextDouble());
					System.out.println("增加的教师信息如下");
					TeaInfor[n].display();
					n++;//为下一次做准备
					System.out.println("系统教师信息已更新");
					for (int i = 0; i < n; i++)
					{
						TeaInfor[i].display();
					}
				}
				else if (teaoption == 2)//删除信息
				{
					System.out.println("请输入要删除的教师信息的编号");
					int teanum = reader.nextInt();
					for (int j = 0; j < n; j++)
					{
						if (teanum == TeaInfor[j].num)
						{
							for (int k = j; k < n; k++)
							{
								TeaInfor[k] = TeaInfor[k+1];
							}
							n--;
							break;
						}
					}
					System.out.println("系统教师信息已更新");
					for (int i = 0; i < n; i++)
					{
						TeaInfor[i].display();
					}
					
				}
				else if (teaoption == 3)//查询
				{
					System.out.println("请输入要查询的教师信息的编号");
					int teanum = reader.nextInt();
					int flag = 0, b = 0;
					for (int j = 0; j < n; j++)
					{
						if (teanum == TeaInfor[j].num)
						{
							System.out.println("找到该教师的信息，显示如下");
							b = j;
							flag = 1;
						}
					}
					if (flag == 1)
					{
						TeaInfor[b].display();
					}
					else
					{
						System.out.println("未找到该教师的信息");
					}
					

				}
				else if (teaoption == 4)//改动
				{
					System.out.println("请输入要查询的教师信息的编号");
					int teanum = reader.nextInt();
					int flag = 0, b = 0;
					for (int j = 0; j < n; j++)
					{    
					    if (teanum == TeaInfor[j].num)
						{
							System.out.println("找到该教师的信息，显示如下");
							TeaInfor[j].display();
							System.out.println("现在请您输入修改信息");
							System.out.println("请输入教师姓名");
							TeaInfor[j].setName(reader.next());
							System.out.println("请输入教师性别");
							TeaInfor[j].setGender(reader.next());
							System.out.println("请输入教师编号");
							TeaInfor[j].setNum(reader.nextInt());
							System.out.println("请输入教师出生日期");
							TeaInfor[j].setDate(reader.next());
							System.out.println("请输入教师所属部门");
							TeaInfor[j].setDepartment(reader.next());
							System.out.println("请输入教师职称");
							TeaInfor[j].setTechnicalpost(reader.next());
							System.out.println("请输入教师工资");
							TeaInfor[j].setSalary(reader.nextDouble());
							System.out.println("修改完成之后信息显示如下");
							b = j;
							flag = 1;
							
						}
					}
					if (flag == 1)
					{
						TeaInfor[b].display();
					}
					else
					{
						System.out.println("未找到该教师的信息");
					}
				}
				else
				{
					System.out.printf("请重新输入\n\n");
				}
			}
			else if (option == 2)//学生信息操作
			{
				
				
				System.out.print("请输入你想进行操作的学生学号\t");
				System.out.print("增加 1 删除 2 查询 3 改动 4\t");
				int stuoption = reader.nextInt();
				if (stuoption == 1)//增加信息
				{
					StuInfor[m] = new StudentInformation();
					System.out.println("请输入学生姓名");
					StuInfor[m].setName(reader.next());
					System.out.println("请输入学生性别");
					StuInfor[m].setGender(reader.next());
					System.out.println("请输入学生学号");
					StuInfor[m].setNum(reader.nextInt());
					System.out.println("请输入学生出生日期");
					StuInfor[m].setDate(reader.next());
					System.out.println("请输入学生高考分数");
					StuInfor[m].setScore(reader.nextFloat());
					System.out.println("请输入学生的专业");
					StuInfor[m].setField(reader.next());
					System.out.println("请输入学生班级");
					StuInfor[m].setClassname(reader.next());
					System.out.println("增加的学生信息如下");
					StuInfor[m].display();
					m++;//为下一次做准备
					System.out.println("系统学生信息已更新");
					for (int i = 0; i < m; i++)
					{
						StuInfor[i].display();
					}
				}
				else if (stuoption == 2)//删除信息
				{
					System.out.println("请输入要删除的学生信息的编号");
					int teanum = reader.nextInt();
					for (int q = 0; q < m; q++)
					{
						if (teanum == StuInfor[q].num)
						{
							for (int w = q; w < m; w++)
							{
								StuInfor[w] = StuInfor[w+1];
							}
							m--;
							break;
						}
					}
					System.out.println("系统学生信息已更新");
					for (int i = 0; i < m; i++)
					{
						StuInfor[i].display();
					}
					
				}
				else if (stuoption == 3)//查询
				{
					System.out.println("请输入要查询的学生信息的编号");
					int stunum = reader.nextInt();
					int flag = 0, b = 0;
					for (int q = 0; q < m; q++)
					{
						if (stunum == StuInfor[q].num)
						{
							System.out.println("找到该学生的信息，显示如下");
							b = q;
							flag = 1;
						}
					}
					if (flag == 1)
					{
						StuInfor[b].display();
					}
					else
					{
						System.out.println("未找到该学生的信息");
					}
					
				}
				else if (stuoption == 4)//改动
				{
					System.out.println("请输入要查询的学生信息的编号");
					int stunum = reader.nextInt();
					int flag = 0, b = 0;
					for (int q = 0; q < m; q++)
					{
						if (stunum == StuInfor[q].num)
						{
							System.out.println("找到该学生的信息，显示如下");
							StuInfor[q].display();
							System.out.println("现在请您输入修改信息");
							System.out.println("请输入学生姓名");
							StuInfor[q].setName(reader.next());
							System.out.println("请输入学生性别");
							StuInfor[q].setGender(reader.next());
							System.out.println("请输入学生学号");
							StuInfor[q].setNum(reader.nextInt());
							System.out.println("请输入学生出生日期");
							StuInfor[q].setDate(reader.next());
							System.out.println("请输入学生高考分数");
							StuInfor[q].setScore(reader.nextFloat());
							System.out.println("请输入学生的专业");
							StuInfor[q].setField(reader.next());
							System.out.println("请输入学生班级");
							StuInfor[q].setClassname(reader.next());
							System.out.println("修改完成之后信息显示如下");
							b = q;
							flag = 1;
						}
					}
					if (flag == 1)
					{
						StuInfor[b].display();
					}
					else
					{
						System.out.println("未找到该学生的信息");
					}
				}
				else
				{
					System.out.println("请重新输入");
				}
				
			}
			else if (option == 0)
			{
				break;
			}
			else
			{
				System.out.printf("请重新输入\n\n");
			}
			
		}
		reader.close();
	}
}
