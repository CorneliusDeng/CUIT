#pragma once
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>

#define HashSize 8 //哈希除数
#define NullKey -1111 
#define OK 1
#define ERROR -1

typedef struct
{
	int* elem;//哈希表的数据域
	int length;//哈希表的数据元素个数
}HashTable;

int BinarySearch(int array[], int n, int key);//在n个数据大小的array数组中，折半查找值为key的元素，返回它的下标

void SelectSort(int array[], int n);//选择排序将数列编程递增的

int Hash(int data);//计算哈希地址，采用除留余数法

void InitialHash(HashTable* ht);//初始化哈希表

int SearchHash(HashTable* ht, int data);//在哈希表中查找关键字

void InsertHash(HashTable* ht, int data);//向哈希表中插入关键字

int DeleteHsh(HashTable* ht, int data);//删除哈希表中的某一关键字

void PrintHash(HashTable* ht);//打印输出哈希表