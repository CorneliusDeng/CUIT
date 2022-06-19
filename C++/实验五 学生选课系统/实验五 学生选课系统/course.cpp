#include "head.h"

coursemanage::coursemanage() 
{/*******************构造函数*******************/
	Head = new course;
	Head->next = new course;
	End = Head->next;
	in.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\course_sort.txt");
	if (!in) 
	{
		cout << "无课程信息，请先输入。" << endl;
	}
	else 
	{
		while (!in.eof()) 
		{
			End->readfile2(in);
			if (End->number[0] == '\0') break;
			End->next = new course;
			End = End->next;
		}
		in.close();
		cout << "读取课程信息成功! " << endl;
	}
}
coursemanage::~coursemanage()
{/*******************析构函数*******************/
	for (course* temp; Head->next != End;) 
	{
		temp = Head->next;
		Head->next = Head->next->next;
		delete temp;
	}
	delete Head, End;
}
void coursemanage::ShowMenu() 
{/*******************课程管理菜单*******************/
	cout << "\t\t* *************************************** *\n";
	cout << "\t\t*      ★★★★ 课程信息管理★★★★      *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t*             0  返回上层                 *\n";
	cout << "\t\t*             1  增加课程信息             *\n";
	cout << "\t\t*             2  显示课程信息             *\n";
	cout << "\t\t*             3  查找课程信息             *\n";
	cout << "\t\t*             4  删除课程信息             *\n";
	cout << "\t\t*             5  修改课程信息             *\n";
	cout << "\t\t*             6  保存课程信息             *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t* *************************************** *\n";
}
void coursemanage::additem() 
{/*******************管理员端添加课程*******************/
	cout << "请输入课程编号: "; cin >> End->number;
	if (comparekc(End->number) == 1) 
	{
		End->Input2();
		End->next = new course;
		End = End->next;
		cout << "添加成功! " << endl;
	}
}
void coursemanage::fabucourse(teachermanage &t) 
{/*******************教师端发布课程信息*******************/
	char gh[20];
	cout << "请输入你的工号: "; cin >> gh;
	if (t.comparegh2(gh) == 0) 
	{
		cout << "请输入你的姓名: "; cin >> End->teacher;
		if (t.comparename(gh, End->teacher) == 0) 
		{
			if (checkfabu(End->teacher) == 0) 
			{
				cout << "请输入课程编号: "; cin >> End->number;
				if (comparekc(End->number) == 1) 
				{
					cout << "请输入课程名: "; cin >> End->name;
					out.open("course_sort.txt", ios::app);
					out << End->number << "\t" << End->name << "\t" << End->teacher << '\n';
					End->next = new course;
					End = End->next;
					out.close();
					cout << "发布成功! " << endl;
				}
			}
			else 
			{
				cout << "你已经发布过课程了！ " << endl;
			}
		}
	}
}
void coursemanage::display() 
{/*******************显示课程信息*******************/
	for (course* p = Head->next; p != End; p = p->next)
		p->show2();
}
void coursemanage::find() 
{/*******************查找课程*******************/
	char number[20];
	course* p = NULL;
	cout << "请输入要查找的课程编号: "; cin >> number;
	if (p = finditem(number)) {
		p->next->show2();
	}
	else {
		cout << "没有找到该课程! " << endl;
	}
}
int coursemanage::comparekc(char number[20]) 
{/*******************判断课程是否存在*******************/
	course* p = NULL;
	if (p = finditem(number)) {
		cout << "该课程编号已存在 ! " << endl;
		return 0;
	}
	else return 1;
}
int coursemanage::comparekc2(char number[20]) 
{/*******************在选课时判断课程存在与否*******************/
	course* p = NULL;
	if (p = finditem(number))  return 0;
	else 
	{
		cout << "该课程还未开设! " << endl;
		return 1;
	}
}
int coursemanage::checkfabu(char teacher[20]) 
{/*******************在发布时判断课程存在与否*******************/
	course* p = NULL;
	for (course* p = Head; p->next != End; p = p->next)
		if (!strcmp(p->next->teacher, teacher)) return 1;	    //如果已存在返回1
	return 0;
}
void coursemanage::modifyitem() 
{/*******************修改课程*******************/
	char number[20];
	course* p = NULL;
	cout << "请输入要修改的课程编号: "; cin >> number;
	if (p = finditem(number)) 
	{
		cout << "已找到该课程的信息，请输入新的信息! " << endl;
		p->next->Input2();
		cout << "修改成功! " << endl;
	}
	else 
	{
		cout << "没有找到! " << endl;
	}
}
void coursemanage::removeitem() 
{/*******************删除课程*******************/
	char number[20];
	course* p = NULL, * temp = NULL;
	cout << "请输入要删除课程的编号: "; cin >> number;
	if (p = finditem(number)) 
	{
		temp = p->next;
		p->next = p->next->next;
		delete temp;
		cout << "删除成功! " << endl;
	}
	else 
	{
		cout << "没有找到! " << endl;
	}
}
void coursemanage::save() 
{
	out.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\course_sort.txt");
	for (course* p = Head->next; p != End; p = p->next)
		out << p->number << "\t" << p->name << "\t" << p->teacher << '\n';
	out.close();
	cout << "课程信息已存至指定文件! " << endl;
}