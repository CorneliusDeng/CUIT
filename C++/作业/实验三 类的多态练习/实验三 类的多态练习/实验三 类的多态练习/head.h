#pragma once
#include <iostream>;
using namespace std;

class Complex 
{	//�����ඨ��
public:	//�ⲿ�ӿ�
	Complex(double r = 0.0, double i = 0.0) : real(r), imag(i) { }//���캯���� �ȼ���real = r�� imag = i; 
	Complex operator + (const Complex& c2) const;	//�����+���س�Ա����
	Complex operator - (const Complex& c2) const;	//�����-���س�Ա����
	Complex operator * (const Complex& c2) const;	//�����*���س�Ա����
	void display() const;	//�������
private:	//˽�����ݳ�Ա
	double real;	//����ʵ��
	double imag;	//�����鲿
};

class Animal
{
public:
	virtual void shout() const = 0;//���麯������
	virtual void run() const = 0;//���麯������
};

class Cat : public Animal
{
public:
	void shout() const
	{
		cout << "è�У���~��~��~" << endl << endl;
	}

	void run() const
	{
		cout << "è������:[����]" << endl << endl;
	}
};

class Dog : public Animal
{
public:
	void shout() const
	{
		cout << "���У���~��~��~" << endl << endl;
	}

	void run() const
	{
		cout << "��������:[Ѹ��]" << endl << endl;
	}

};