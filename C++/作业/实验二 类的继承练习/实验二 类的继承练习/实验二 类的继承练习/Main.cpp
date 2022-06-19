#include "Point.h"
#include "RectanglePublic.h"
#include "RectanglePrivate.h"
#include "RectangleProtected.h"
#include "AB.h"
#include "virtue.h"

int main() 
{
	RectanglePublic rectpublic;	//定义Rectangle类的对象
	//设置矩形的数据
	rectpublic.initRectangle(2, 3, 20, 10);
	rectpublic.move(3, 2);	//移动矩形位置
	cout << "【Test public class】" << endl;
	cout << "The data of rect(x,y,w,h): " << endl;
	//输出矩形的特征参数
	cout << rectpublic.getX() << ", "<< rectpublic.getY() << ", "
		<< rectpublic.getW() << ", "<< rectpublic.getH() << endl;
	cout << endl;

	RectanglePrivate rectprivate;	//定义Rectangle类的对象
	//设置矩形的数据
	rectprivate.initRectangle(2, 3, 20, 10);
	rectprivate.move(3, 2);	//移动矩形位置
	cout << "【Test Private class】" << endl;
	cout << "The data of rect(x,y,w,h): " << endl;
	//输出矩形的特征参数
	cout << rectprivate.getX() << ", " << rectprivate.getY() << ", " << rectprivate.getW() 
		<< ", " << rectprivate.getH() << endl;
	cout << endl;

	RectangleProtected rectprotected;	//定义Rectangle类的对象
	//设置矩形的数据
	rectprotected.initRectangle(2, 3, 20, 10);
	rectprotected.move(3, 2);	//移动矩形位置
	cout << "【Test Protected class】" << endl;
	cout << "The data of rect(x,y,w,h): " << endl;
	//输出矩形的特征参数
	cout << rectprotected.getX() << ", " << rectprotected.getY() << ", " << rectprotected.getW()
		<< ", " << rectprotected.getH() << endl;
	cout << endl;

	C c;//定义C类对象
	c.setC(1, 2, 3);
	c.showA();
	c.showC();
	cout << endl;

	Derived d;	  //定义Derived类对象d
	d.var0 = 2;  //直接访问虚基类的数据成员
	d.fun0();	  //直接访问虚基类的函数成员
	d.fun();

	return 0;
}