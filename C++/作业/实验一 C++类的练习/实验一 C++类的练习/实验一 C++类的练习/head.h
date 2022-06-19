#pragma once
#include <iostream>
#include <cmath>
using namespace std;

class Point
{//Point 类的定义
public:
	Point(int xx = 0, int yy = 0) //构造函数，内联
	{
		x = xx; y = yy;
	}

	Point(const Point& p); //复制构造函数

	void setX(int xx)
	{
		x = xx;
	}

	void setY(int yy)
	{
		y = yy;
	}
	int getX() const //常函数（第5章）
	{
		return x;
	}
	int getY() const //常函数（第5章）
	{
		return y;
	}
	friend float dist(Point& a, Point& b);
private:
	int x, y; //私有数据
};

class Line 
{//Line类的定义
public:	//外部接口
	Line(Point xp1, Point xp2);
	Line(Line& l);

	double getLen() 
	{ 
		return len; 
	}

private:	//私有数据成员
	Point p1, p2;	//Point类的对象p1,p2
	double len;
};


void fun1(Point p);

Point fun2();