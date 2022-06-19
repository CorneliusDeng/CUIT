#include "head.h"

selectcourse::selectcourse() 
{
	Head = new sc;
	Head->next = new sc;
	End = Head->next;
	in.open("selectcourse_sort.txt");
	if (!in)
		cout << "暂无学生选课信息。" << endl;
	else 
	{
		while (!in.eof()) 
		{
			End->readfile4(in);
			if (End->xuehao[0] == '\0')  break;
			End->next = new sc;
			End = End->next;
		}
		in.close();
	}
}
selectcourse::~selectcourse() 
{/*******************析构函数*******************/
	for (sc* temp; Head->next != End;) 
	{
		temp = Head->next;
		Head->next = Head->next->next;
		delete temp;
	}
	delete Head, End;
}
void selectcourse::disslcourse() 
{/*******************管理员端显示选课情况*******************/
	in.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\selectcourse_sort.txt");
	if (!in)
		cout << "暂无学生选课信息。" << endl;
	else 
	{
		for (sc* p = Head->next; p != End; p = p->next) 
		{
			p->Showslcourse();
		}
	}
	in.close();
}
void selectcourse::disslcourse2(teachermanage& t) 
{/*******************教师端查看选课情况*******************/
	char  gh[20];
	char name[20];
	int sum = 0;
	sc* p, *temp;
	cout << "请输入你的工号: "; cin >> gh;
	if (t.comparegh2(gh) == 0) 
	{
		cout << "请输入你的姓名: "; cin >> name;
		if (t.comparename(gh, name) == 0) 
		{
			for (p = Head->next; p != End; p = p->next) 
			{
				if (!strcmp(p->teacher, name)) 
				{
					sum++;
					temp = p;
				}
			}
			cout << "课程编号:  " << temp->course::number << ",  " << "课程名:  " << temp->course::name << ",   " << "已选人数:  " << sum << '\0';
		}
	}
}
void selectcourse::ShowMenu() 
{/*******************学生端菜单*******************/
	cout << "\t\t* *************************************** *\n";
	cout << "\t\t*        ★★★★ 学生端★★★★          *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t*             0  退出系统                 *\n";
	cout << "\t\t*             1  开始选课                 *\n";
	cout << "\t\t*             2  显示课程信息             *\n";
	cout << "\t\t*             3  查看个人信息             *\n";
	cout << "\t\t*             4  查看选课情况             *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t* *************************************** *\n";
}
int selectcourse::comparetest(char xuehao[20]) 
{/*******************判断学生是否选过课*******************/
	sc* p = NULL;
	if (p = finditem2(xuehao)) 
	{
		cout << "你已经选过课程了! " << endl;
		return 1;
	}
	else return 0;
}
void selectcourse::select(studentmanage& s, coursemanage& c) 
{/*******************学生选课函数*******************/
	End->Inputxuehao();
	if (s.comparexh2(End->xuehao) == 0)
	{
		if (comparetest(End->xuehao) == 0)
		{
			End->Inputname();
			if (s.comparename(End->xuehao, End->student::name) == 0) 
			{
				End->Inputnumber();
				if (c.comparekc2(End->number) == 0) 
				{
					course* p = c.finditem(End->number);
					out.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\selectcourse_sort.txt", ios::app);
					out << End->xuehao << "\t" << End->student::name << "\t" << p->next->number << "\t" << p->next->name << "\t" << p->next->teacher << '\n';
					End->next = new sc;
					End = End->next;
					out.close();
					cout << "选课成功!  " << endl;
				}
			}
		}
	}
		
}
void selectcourse::dismessage(studentmanage& s) 
{/*******************学生端查看选课情况*******************/
	char xuehao[20];
	sc* p;
	cout << "请输入你的学号: "; cin >> xuehao;
	if (s.comparexh2(xuehao) == 0) 
	{
		for (p = Head->next; p != End; p = p->next) 
		{
			if (!strcmp(p->xuehao, xuehao))  break;
		}
		if (!strcmp(p->xuehao, xuehao)) 
		{
			cout << "学号:  " << p->xuehao << ",  " << "姓名:  " << p->student::name << ",   " << "已选课程编号:  " << p->number << '\0';
		}
		else cout << "你还没有选课! " << endl;
	}
}