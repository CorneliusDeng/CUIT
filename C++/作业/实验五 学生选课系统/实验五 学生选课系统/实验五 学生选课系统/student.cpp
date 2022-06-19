#include "head.h"

studentmanage::studentmanage() 
{/*******************���캯��*******************/
	Head = new student;
	Head->next = new student;
	End = Head->next;
	in.open("D:\\ALL SourceCode\\C++sourcecode\\ʵ���� ѧ��ѡ��ϵͳ\\student_sort.txt");
	if (!in)
		cout << "��ѧ����Ϣ���������롣" << endl;
	else {
		while (!in.eof()) {
			End->readfile(in);
			if (End->name[0] == '\0')  break;
			End->next = new student;
			End = End->next;
		}
		in.close();
		cout << "��ȡѧ����Ϣ�ɹ�! " << endl;
	}
}
studentmanage::~studentmanage() 
{/*******************��������*******************/
	for (student* temp; Head->next != End;) 
	{
		temp = Head->next;
		Head->next = Head->next->next;
		delete temp;
	}
	delete Head, End;
}
int studentmanage::comparexh(char xuehao[20])
{/*******************�ж�ѧ���Ƿ��ظ�*******************/
	student* p = NULL;
	if (p = finditem(xuehao)) 
	{
		cout << "��ѧ�ŵ�ѧ����Ϣ�Ѵ���! " << endl;
		return 0;
	}
	else return 1;
}
int studentmanage::comparexh2(char xuehao[20]) 
{/*******************��ѡ��ʱ�ж��Ƿ��и�ѧ��*******************/
	student* p = NULL;
	if (p = finditem(xuehao)) return 0;
	else {
		cout << "�������ѧ�Ų���! " << endl;
		return 1;
	}
}
int studentmanage::comparename(char xuehao[20], char name[20]) 
{/*******************��ѡ��ʱ�ж������Ƿ���ȷ*******************/
	student* p = finditem(xuehao);
	if (!strcmp(p->next->name, name)) return  0;
	else 
	{
		cout << "���������������! " << endl;
		return 1;
	}
}
void studentmanage::ShowMenu() 
{/*******************ѧ������˵�*******************/
	cout << "\t\t* *************************************** *\n";
	cout << "\t\t*      ����� ѧ����Ϣ��������      *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t*             0  �����ϲ�                 *\n";
	cout << "\t\t*             1  ����ѧ����Ϣ             *\n";
	cout << "\t\t*             2  ��ʾѧ����Ϣ             *\n";
	cout << "\t\t*             3  ����ѧ����Ϣ             *\n";
	cout << "\t\t*             4  ɾ��ѧ����Ϣ             *\n";
	cout << "\t\t*             5  �޸�ѧ����Ϣ             *\n";
	cout << "\t\t*             6  ����ѧ����Ϣ             *\n";
	cout << "\t\t*                                         *\n";
	cout << "\t\t* *************************************** *\n";
}
void studentmanage::display() 
{/*******************�������ʾѧ����Ϣ*******************/
	for (student* p = Head->next; p != End; p = p->next)
		p->show1();
}
void studentmanage::display2() 
{/*******************ѧ������ʾ������Ϣ*******************/
	char xuehao[20];
	student* p;
	cout << "���������ѧ��: "; cin >> xuehao;
	if (p = finditem(xuehao)) {
		cout << "ѧ��:  " << p->next->xuehao << " ,  " << "����:  " << p->next->name << " ,  " << "רҵ�� " << p->next->major << endl;
	}
	else cout << "�������ѧ�Ų���! " << endl;
}
void studentmanage::additem() 
{/*******************���ѧ����Ϣ*******************/
	cout << "������ѧ��ѧ��: "; cin >> End->xuehao;
	if (comparexh(End->xuehao) == 1) {
		End->Input1();
		End->next = new student;
		End = End->next;
		cout << "��ӳɹ�! " << endl;
	}
}
void studentmanage::find() 
{/*******************����ѧ��*******************/
	char xuehao[20];
	student* p = NULL;
	cout << "������Ҫ����ѧ����ѧ��: ";
	cin >> xuehao;
	if (p = finditem(xuehao)) {
		p->next->show1();
	}
	else {
		cout << "û���ҵ���ѧ�ŵ�ѧ��!" << endl;
	}
}
void studentmanage::removeitem() 
{/*******************ɾ��ѧ��*******************/
	char xuehao[20];
	student* p = NULL, * temp = NULL;
	cout << "������Ҫɾ��ѧ����ѧ��: "; cin >> xuehao;
	if (p = finditem(xuehao)) 
	{
		temp = p->next;
		p->next = p->next->next;
		delete temp;
		cout << "ɾ���ɹ�! " << endl;
		cout << p->name;
	}
	else 
	{
		cout << "û���ҵ�! " << endl;
	}
}
void studentmanage::modifyitem() 
{/*******************�޸�ѧ����Ϣ*******************/
	char xuehao[20];
	student* p = NULL;
	cout << "������Ҫ�޸�ѧ����ѧ��: "; cin >> xuehao;
	if (p = finditem(xuehao)) {
		cout << "���ҵ�ѧ������Ϣ���������µ���Ϣ!" << endl;
		p->next->Input1();
		cout << "�޸ĳɹ�! " << endl;
	}
	else {
		cout << "û���ҵ�! " << endl;
	}
}
void studentmanage::save() 
{/*******************����ѧ����Ϣ*******************/
	out.open("D:\\ALL SourceCode\\C++sourcecode\\ʵ���� ѧ��ѡ��ϵͳ\\student_sort.txt");
	for (student* p = Head->next; p != End; p = p->next)
		out << p->name << "\t" << p->xuehao << "\t" << p->major << endl;
	out.close();
	cout << "��Ϣ�ѱ�����ָ���ļ�! " << endl;
}