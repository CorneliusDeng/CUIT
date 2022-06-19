#include "head.h"

studentmanage::studentmanage() 
{/*******************构造函数*******************/
	Head = new student;
	Head->next = new student;
	End = Head->next;
	in.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\student_sort.txt");
	if (!in)
		cout << "无学生信息，请先输入。" << endl;
	else {
		while (!in.eof()) {
			End->readfile(in);
			if (End->name[0] == '\0')  break;
			End->next = new student;
			End = End->next;
		}
		in.close();
		cout << "读取学生信息成功! " << endl;
	}
}
studentmanage::~studentmanage() 
{/*******************析构函数*******************/
	for (student* temp; Head->next != End;) 
	{
		temp = Head->next;
		Head->next = Head->next->next;
		delete temp;
	}
	delete Head, End;
}
int studentmanage::comparexh(char xuehao[20])
{/*******************判断学号是否重复*******************/
	student* p = NULL;
	if (p = finditem(xuehao)) 
	{
		cout << "该学号的学生信息已存在! " << endl;
		return 0;
	}
	else return 1;
}
int studentmanage::comparexh2(char xuehao[20]) 
{/*******************在选课时判断是否有该学生*******************/
	student* p = NULL;
	if (p = finditem(xuehao)) return 0;
	else {
		cout << "你输入的学号不对! " << endl;
		return 1;
	}
}
int studentmanage::comparename(char xuehao[20], char name[20]) 
{/*******************在选课时判断姓名是否正确*******************/
	student* p = finditem(xuehao);
	if (!strcmp(p->next->name, name)) return  0;
	else 
	{
		cout << "你输入的姓名不对! " << endl;
		return 1;
	}
}
void studentmanage::ShowMenu() 
{/*******************学生管理菜单*******************/
	cout << "\t\t* *************************************** *\n";
	cout << "\t\t*      ★★★★ 学生信息管理★★★★      *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t*             0  返回上层                 *\n";
	cout << "\t\t*             1  增加学生信息             *\n";
	cout << "\t\t*             2  显示学生信息             *\n";
	cout << "\t\t*             3  查找学生信息             *\n";
	cout << "\t\t*             4  删除学生信息             *\n";
	cout << "\t\t*             5  修改学生信息             *\n";
	cout << "\t\t*             6  保存学生信息             *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t* *************************************** *\n";
}
void studentmanage::display() 
{/*******************管理端显示学生信息*******************/
	for (student* p = Head->next; p != End; p = p->next)
		p->show1();
}
void studentmanage::display2() 
{/*******************学生端显示个人信息*******************/
	char xuehao[20];
	student* p;
	cout << "请输入你的学号: "; cin >> xuehao;
	if (p = finditem(xuehao)) {
		cout << "学号:  " << p->next->xuehao << " ,  " << "姓名:  " << p->next->name << " ,  " << "专业： " << p->next->major << endl;
	}
	else cout << "你输入的学号不对! " << endl;
}
void studentmanage::additem() 
{/*******************添加学生信息*******************/
	cout << "请输入学生学号: "; cin >> End->xuehao;
	if (comparexh(End->xuehao) == 1) {
		End->Input1();
		End->next = new student;
		End = End->next;
		cout << "添加成功! " << endl;
	}
}
void studentmanage::find() 
{/*******************查找学生*******************/
	char xuehao[20];
	student* p = NULL;
	cout << "请输入要查找学生的学号: ";
	cin >> xuehao;
	if (p = finditem(xuehao)) {
		p->next->show1();
	}
	else {
		cout << "没有找到该学号的学生!" << endl;
	}
}
void studentmanage::removeitem() 
{/*******************删除学生*******************/
	char xuehao[20];
	student* p = NULL, * temp = NULL;
	cout << "请输入要删除学生的学号: "; cin >> xuehao;
	if (p = finditem(xuehao)) 
	{
		temp = p->next;
		p->next = p->next->next;
		delete temp;
		cout << "删除成功! " << endl;
		cout << p->name;
	}
	else 
	{
		cout << "没有找到! " << endl;
	}
}
void studentmanage::modifyitem() 
{/*******************修改学生信息*******************/
	char xuehao[20];
	student* p = NULL;
	cout << "请输入要修改学生的学号: "; cin >> xuehao;
	if (p = finditem(xuehao)) {
		cout << "已找到学生的信息，请输入新的信息!" << endl;
		p->next->Input1();
		cout << "修改成功! " << endl;
	}
	else {
		cout << "没有找到! " << endl;
	}
}
void studentmanage::save() 
{/*******************保存学生信息*******************/
	out.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\student_sort.txt");
	for (student* p = Head->next; p != End; p = p->next)
		out << p->name << "\t" << p->xuehao << "\t" << p->major << endl;
	out.close();
	cout << "信息已保存至指定文件! " << endl;
}