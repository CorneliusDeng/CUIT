#pragma once
#include <iostream>
#include <cmath>
using namespace std;

class Point
{//Point ��Ķ���
public:
	Point(int xx = 0, int yy = 0) //���캯��������
	{
		x = xx; y = yy;
	}

	Point(const Point& p); //���ƹ��캯��

	void setX(int xx)
	{
		x = xx;
	}

	void setY(int yy)
	{
		y = yy;
	}
	int getX() const //����������5�£�
	{
		return x;
	}
	int getY() const //����������5�£�
	{
		return y;
	}
	friend float dist(Point& a, Point& b);
private:
	int x, y; //˽������
};

class Line 
{//Line��Ķ���
public:	//�ⲿ�ӿ�
	Line(Point xp1, Point xp2);
	Line(Line& l);

	double getLen() 
	{ 
		return len; 
	}

private:	//˽�����ݳ�Ա
	Point p1, p2;	//Point��Ķ���p1,p2
	double len;
};


void fun1(Point p);

Point fun2();