#include "head.h"

//成员函数的实现
Point::Point(const Point& p) 
{
	x = p.x;
	y = p.y;
}

float dist(Point& a, Point& b) 
{//友元函数
	double x = (double)a.x - b.x;
	double y = (double)a.y - b.y;
	return static_cast<float>(sqrt(x * x + y * y));
}


//形参为Point类对象的函数
void fun1(Point p) 
{
	cout << p.getX() << endl;
}

//返回值为Point类对象的函数
Point fun2() 
{
	Point a(1, 2);
	return a;
}