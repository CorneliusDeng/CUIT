#pragma once
#include <iostream>
using namespace std;

class A 
{
	public:
		void setA(int);
		void showA() const;
	private:
		int a;
};

class B 
{
	public: 
		void setB(int);
		void showB() const;
	private:
		int b;
};

class C : public A, private B 
{
	public:
		void setC(int, int, int);
		void showC() const;
	private :
		int c;
};

void  A :: setA(int x) 
{
	a = x;
}

void A :: showA () const
{
	cout << " The data a is :" << a << endl;
}

void B :: setB(int x) 
{
	b = x;
}

void B :: showB() const
{
	cout << " The data b is :" << b << endl;
}

void C :: setC(int x, int y, int z) 
{
	//派生类成员直接访问基类的公有成员
	setA(x);
	setB(y);
	c = z;
}

void C :: showC() const
{
	cout << " The data c is :" << c << endl;

}

