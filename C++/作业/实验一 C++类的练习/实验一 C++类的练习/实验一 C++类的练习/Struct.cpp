#include <iostream>
#include <cmath>
using namespace std;

typedef struct
{
	double x, y;
}Point;

typedef struct 
{
	Point a, b;
}Line;

Point getPoint(double a, double b)
{//获取一个点的数据
	Point m;
	m.x = a;
	m.y = b;
	return m;
}

Line getLine(Point a, Point b)
{//获取一条线
	Line m;
	m.a = a;
	m.b = b;
	return m;
}

double getLength(Line n)
{
	double x = n.a.x - n.b.x;
	double y = n.a.y - n.b.y;
	double length = sqrt(x * x + y * y);
	return length;
}

void main()
{
	cout << "**********Using the method of struct**********" << endl << endl;
	Point e, f;
	Line g;
	double length;
	
	e = getPoint(3, 4);
	f = getPoint(4, 3);
	g = getLine(e, f);
	length = getLength(g);

	cout << "The length of the line is:" << length << endl;
}