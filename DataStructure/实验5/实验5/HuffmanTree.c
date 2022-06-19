#include "Tree.h"

/*void Select(HuffmanTree HT, int n, int *s1, int *s2)
{//在叶子结点中找最小的两个数据

	int min = 999, secmin = 999;//存放最小值和次小值
	*s1 = 1;
	*s2 = 1;

	for (int i = 1; i <= n; i++) 
	{
		if (HT[i].weight < min && HT[i].parent == 0) 
		{
			min = HT[i].weight;
			*s1 = i;
		}
	}
	for (int i = 1; i <= n; i++) 
	{
		if ((HT[i].weight < secmin) && HT[i].parent == 0 && (i != s1)) 
		{
			secmin = HT[i].weight;
			*s2 = i;
		}
	}
}

void CreatHuffmanTree(HuffmanTree HT, int n)
{//构造哈夫曼树
	int s1 = 0, s2 = 0, i;
	if (n <= 1) return;

	//哈弗曼编码需要开辟的结点大小为2n-1
	int m = 2 * n - 1;

	HT = (HuffmanTree)malloc(sizeof(HTNode) * (m + 1));//0号单元未用，所以需要动态分配m+1个单元，HT[m]表示根结点

	if (HT == NULL) return 0;
	//初始化n个叶子结点，将其下标都初始化为0
	for (int i = 1; i <= m; i++) 
	{
		HT[i].parent = 0;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
	}
	printf("请输入%d个单元中叶子结点的权值:\n", n);
	for (i = 1; i <= n; i++) 
	{
		printf("w[%d]=", i);
		int temp = scanf("%d", &HT[i].weight);
		putchar('\n');
	}*/

	/*初始化工作结束，下面开始创建哈夫曼树

	//将n-1个非叶子结点的初始化
	for (int i = n + 1; i <= m; i++) 
	{
		Select(HT, i - 1, &s1, &s2);//在HT中选择两个双亲域为0且权值最小的结点，并将它们的序号赋给s1和s2

		HT[s1].parent = i;//得到新结点i，从森林中删除s1，s2，将s1和s2的双亲域由0改为i
		HT[s2].parent = i;

		HT[i].lchild = s1;//s1，s2分别作为i的左右孩子
		HT[i].rchild = s2;

		HT[i].weight = HT[s1].weight + HT[s2].weight;//i的权值为左右孩子权值之和
	}

}

void CreatHuffmanCode(HuffmanTree HT, HuffmanCode HC, int n)
{//从叶子到根逆向求每个字符的哈夫曼编码，存储在编码表HC中
	char* cd;
	int start, c, f;

	HC = malloc(sizeof(char*) * (n + 1)); //分配存储n个字符编码的编码表空间
	cd = malloc(sizeof(char) * n);//分配临时存放每个字符编码的动态数组空间
	cd[n-1] = '\0';	//编码结束符

	//求叶子结点的哈弗曼编码
	for (int i = 1; i <= n; i++) 
	{
		start = n - 1;//start开始时指向最后，即编码结束符的位置
		c = i;
		f = HT[i].parent;//f指向结点c的双亲结点

		//定义左子树为0，右子树为1
		//从最下面的1号节点开始往顶部编码(逆序存放)，然后编码2号节点，3号......
		while (f != 0) //从叶子结点开始向上回溯，直到根结点
		{
			start--;//回溯一次start向前指一个位置

			if (HT[f].lchild == c) //结点c是f的左孩子，则生成代码0，右孩子则为1
			{
				cd[start] = '0';
			}
			else 
			{
				cd[start] = '1';
			}
			c = f;
			f = HT[f].parent;//继续向上回溯
		}
		HC[i] = malloc(sizeof(char) * (n-start));//为第i个字符编码分配空间
		strcpy(HC[i], &cd[start]);//将求得的编码从临时空间cd复制到HC的当前行中

	}
	free(cd);//释放临时空间
}

void Huffmantrans(HuffmanTree HT, int n, char* ch)
{//哈夫曼树解码
	int m = 2 * n - 1;
	int i, j = 0;

	while (ch[j] != '\0') 
	{//从哈弗曼数顶部开始向下找

		i = m;
		while (HT[i].lchild != 0 && HT[i].rchild != 0) 
		{//若为0就向左儿子找，否则向右儿子

			if (ch[j] == '0') 
			{
				i = HT[i].lchild;
			}
			else 
			{
				i = HT[i].rchild;
			}
			j++;
		}
		printf("%d\t", NT[i-1]);
	}
	putchar('\n');
}*/

