#include "head.h"

int main() 
{	//������
	int a, b, c, d;

	cout << "�������һ��������ʵ�����鲿" << endl;
	cout << "ʵ����"; cin >> a;
	cout << "�鲿��"; cin >> b;
	cout << endl << "������ڶ���������ʵ�����鲿" << endl;
	cout << "ʵ����"; cin >> c;
	cout << "�鲿��"; cin >> d;


	cout << endl << "����������ʾ����" << endl;

	Complex c1(a, b), c2(c, d), c3;	//���帴����Ķ���

	cout << "c1 = "; c1.display();


	cout << "c2 = "; c2.display();

	c3 = c1 - c2;	//ʹ�������������ɸ�������
	cout << "c3 = c1 - c2 = "; c3.display();

	c3 = c1 + c2;	//ʹ�������������ɸ����ӷ�
	cout << "c3 = c1 + c2 = "; c3.display();

	c3 = c1 * c2;	//ʹ�������������ɸ����˷�
	cout << "c3 = c1 * c2 = "; c3.display();
	cout << endl;

	Cat cat;
	Dog dog;
	cat.shout();
	cat.run();
	dog.shout();
	dog.run();

	return 0;
}