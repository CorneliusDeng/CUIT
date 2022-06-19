#include "Point.h"
#include "RectanglePublic.h"
#include "RectanglePrivate.h"
#include "RectangleProtected.h"
#include "AB.h"
#include "virtue.h"

int main() 
{
	RectanglePublic rectpublic;	//����Rectangle��Ķ���
	//���þ��ε�����
	rectpublic.initRectangle(2, 3, 20, 10);
	rectpublic.move(3, 2);	//�ƶ�����λ��
	cout << "��Test public class��" << endl;
	cout << "The data of rect(x,y,w,h): " << endl;
	//������ε���������
	cout << rectpublic.getX() << ", "<< rectpublic.getY() << ", "
		<< rectpublic.getW() << ", "<< rectpublic.getH() << endl;
	cout << endl;

	RectanglePrivate rectprivate;	//����Rectangle��Ķ���
	//���þ��ε�����
	rectprivate.initRectangle(2, 3, 20, 10);
	rectprivate.move(3, 2);	//�ƶ�����λ��
	cout << "��Test Private class��" << endl;
	cout << "The data of rect(x,y,w,h): " << endl;
	//������ε���������
	cout << rectprivate.getX() << ", " << rectprivate.getY() << ", " << rectprivate.getW() 
		<< ", " << rectprivate.getH() << endl;
	cout << endl;

	RectangleProtected rectprotected;	//����Rectangle��Ķ���
	//���þ��ε�����
	rectprotected.initRectangle(2, 3, 20, 10);
	rectprotected.move(3, 2);	//�ƶ�����λ��
	cout << "��Test Protected class��" << endl;
	cout << "The data of rect(x,y,w,h): " << endl;
	//������ε���������
	cout << rectprotected.getX() << ", " << rectprotected.getY() << ", " << rectprotected.getW()
		<< ", " << rectprotected.getH() << endl;
	cout << endl;

	C c;//����C�����
	c.setC(1, 2, 3);
	c.showA();
	c.showC();
	cout << endl;

	Derived d;	  //����Derived�����d
	d.var0 = 2;  //ֱ�ӷ������������ݳ�Ա
	d.fun0();	  //ֱ�ӷ��������ĺ�����Ա
	d.fun();

	return 0;
}