#include <iostream>
#include <fstream> //包含ofstream ifstream
using namespace std;

int main()
{
	/***************************************读文件测试*****************************************/
	cout << "【测试文件输入流】" << endl;
	ifstream myFileread1; //声明一个静态文件输入流对象
	myFileread1.open("D:\\ALL SourceCode\\C++sourcecode\\实验四 流类库与输入输出练习\\Test.txt", 
		ios_base::binary);//以二进制方式打开文件
	if (!myFileread1.is_open())
	{
		cout << "文件打开失败" << endl;
		exit(0);
	}
	cout << "从指定文件中输出内容如下：" << endl;
	char bufferread1[100];
	while (!myFileread1.eof())
	{
		myFileread1.getline(bufferread1, 100);
		cout << bufferread1 << endl;
	}
	myFileread1.close();

	/***************************************写文件测试*****************************************/
	cout << endl << "【测试文件输出流】" << endl;
	ofstream myFilewrite; //声明一个静态文件输出流对象
	myFilewrite.open("D:\\ALL SourceCode\\C++sourcecode\\实验四 流类库与输入输出练习\\Test.txt",
		ios::binary | ios_base::app);//追加到文件尾部
	if (!myFilewrite.is_open())
	{
		cout << "文件打开失败" << endl;
		exit(0);
	}

	string str;//需要输入的字符串
	char temp;
	cout <<  "输入字符串,按回车键结束输入" << endl;
	while ((temp = cin.get()) != '\n')
	{
		str += temp;
	}
	const int LEN = str.length();
	char *bufferwrite = new char[LEN];//根据输入字符串的长度，创建字符数组
	for (int i = 0; i < LEN; i++) //将字符串保存到字符数组中
	{
		bufferwrite[i] = str[i];
	}
	myFilewrite << "\n";
	myFilewrite.write(bufferwrite, LEN);
	cout << endl << "内容写入成功！" << endl;
	myFilewrite.close();
		
	/***************************************读写文件测试*****************************************/
	cout << endl << "【测试文件输出流是否写入成功】" << endl;
	ifstream myFileread2; //声明一个静态文件输出流对象
	myFileread2.open("D:\\ALL SourceCode\\C++sourcecode\\实验四 流类库与输入输出练习\\Test.txt",
		ios_base::binary | ios_base::in);//以二进制方式打开文件
	if (!myFileread2.is_open())
	{
		cout << "文件打开失败" << endl;
		exit(0);
	}
	cout << "从指定文件中输出内容如下：" << endl;
	char bufferread2[100];
	while (!myFileread2.eof())
	{
		myFileread2.getline(bufferread2, 100);
		cout << bufferread2 << endl;
	}
	myFileread2.close();

	cout << endl << "【恭喜您，操作成功！】" << endl;
	
	return 0;
}