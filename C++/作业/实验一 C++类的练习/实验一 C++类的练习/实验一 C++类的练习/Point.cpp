#include "head.h"

//��Ա������ʵ��
Point::Point(const Point& p) 
{
	x = p.x;
	y = p.y;
}

float dist(Point& a, Point& b) 
{//��Ԫ����
	double x = (double)a.x - b.x;
	double y = (double)a.y - b.y;
	return static_cast<float>(sqrt(x * x + y * y));
}


//�β�ΪPoint�����ĺ���
void fun1(Point p) 
{
	cout << p.getX() << endl;
}

//����ֵΪPoint�����ĺ���
Point fun2() 
{
	Point a(1, 2);
	return a;
}