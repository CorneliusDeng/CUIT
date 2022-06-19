#include "head.h"

int main()
{
	int x, x1, x2, x3, x4, x5;
	bool quit1 = false;
	bool quit2 = false;
	cout << "\t\t◎★★★★【欢迎进入学生选课系统】★★★★◎\n";
	cout << "\t\t*                                          *\n";
	cout << "\t\t*            0  退出系统                   *\n";
	cout << "\t\t*            1  管理员端                   *\n";
	cout << "\t\t*            2  学生端                     *\n";
	cout << "\t\t*            3  教师端                     *\n";
	cout << "\t\t*                                          *\n";
	cout << "\t\t********************************************\n\n";

	studentmanage students;
	coursemanage courses;
	teachermanage teachers;
	selectcourse slcourse;
	teacher teacher;
	cout << "选择登入方式: "; cin >> x;
	switch (x) 
{
	case 0:exit(0); break;		 //****退出系统
	case 1:		                        //*********进入管理员端
		system("cls");
		char password[8];
		cout << "请输入管理员密码: "; cin >> password;
		if (strcmp(password, "123456") == 0) {
		loop:   system("cls");
			cout << "\t\t* *************************************** *\n";
			cout << "\t\t*       ★★★★ 管理员端★★★★         *\n";
			cout << "\t\t*                                         *\n";
			cout << "\t\t*              0  退出系统                *\n";
			cout << "\t\t*              1  学生信息管理            *\n";
			cout << "\t\t*              2  教师信息管理            *\n";
			cout << "\t\t*              3  课程信息管理            *\n";
			cout << "\t\t*              4  查看选课情况            *\n";
			cout << "\t\t*                                         *\n";
			cout << "\t\t* *************************************** *\n";
			while (1) 
			{
				cout << "请选择: "; cin >> x1;
				switch (x1) {
				case 0:exit(0); break;
				case 1:
					system("cls");
					students.ShowMenu();
					while (1) 
					{
						cout << "\n请选择: ";
						cin >> x2;
						switch (x2) 
						{
							case 0:goto loop; break;
							case 1:students.additem();  break;
							case 2:students.display(); break;
							case 3:students.find(); break;
							case 4:students.removeitem(); break;
							case 5:students.modifyitem(); break;
							case 6:students.save(); break;
						}
					}break;
				case 2:
					system("cls");
					teachers.ShowMenu();
					while (1) {
						cout << "\n请选择: ";
						cin >> x3;
						switch (x3) 
						{
							case 0:goto loop; break;
							case 1:teachers.additem();  break;
							case 2:teachers.display(); break;
							case 3:teachers.find(); break;
							case 4:teachers.removeitem(); break;
							case 5:teachers.modifyitem(); break;
							case 6:teachers.save(); break;
						}
					}break;
				case 3:
					system("cls");
					courses.ShowMenu();
					while (1) 
					{
						cout << "\n请选择: ";
						cin >> x4;
						switch (x4) 
						{
							case 0:goto loop; break;
							case 1:courses.additem();  break;
							case 2:courses.display(); break;
							case 3:courses.find(); break;
							case 4:courses.removeitem(); break;
							case 5:courses.modifyitem(); break;
							case 6:courses.save(); break;
						}
					}break;
				case 4:
					slcourse.disslcourse(); break;
				default:
					break;
				}
			}
		}
		else 
		{
			cout << "密码错误! "; exit(0); break;
		}break;
	case 2:                               //*********进入学生端
		system("cls");
		slcourse.ShowMenu();
		while (1) 
		{
			cout << "\n请选择: ";
			cin >> x4;
			switch (x4) 
			{
				case 0:exit(0); break;
				case 1:slcourse.select(students, courses);  break;
				case 2:courses.display(); break;
				case 3:students.display2(); break;
				case 4:slcourse.dismessage(students); break;
			}
		} break;
	case 3:								 //*********进入教师端
		system("cls");
		teacher.ShowMenu();
		while (1) 
		{
			cout << "\n请选择: ";
			cin >> x5;
			switch (x5) 
			{
				case 0:exit(0); break;
				case 1:teachers.display2();  break;
				case 2:slcourse.disslcourse2(teachers); break;
				case 3:courses.fabucourse(teachers); break;
			}
		} break;
	}
	system("pause");
}