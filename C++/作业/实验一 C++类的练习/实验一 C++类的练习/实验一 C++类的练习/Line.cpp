#include "head.h"

//�����Ĺ��캯������ֵʱ�����θ��ƹ��죬�б��ʼ�����θ��ƹ���
Line::Line(Point xp1, Point xp2) : p1(xp1), p2(xp2) 
{
	//cout << "Calling constructor of Line" << endl;
	double x = ((double)p1.getX() - p2.getX());
	double y = ((double)p1.getY() - p2.getY());
	len = sqrt(x * x + y * y);
}

Line::Line(Line& l) : p1(l.p1), p2(l.p2) 
{//�����ĸ��ƹ��캯��
	//cout << "Calling the copy constructor of Line" << endl;
	len = l.len;
}