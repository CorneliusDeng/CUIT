#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <windows.h>

/*书籍信息*/
typedef struct books
{
	char name[100];     //书名
	char num[30];	    //书号
	char author[40];    //作者
	char keyword[20];   //关键字
	char publish[40];   //出版社
	int count;          //数量
	int recent;			//现存数量
	int times;			//借阅次数
}BooksInformation;

/*读者信息*/
typedef struct student
{
	char num[20];		//学号
	char name[20];		//姓名
	int money;			//欠费金额
}StuInformation;

/*借阅信息*/
typedef struct borrow
{
	char studentnum[20];//学号
	char booknum[20];	//图书编号
	int time;			//借阅时间
}BorrowInfomation;

int BookNum;//书本基数
int StudentNum; //学生信息基数
int BorrowNum;//借阅记录基数

BooksInformation book[100], temp;
StuInformation student[1000], temp1;
BorrowInfomation borrow[1000];


/*登录界面*/
void Body1();
void Body2();
void welcome();

/*管理员的功能*/
void Add();                 //图书采编入库
int Delete();				//图书清除库存

void ReaderInfo();			//读者信息管理
void TypeinReaInfor();		//录入读者信息
int DeleReaInfor();			//删除读者信息

void BooksInfo();			//图书信息管理
int BInum();				//通过书名查找图书
int BIname();				//通过编号查找图书
int BIauthor();				//通过作者查找图书
int BIpub();				//通过出版社查找图书
int BIkeyword();			//通过关键字查找图书

void SearchReaInfo();		//查询读者信息
int SRInum();				//通过学号查询
int SRIname();				//通过姓名查询

void Calculate();			//信息统计计算

void Save(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]); //保存信息并退出系统
void Read(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]); //读取文件信息
void Read2(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]);//读取文件信息并显示内容


/*读者的功能*/
//void BooksInfo();			//图书检索(与管理员权限相同)
int Borrow();				//借阅图书
int Return();				//归还图书
//void Calculate();			//信息统计计算
//void Save(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]); //保存信息并退出系统



