#include "Tree.h"

/*void Select(HuffmanTree HT, int n, int *s1, int *s2)
{//��Ҷ�ӽ��������С����������

	int min = 999, secmin = 999;//�����Сֵ�ʹ�Сֵ
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
{//�����������
	int s1 = 0, s2 = 0, i;
	if (n <= 1) return;

	//������������Ҫ���ٵĽ���СΪ2n-1
	int m = 2 * n - 1;

	HT = (HuffmanTree)malloc(sizeof(HTNode) * (m + 1));//0�ŵ�Ԫδ�ã�������Ҫ��̬����m+1����Ԫ��HT[m]��ʾ�����

	if (HT == NULL) return 0;
	//��ʼ��n��Ҷ�ӽ�㣬�����±궼��ʼ��Ϊ0
	for (int i = 1; i <= m; i++) 
	{
		HT[i].parent = 0;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
	}
	printf("������%d����Ԫ��Ҷ�ӽ���Ȩֵ:\n", n);
	for (i = 1; i <= n; i++) 
	{
		printf("w[%d]=", i);
		int temp = scanf("%d", &HT[i].weight);
		putchar('\n');
	}*/

	/*��ʼ���������������濪ʼ������������

	//��n-1����Ҷ�ӽ��ĳ�ʼ��
	for (int i = n + 1; i <= m; i++) 
	{
		Select(HT, i - 1, &s1, &s2);//��HT��ѡ������˫����Ϊ0��Ȩֵ��С�Ľ�㣬�������ǵ���Ÿ���s1��s2

		HT[s1].parent = i;//�õ��½��i����ɭ����ɾ��s1��s2����s1��s2��˫������0��Ϊi
		HT[s2].parent = i;

		HT[i].lchild = s1;//s1��s2�ֱ���Ϊi�����Һ���
		HT[i].rchild = s2;

		HT[i].weight = HT[s1].weight + HT[s2].weight;//i��ȨֵΪ���Һ���Ȩֵ֮��
	}

}

void CreatHuffmanCode(HuffmanTree HT, HuffmanCode HC, int n)
{//��Ҷ�ӵ���������ÿ���ַ��Ĺ��������룬�洢�ڱ����HC��
	char* cd;
	int start, c, f;

	HC = malloc(sizeof(char*) * (n + 1)); //����洢n���ַ�����ı����ռ�
	cd = malloc(sizeof(char) * n);//������ʱ���ÿ���ַ�����Ķ�̬����ռ�
	cd[n-1] = '\0';	//���������

	//��Ҷ�ӽ��Ĺ���������
	for (int i = 1; i <= n; i++) 
	{
		start = n - 1;//start��ʼʱָ����󣬼������������λ��
		c = i;
		f = HT[i].parent;//fָ����c��˫�׽��

		//����������Ϊ0��������Ϊ1
		//���������1�Žڵ㿪ʼ����������(������)��Ȼ�����2�Žڵ㣬3��......
		while (f != 0) //��Ҷ�ӽ�㿪ʼ���ϻ��ݣ�ֱ�������
		{
			start--;//����һ��start��ǰָһ��λ��

			if (HT[f].lchild == c) //���c��f�����ӣ������ɴ���0���Һ�����Ϊ1
			{
				cd[start] = '0';
			}
			else 
			{
				cd[start] = '1';
			}
			c = f;
			f = HT[f].parent;//�������ϻ���
		}
		HC[i] = malloc(sizeof(char) * (n-start));//Ϊ��i���ַ��������ռ�
		strcpy(HC[i], &cd[start]);//����õı������ʱ�ռ�cd���Ƶ�HC�ĵ�ǰ����

	}
	free(cd);//�ͷ���ʱ�ռ�
}

void Huffmantrans(HuffmanTree HT, int n, char* ch)
{//������������
	int m = 2 * n - 1;
	int i, j = 0;

	while (ch[j] != '\0') 
	{//�ӹ�������������ʼ������

		i = m;
		while (HT[i].lchild != 0 && HT[i].rchild != 0) 
		{//��Ϊ0����������ң��������Ҷ���

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
{// ����ַ�����ÿ���ַ���Ƶ����������һ�����ַ�:Ƶ������ֵ�Լ�����
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
		// ������ַ������ظ����־ͽ�����ִ�����¼����ֵ����
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
{// ͨ���ַ�������Huffman���������ؽ�����
	int n;
	HuffmanKVSet charSet = getHuffmanCharSet(array, &n);         // ��ÿ���ַ��洢���ԣ��ַ�:Ƶ�����ļ�ֵ���У�ͬʱ�����ַ���

	HuffmanTree HT = (HuffmanTree)malloc(sizeof(HTNode) * 2 * n);
	if (HT == NULL) return NULL;

	*size = n;
	int i, j;
	// ��ʼ�� 2*n-1����㣬����1~n�����洢�ַ���n+1~2*n-1�洢��֧�����
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

	// ѭ�����������н����Ѱ��Ȩֵ��С���������
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
		//��Ȩֵ��С���������ϲ���һ�������������ΪȨֵ֮��
		HT[pos1].parent = n + i;
		HT[pos2].parent = n + i;
		HT[n + i].weight = HT[pos1].weight + HT[pos2].weight;
		HT[n + i].lchild = pos1;
		HT[n + i].rchild = pos2;
	}

	return HT;
}


HuffmanCode CreateHuffmanCode(HuffmanTree HT, int n)
{//ͨ�����������ó�ÿ���ַ��ı���
	HuffmanCode HC = (char**)malloc(sizeof(char*) * (n + 1));
	// temp����ʱ�洢���������ַ���
	char* temp = (char*)malloc(sizeof(char) * n);

	if (HC == NULL || temp == NULL) return NULL;

	int i, j;
	// ���µ��ϱ���ÿһ���ַ��������и���㣬������ڱ����Ľ�������Ӿͽ�����0��������Һ��Ӿͱ���1
	// ÿ��ͨ���ҵ���ǰ���ĸ�������жϵ�ǰ��������ӻ����Һ���
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
		// �����������Ƶ�HuffmanCode�������, ��Ϊ�����Ǵ������ϱ����ģ�������Ҫ�����������
		strcpy(HC[i], temp);
	}
	free(temp);
	return HC;
}

char* EnCode(char* message)
{//���ַ�������ɹ��������루�������к����ķ�װ��
	char* str = (char*)malloc(sizeof(char) * MAX_SIZE);
	if (str == NULL) return NULL;

	// ���ɹ��������͹��������뼯������ַ�������
	int n;
	HuffmanTree HT = CreateHuffmanTree(message, &n);
	if (HT == NULL) return NULL;
	HuffmanCode HC = CreateHuffmanCode(HT, n);
	if (HC == NULL) return NULL;
	int start = 0;

	// ����ÿ���ַ���ͨ��ƥ����뼯����������д�����
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
