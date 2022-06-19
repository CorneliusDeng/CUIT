#include "head.h"

void teacher::ShowMenu() 
{/*******************教师端菜单*******************/
	cout << "\t\t* *************************************** *\n";
	cout << "\t\t*        ★★★★ 教师端★★★★          *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t*             0  退出系统                 *\n";
	cout << "\t\t*             1  查看个人信息             *\n";
	cout << "\t\t*             2  查看选课信息             *\n";
	cout << "\t\t*             3  发布课程                 *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t* *************************************** *\n";
}

teachermanage::teachermanage() 
{/*******************构造函数*******************/
	Head = new teacher;
	Head->next = new teacher;
	End = Head->next;
	in.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\teacher_sort.txt");
	if (!in)
		cout << "无教师信息，请先输入。" << endl;
	else 
	{
		while (!in.eof()) 
		{
			End->readfile3(in);
			if (End->gh[0] == '\0') break;
			End->next = new teacher;
			End = End->next;
		}
		in.close();
		cout << "读取教师信息成功! " << endl;
	}
}
teachermanage::~teachermanage() 
{/*******************析构函数*******************/
	for (teacher* temp; Head->next != End;) {
		temp = Head->next;
		Head->next = Head->next->next;
		delete temp;
	}
	delete Head, End;
}
int teachermanage::comparegh(char gh[20]) 
{/*******************判断工号是否重复*******************/
	teacher* p = NULL;
	if (p = finditem(gh)) {
		cout << "该工号的教师信息已存在! " << endl;
		return 0;
	}
	else return 1;
}
int teachermanage::comparegh2(char gh[20]) 
{/*******************判断教师是否存在*******************/
	teacher* p = NULL;
	if (p = finditem(gh))  	return 0;
	else {
		cout << "你输入的工号不对! " << endl;
		return 1;
	}
}
int teachermanage::comparename(char gh[20], char name[20]) 
{/*******************教师端判断姓名是否正确*******************/
	teacher* p = finditem(gh);
	if (!strcmp(p->next->name, name)) return  0;
	else {
		cout << "你输入的姓名不对! " << endl;
		return 1;
	}
}
void teachermanage::ShowMenu() 
{/*******************教师管理菜单*******************/
	cout << "\t\t* *************************************** *\n";
	cout << "\t\t*      ★★★★ 教师信息管理★★★★      *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t*             0  返回上层                 *\n";
	cout << "\t\t*             1  增加教师信息             *\n";
	cout << "\t\t*             2  显示教师信息             *\n";
	cout << "\t\t*             3  查找教师信息             *\n";
	cout << "\t\t*             4  删除教师信息             *\n";
	cout << "\t\t*             5  修改教师信息             *\n";
	cout << "\t\t*             6  保存教师信息             *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t* *************************************** *\n";
}
void teachermanage::display() 
{/*******************显示教师信息*******************/
	for (teacher* p = Head->next; p != End; p = p->next)
		p->show3();
}
void teachermanage::display2() 
{/*******************教师端显示个人信息*******************/
	char gh[20];
	teacher* p;
	cout << "请输入你的工号: "; cin >> gh;
	if (p = finditem(gh)) 
	{
		cout << "工号:  " << p->next->gh << " ,  " << "姓名:  " << p->next->name << " ,  " << "职称： " << p->next->post << endl;
	}
	else cout << "你输入的工号错误! " << endl;
}
void teachermanage::additem() 
{/*******************添加教师信息*******************/
	cout << "请输入教师学号: "; cin >> End->gh;
	if (comparegh(End->gh) == 1) {
		End->Input3();
		End->next = new teacher;
		End = End->next;
		cout << "添加成功! " << endl;
	}
}
void teachermanage::find() 
{/*******************查找教师*******************/
	char gh[20];
	teacher* p = NULL;
	cout << "请输入要查找教师的工号: ";
	cin >> gh;
	if (p = finditem(gh)) {
		p->next->show3();
	}
	else {
		cout << "没有找到该学号的教师!" << endl;
	}
}
void teachermanage::removeitem() 
{/*******************删除教师*******************/
	char gh[20];
	teacher* p = NULL, * temp = NULL;
	cout << "请输入要删除教师的工号: "; cin >> gh;
	if (p = finditem(gh)) {
		temp = p->next;
		p->next = p->next->next;
		delete temp;
		cout << "删除成功! " << endl;
	}
	else {
		cout << "没有找到! " << endl;
	}
}
void teachermanage::modifyitem() 
{/*******************修改教师信息*******************/
	char gh[20];
	teacher* p = NULL;
	cout << "请输入要修改教师的学号: "; cin >> gh;
	if (p = finditem(gh)) 
	{
		cout << "已找到教师的信息，请输入新的信息!" << endl;
		p->next->Input3();
		cout << "修改成功! " << endl;
	}
	else 
	{
		cout << "没有找到! " << endl;
	}
}
void teachermanage::save() 
{/*******************保存教师信息*******************/
	out.open("D:\\ALL SourceCode\\C++sourcecode\\实验五 学生选课系统\\teacher_sort.txt");
	for (teacher* p = Head->next; p != End; p = p->next)
		out << p->gh << "\t" << p->name << "\t" << p->post << '\n';
	out.close();
	cout << "信息已保存至指定文件! " << endl;
}
