#pragma once
#include <iostream>;
using namespace std;

class Complex 
{	//复数类定义
public:	//外部接口
	Complex(double r = 0.0, double i = 0.0) : real(r), imag(i) { }//构造函数， 等价于real = r， imag = i; 
	Complex operator + (const Complex& c2) const;	//运算符+重载成员函数
	Complex operator - (const Complex& c2) const;	//运算符-重载成员函数
	Complex operator * (const Complex& c2) const;	//运算符*重载成员函数
	void display() const;	//输出复数
private:	//私有数据成员
	double real;	//复数实部
	double imag;	//复数虚部
};

class Animal
{
public:
	virtual void shout() const = 0;//纯虚函数：叫
	virtual void run() const = 0;//纯虚函数：跑
};

class Cat : public Animal
{
public:
	void shout() const
	{
		cout << "猫叫：喵~喵~喵~" << endl << endl;
	}

	void run() const
	{
		cout << "猫跑起来:[敏捷]" << endl << endl;
	}
};

class Dog : public Animal
{
public:
	void shout() const
	{
		cout << "狗叫：汪~汪~汪~" << endl << endl;
	}

	void run() const
	{
		cout << "狗跑起来:[迅速]" << endl << endl;
	}

};