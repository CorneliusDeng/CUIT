#include "head.h"

Complex Complex::operator + (const Complex& c2) const 
{	//�������������ʵ��
	return Complex(real + c2.real, imag + c2.imag); //����һ����ʱ����������Ϊ����ֵ
}

Complex Complex::operator * (const Complex& c2) const 
{	//�������������ʵ��
	return Complex(real * c2.real - imag * c2.imag, imag * c2.real + real * c2.imag); //����һ����ʱ����������Ϊ����ֵ
}

Complex Complex::operator - (const Complex& c2) const
{	//�������������ʵ��
	return Complex(real - c2.real, imag - c2.imag); //����һ����ʱ����������Ϊ����ֵ
}
void Complex::display() const 
{
	cout << "(" << real << ", " << imag << ")" << endl;
}