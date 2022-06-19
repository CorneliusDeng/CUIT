#include "head.h"

int main() 
{	//主函数
	int a, b, c, d;

	cout << "请输入第一个虚数的实部和虚部" << endl;
	cout << "实部："; cin >> a;
	cout << "虚部："; cin >> b;
	cout << endl << "请输入第二个虚数的实部和虚部" << endl;
	cout << "实部："; cin >> c;
	cout << "虚部："; cin >> d;


	cout << endl << "两个复数显示如下" << endl;

	Complex c1(a, b), c2(c, d), c3;	//定义复数类的对象

	cout << "c1 = "; c1.display();


	cout << "c2 = "; c2.display();

	c3 = c1 - c2;	//使用重载运算符完成复数减法
	cout << "c3 = c1 - c2 = "; c3.display();

	c3 = c1 + c2;	//使用重载运算符完成复数加法
	cout << "c3 = c1 + c2 = "; c3.display();

	c3 = c1 * c2;	//使用重载运算符完成复数乘法
	cout << "c3 = c1 * c2 = "; c3.display();
	cout << endl;

	Cat cat;
	Dog dog;
	cat.shout();
	cat.run();
	dog.shout();
	dog.run();

	return 0;
}