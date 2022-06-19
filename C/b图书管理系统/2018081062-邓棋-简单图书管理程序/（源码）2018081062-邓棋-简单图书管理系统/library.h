#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <windows.h>

/*�鼮��Ϣ*/
typedef struct books
{
	char name[100];     //����
	char num[30];	    //���
	char author[40];    //����
	char keyword[20];   //�ؼ���
	char publish[40];   //������
	int count;          //����
	int recent;			//�ִ�����
	int times;			//���Ĵ���
}BooksInformation;

/*������Ϣ*/
typedef struct student
{
	char num[20];		//ѧ��
	char name[20];		//����
	int money;			//Ƿ�ѽ��
}StuInformation;

/*������Ϣ*/
typedef struct borrow
{
	char studentnum[20];//ѧ��
	char booknum[20];	//ͼ����
	int time;			//����ʱ��
}BorrowInfomation;

int BookNum;//�鱾����
int StudentNum; //ѧ����Ϣ����
int BorrowNum;//���ļ�¼����

BooksInformation book[100], temp;
StuInformation student[1000], temp1;
BorrowInfomation borrow[1000];


/*��¼����*/
void Body1();
void Body2();
void welcome();

/*����Ա�Ĺ���*/
void Add();                 //ͼ��ɱ����
int Delete();				//ͼ��������

void ReaderInfo();			//������Ϣ����
void TypeinReaInfor();		//¼�������Ϣ
int DeleReaInfor();			//ɾ��������Ϣ

void BooksInfo();			//ͼ����Ϣ����
int BInum();				//ͨ����������ͼ��
int BIname();				//ͨ����Ų���ͼ��
int BIauthor();				//ͨ�����߲���ͼ��
int BIpub();				//ͨ�����������ͼ��
int BIkeyword();			//ͨ���ؼ��ֲ���ͼ��

void SearchReaInfo();		//��ѯ������Ϣ
int SRInum();				//ͨ��ѧ�Ų�ѯ
int SRIname();				//ͨ��������ѯ

void Calculate();			//��Ϣͳ�Ƽ���

void Save(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]); //������Ϣ���˳�ϵͳ
void Read(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]); //��ȡ�ļ���Ϣ
void Read2(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]);//��ȡ�ļ���Ϣ����ʾ����


/*���ߵĹ���*/
//void BooksInfo();			//ͼ�����(�����ԱȨ����ͬ)
int Borrow();				//����ͼ��
int Return();				//�黹ͼ��
//void Calculate();			//��Ϣͳ�Ƽ���
//void Save(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[]); //������Ϣ���˳�ϵͳ



