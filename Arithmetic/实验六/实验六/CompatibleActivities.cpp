/**********************************活动兼容问题************************************/

#include <iostream>
using namespace std;
#define N 100

struct Activity
{
	int number;            //活动编号
	int begin;           //活动开始时间
	int end;            //活动结束时间
	bool flag;          //此活动是否被选择
	int roomnum;      //此活动在哪间教室举行
};


//对于活动集，按照结束时间递增排序,使用快速排序
void quicksort(Activity* a, int p, int r)
{
	if (p < r)
	{
		int i = p - 1, j = p;
		Activity aa = a[r];
		while (j < r)          
		{//这个while循环是在将数组划分为小于最后一个元素，大于最后一个元素和最后一个元素三部分。
			if (a[j].end <= aa.end)
			{
				i++;        
				//i总是指向第一个区域的最后一个元素，然后i++去占领新的位置。
				//j始终指向第二个区域的最后一个元素的下一个元素，也就是即将归类的新元素
				Activity t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			j++;
		}
		//以下三行的交换是为了把最后一个元素提到他应该有的位置
		Activity t = a[r];               
		a[r] = a[i + 1];
		a[i + 1] = t;
		quicksort(a, p, i);
		quicksort(a, i + 1, r);
	}
}


int select_room(Activity* a, int* time, int n)
{
	int i = 1, j = 1;
	//下面初始化数据，把第一个活动安排了，然后循环从第二个活动开始
	int sumroom = 1;        //已经占用的教室，计算然后返回最终值
	int sumact = 1;           //已经被选择的活动，初始化为1
	time[1] = a[0].end;      //初始化教室1的最后一个活动的结束时间为活动1的结束时间
	a[0].roomnum = 1;         //将第一个活动占用的教室初始化为教室1
	for (i = 1; i < n; i++)                   //遍历i个活动
	{
		for (j = 1; j <= sumroom; j++)
		{
			//遍历j个教室,把活动i放进哪个教室
			if (a[i].begin >= time[j] && (!a[i].flag))          
			{//活动i开始的时间比教室j最后一个活动的结束时间晚，且活动i没有被规划过。那么就应该吧活动i划入教室j     

				//进行一波更新
				a[i].roomnum = j;
				a[i].flag = true;
				time[j] = a[i].end;
				sumact++;
			}
		}
		
		if (sumact < n && i == n - 1)             
		{//已经把一间教室能加入的活动搞完了，活动i不能已有加入教室，那么它就自己新开一间教室
			i = 0;                              //控制重新 遍历的条件
			sumroom++;
		}
	}
	return sumroom;
}

int main()
{
	Activity a[N];          //定义一个结构体
	int time[N];            //time 用于记录某个教室里面末尾活动的结束时间，方便与下一个活动的开始时间比较
	int n, i = 0, j;                  //输入的活动个数
	int sum;
	int k = 0;
	cout << "输入活动个数：";
	cin >> n;
	cout << endl;
	for (i = 0; i < n; i++)
	{
		time[i + 1] = 0;
		a[i].number = i + 1;
		a[i].flag = false;
		a[i].roomnum = 0;
		cout << "请输入活动" << ++k << "的开始时间:";
		cin >> a[i].begin;
		cout << "请输入活动" << k << "的结束时间:";
		cin >> a[i].end;
		cout << endl;

	}
	quicksort(a, 0, n - 1);
	sum = select_room(a, time, n);
	cout << "所占教室总数目是：【" << sum << "】" << endl;
	for (i = 0; i < n; i++)
	{
		cout << "活动" << a[i].number << "在教室" << a[i].roomnum << "中" << endl;
	}
}

/*
6
1
5
1
4
2
6
8
9
9
10
3
6
*/