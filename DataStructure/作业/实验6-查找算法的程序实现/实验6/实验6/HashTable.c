#include "head.h"

int Hash(int data) 
{//计算哈希地址，采用除留余数法
	return data % HashSize;
}

void InitialHash(HashTable *ht)
{//初始化哈希表
	int m = HashSize;

	ht->elem = (int*)malloc(sizeof(int) * m); //动态赋值存储空间
	ht->length = m;//哈希表中的元素个数

	if (ht->elem == NULL) exit(0);

	for (int i = 0; i < m; i++)
	{
		ht->elem[i] = NullKey;//对哈希表的数据域进行初始化
	}
}

int SearchHash(HashTable* ht, int data)
{//在哈希表中查找关键字
	int hashaddress = Hash(data);

	while (ht->elem[hashaddress] != data)
	{
		hashaddress = (++hashaddress) % HashSize;

		if (ht->elem[hashaddress] == NullKey || hashaddress == Hash(data))
		{
			return ERROR;//查找失败

			/*ht->elem[hashaddress] == NullKey表明查找元素的位置处于数据域两端
			此时条件表明查找的范围已经超出了数据域的范围 查找失败

			hashaddress == Hash(data)说明查找元素位置处于数据中
			表明已经结束回到哈希函数计算的位置，说明要查询的数据没有找到，查询失败*/
		}
	}
	return hashaddress;//返回数据的所在位置
}

void InsertHash(HashTable *ht, int data)
{//向哈希表中插入关键字
	int hashaddress;//记录元素插入的位置
	hashaddress = Hash(data);

	while (ht->elem[hashaddress] != NullKey)
	{
		hashaddress = (++hashaddress) % HashSize;
	}
	ht->elem[hashaddress] = data;//插入数据
}

int DeleteHsh(HashTable *ht, int data)
{//删除哈希表中的某一关键字
	int post = SearchHash(ht, data);

	if (post != ERROR)
	{
		ht->elem[post] = NullKey;
		return OK;//删除成功
	}
	else return ERROR;//删除失败
}

void PrintHash(HashTable* ht)
{//打印输出哈希表
	for (int i = 0; i < ht->length; i++)
	{
		if (ht->elem[i] != NullKey)
		{
			printf("%d\t", ht->elem[i]);
		}
		
	}
}