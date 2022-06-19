#pragma once
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
#include <stdio.h>
#include <stdlib.h>

#define HashSize 8 //��ϣ����
#define NullKey -1111 
#define OK 1
#define ERROR -1

typedef struct
{
	int* elem;//��ϣ���������
	int length;//��ϣ�������Ԫ�ظ���
}HashTable;

int BinarySearch(int array[], int n, int key);//��n�����ݴ�С��array�����У��۰����ֵΪkey��Ԫ�أ����������±�

void SelectSort(int array[], int n);//ѡ���������б�̵�����

int Hash(int data);//�����ϣ��ַ�����ó���������

void InitialHash(HashTable* ht);//��ʼ����ϣ��

int SearchHash(HashTable* ht, int data);//�ڹ�ϣ���в��ҹؼ���

void InsertHash(HashTable* ht, int data);//���ϣ���в���ؼ���

int DeleteHsh(HashTable* ht, int data);//ɾ����ϣ���е�ĳһ�ؼ���

void PrintHash(HashTable* ht);//��ӡ�����ϣ��