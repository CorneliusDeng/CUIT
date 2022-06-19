static int K = 10;//定义静态外部变量
extern void fan();//声明外部函数
extern int P;

void seven_prog3()
{
	fan(6);
	K = 3;
	P = 5;
	fan(3);
}
