#pragma once
#include <iostream>
#include <fstream>
#include <string.h>
#include <stdlib.h>
using namespace std;

class student
{/*******************学生类*******************/
public:
	char name[20];
	char xuehao[20];
	char major[20];
	student* next;
	void readfile(istream& in) { in >> name >> xuehao >> major; }
	void Input1() 
	{
		cout << "请输入学生的姓名： ";  cin >> name;
		cout << "请输入学生的专业： ";  cin >> major;
	}
	void show1() {
		cout << "姓名:  " << name <<  "\t学号:  " << xuehao <<  "\t专业： " << major << endl;
	}
};
class studentmanage 
{/*******************学生管理类*******************/
public:
	studentmanage();
	~studentmanage();
	int comparexh(char xuehao[20]);
	int comparexh2(char xuehao[20]);
	int comparename(char xuehao[20], char name[20]);
	void ShowMenu();
	void additem();
	void display();
	void display2();
	void find();
	void removeitem();
	void modifyitem();
	void save();
private:
	student* Head, * End;
	ifstream in;
	ofstream out;
	student* finditem(char* xuehao) {
		for (student* p = Head; p->next != End; p = p->next)
			if (!strcmp(p->next->xuehao, xuehao)) return p;
		return NULL;
	}
};

class teacher
{/*******************教师类*******************/
public:
	char gh[20];
	char name[20];
	char post[20];
	teacher* next;
	void ShowMenu();
	void Input3()
	{
		cout << "请输入教师的职工号： ";  cin >> gh;
		cout << "请输入教师的姓名： ";  cin >> name;
		cout << "请输入教师的职称： ";  cin >> post;
	}
	void readfile3(istream& in) { in >> gh >> name >> post; }
	void show3()
	{
		cout << "职工号:  " << gh << "\t姓名:  " << name << "\t职称： " << post << endl;
	}
};
class teachermanage
{/*******************教师管理类*******************/
public:
	teachermanage();
	~teachermanage();
	int comparegh(char gh[20]);
	int comparegh2(char gh[20]);
	int comparename(char gh[20], char name[20]);
	void ShowMenu();
	void additem();
	void display();
	void display2();
	void find();
	void removeitem();
	void modifyitem();
	void save();
private:
	teacher* Head, * End;
	ifstream in;
	ofstream out;
	teacher* finditem(char* gh) {
		for (teacher* p = Head; p->next != End; p = p->next)
			if (!strcmp(p->next->gh, gh))  return p;
		return NULL;
	}
};

class course
{/*******************课程类*******************/
public:
	char number[20];		        //课程编号
	char name[30];				    //课程名
	char teacher[20];			    //授课老师
	course* next;
	void Input2() {
		cout << "请输入课程编号："; cin >> number;
		cout << "请输入课程名: "; cin >> name;
		cout << "请输入授课老师: "; cin >> teacher;
	}
	void readfile2(istream& in) { in >> number >> name >> teacher; }
	void show2() 
	{
		cout << "课程编号:  " << number << "\t课程名:  " << name << "\t授课老师:  " << teacher << endl;
	}
};
class coursemanage
{/*******************课程管理类*******************/
public:
	coursemanage();
	~coursemanage();
	void ShowMenu();
	void additem();
	void fabucourse(teachermanage &t);
	void display();
	void find();
	void save();
	void modifyitem();
	void removeitem();
	int comparekc(char number[20]);
	int comparekc2(char number[20]);
	int checkfabu(char teacher[20]);
public:
	course* Head, * End;
	ifstream in;
	ofstream out;
	course* finditem(char* number) {
		for (course* p = Head; p->next != End; p = p->next)
			if (!strcmp(p->next->number, number)) return p;	    //如果已存在返回p->next
		return NULL;
	}
};




class sc :public student, public course 
{/*******************选课类*******************/
public:
	sc* next;
	void Inputname() { cout << "请输入你的姓名： "; cin >> student::name; }
	void Inputxuehao() { cout << "请输入你的学号: "; cin >> xuehao; }
	void Inputnumber() { cout << "请输入你要选择课程的编号: "; cin >> number; }
	void readfile4(istream& in) { in >> xuehao >> student::name >> number >> course::name >> teacher; }
	void Showslcourse() 
	{
		cout << "学号:  " << xuehao <<  "\t姓名:  " << student::name << "\t课程编号:  " << number << "\t课程名:  " << course::name << "\t授课老师:  " << teacher << endl;
	}
};

class selectcourse
{/*******************选课操作类*******************/
public:
	selectcourse();
	~selectcourse();
	void ShowMenu();
	int comparetest(char number[20]);
	void disslcourse();
	void disslcourse2(teachermanage& t);
	void select(studentmanage& s, coursemanage& c);
	void dismessage(studentmanage& s);
	
private:
	sc* Head, * End;
	ofstream out;
	ifstream in;
	sc* finditem2(char* xuehao) 
	{
		for (sc* p = Head; p->next != End; p = p->next)
			if (!strcmp(p->next->xuehao, xuehao))  return p->next;
		return NULL;
	}
};
