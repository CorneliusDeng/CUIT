#include "head.h"

Complex Complex::operator + (const Complex& c2) const 
{	//重载运算符函数实现
	return Complex(real + c2.real, imag + c2.imag); //创建一个临时无名对象作为返回值
}

Complex Complex::operator * (const Complex& c2) const 
{	//重载运算符函数实现
	return Complex(real * c2.real - imag * c2.imag, imag * c2.real + real * c2.imag); //创建一个临时无名对象作为返回值
}

Complex Complex::operator - (const Complex& c2) const
{	//重载运算符函数实现
	return Complex(real - c2.real, imag - c2.imag); //创建一个临时无名对象作为返回值
}
void Complex::display() const 
{
	cout << "(" << real << ", " << imag << ")" << endl;
}