HuffmanKVSet getHuffmanCharSet(char* array, int* size)
{// 获得字符串中每个字符的频数并储存在一个（字符:频数）键值对集合中
	int n = strlen(array);
	int count = 0;
	int i, j;
	HuffmanKVSet kvSet = (HuffmanKVSet)malloc(sizeof(HuffmanKV) * n);
	if (kvSet == NULL) return NULL;

	for (i = 0; i < n; i++)
	{
		int first = 1;
		for (j = 0; j < i; j++) {
			if (array[j] == array[i])
			{
				first = 0;
				break;
			}
		}
		// 如果该字符不是重复出现就将其出现次数记录到键值对中
		if (first == 1)
		{
			int times = 0;
			for (int k = i; k < n; k++) {
				if (array[k] == array[i])
					times++;
			}
			kvSet[count].key = array[i];
			kvSet[count].value = times;
			count++;
		}
	}
	*size = count;
	return kvSet;
}



HuffmanTree CreateHuffmanTree(HuffType* array, int* size)
{// 通过字符串创建Huffman树，并返回结点个数
	int n;
	HuffmanKVSet charSet = getHuffmanCharSet(array, &n);         // 将每个字符存储在以（字符:频数）的键值对中，同时保存字符数

	HuffmanTree HT = (HuffmanTree)malloc(sizeof(HTNode) * 2 * n);
	if (HT == NULL) return NULL;

	*size = n;
	int i, j;
	// 初始化 2*n-1个结点，其中1~n用来存储字符，n+1~2*n-1存储分支父结点
	for (i = 1; i <= 2 * n - 1; i++)
	{
		HT[i].parent = 0;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
		if (i <= n)
		{
			HT[i].elem = charSet[i - 1].key;
			HT[i].weight = charSet[i - 1].value;
		}
		else {
			HT[i].elem = NULL_CHAR;
			HT[i].weight = 0;
		}
	}

	// 循环在现有所有结点中寻找权值最小的两个结点
	for (i = 1; i <= n - 1; i++)
	{
		int min1 = MAX_WEIGHT, min2 = MAX_WEIGHT;
		int pos1 = 0, pos2 = 0;
		for (j = 1; j <= n + i - 1; j++)
		{
			if (HT[j].weight < min1 && HT[j].parent == 0)
			{
				min2 = min1;
				pos2 = pos1;
				min1 = HT[j].weight;
				pos1 = j;
			}
			else if (HT[j].weight < min2 && HT[j].parent == 0)
			{
				min2 = HT[j].weight;
				pos2 = j;
			}
		}
		//将权值最小的两个结点合并成一棵子树，根结点为权值之和
		HT[pos1].parent = n + i;
		HT[pos2].parent = n + i;
		HT[n + i].weight = HT[pos1].weight + HT[pos2].weight;
		HT[n + i].lchild = pos1;
		HT[n + i].rchild = pos2;
	}

	return HT;
}


HuffmanCode CreateHuffmanCode(HuffmanTree HT, int n)
{//通过哈夫曼树得出每个字符的编码
	HuffmanCode HC = (char**)malloc(sizeof(char*) * (n + 1));
	// temp是临时存储编码结果的字符串
	char* temp = (char*)malloc(sizeof(char) * n);

	if (HC == NULL || temp == NULL) return NULL;

	int i, j;
	// 从下到上遍历每一个字符结点的所有根结点，如果正在遍历的结点是左孩子就将编码0，如果是右孩子就编码1
	// 每次通过找到当前结点的父结点来判断当前结点是左孩子还是右孩子
	for (i = 1; i <= n; i++)
	{
		int current = i;
		int parent = HT[i].parent;
		int nextPos = 0;
		while (parent != 0)
		{
			if (HT[parent].lchild == current)
				temp[nextPos++] = '0';
			else if (HT[parent].rchild == current)
				temp[nextPos++] = '1';
			current = parent;
			parent = HT[current].parent;
		}
		temp[nextPos] = '\0';
		strrev(temp);
		HC[i] = (char*)malloc(sizeof(char) * n);
		// 将编码结果复制到HuffmanCode结果集中, 因为这里是从下向上遍历的，所有需要将结果串逆序
		strcpy(HC[i], temp);
	}
	free(temp);
	return HC;
}

char* EnCode(char* message)
{//将字符串编码成哈夫曼编码（上面所有函数的封装）
	char* str = (char*)malloc(sizeof(char) * MAX_SIZE);
	if (str == NULL) return NULL;

	// 生成哈夫曼树和哈夫曼编码集来完成字符串编码
	int n;
	HuffmanTree HT = CreateHuffmanTree(message, &n);
	if (HT == NULL) return NULL;
	HuffmanCode HC = CreateHuffmanCode(HT, n);
	if (HC == NULL) return NULL;
	int start = 0;

	// 遍历每个字符，通过匹配编码集来向结果串中写入编码
	for (int i = 0; i < strlen(message); i++)
	{
		for (int j = 1; j <= n; j++)
		{
			if (HT[j].elem == message[i])
			{
				for (int k = 0; k < strlen(HC[j]); k++)
				{
					str[start++] = HC[j][k];
				}
			}
		}
	}
	str[start] = '\0';
	return str;
}
