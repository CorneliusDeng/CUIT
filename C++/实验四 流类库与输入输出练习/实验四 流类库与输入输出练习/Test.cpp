#include <iostream>
#include <fstream> //����ofstream ifstream
using namespace std;

int main()
{
	/***************************************���ļ�����*****************************************/
	cout << "�������ļ���������" << endl;
	ifstream myFileread1; //����һ����̬�ļ�����������
	myFileread1.open("D:\\ALL SourceCode\\C++sourcecode\\ʵ���� ����������������ϰ\\Test.txt", 
		ios_base::binary);//�Զ����Ʒ�ʽ���ļ�
	if (!myFileread1.is_open())
	{
		cout << "�ļ���ʧ��" << endl;
		exit(0);
	}
	cout << "��ָ���ļ�������������£�" << endl;
	char bufferread1[100];
	while (!myFileread1.eof())
	{
		myFileread1.getline(bufferread1, 100);
		cout << bufferread1 << endl;
	}
	myFileread1.close();

	/***************************************д�ļ�����*****************************************/
	cout << endl << "�������ļ��������" << endl;
	ofstream myFilewrite; //����һ����̬�ļ����������
	myFilewrite.open("D:\\ALL SourceCode\\C++sourcecode\\ʵ���� ����������������ϰ\\Test.txt",
		ios::binary | ios_base::app);//׷�ӵ��ļ�β��
	if (!myFilewrite.is_open())
	{
		cout << "�ļ���ʧ��" << endl;
		exit(0);
	}

	string str;//��Ҫ������ַ���
	char temp;
	cout <<  "�����ַ���,���س�����������" << endl;
	while ((temp = cin.get()) != '\n')
	{
		str += temp;
	}
	const int LEN = str.length();
	char *bufferwrite = new char[LEN];//���������ַ����ĳ��ȣ������ַ�����
	for (int i = 0; i < LEN; i++) //���ַ������浽�ַ�������
	{
		bufferwrite[i] = str[i];
	}
	myFilewrite << "\n";
	myFilewrite.write(bufferwrite, LEN);
	cout << endl << "����д��ɹ���" << endl;
	myFilewrite.close();
		
	/***************************************��д�ļ�����*****************************************/
	cout << endl << "�������ļ�������Ƿ�д��ɹ���" << endl;
	ifstream myFileread2; //����һ����̬�ļ����������
	myFileread2.open("D:\\ALL SourceCode\\C++sourcecode\\ʵ���� ����������������ϰ\\Test.txt",
		ios_base::binary | ios_base::in);//�Զ����Ʒ�ʽ���ļ�
	if (!myFileread2.is_open())
	{
		cout << "�ļ���ʧ��" << endl;
		exit(0);
	}
	cout << "��ָ���ļ�������������£�" << endl;
	char bufferread2[100];
	while (!myFileread2.eof())
	{
		myFileread2.getline(bufferread2, 100);
		cout << bufferread2 << endl;
	}
	myFileread2.close();

	cout << endl << "����ϲ���������ɹ�����" << endl;
	
	return 0;
}