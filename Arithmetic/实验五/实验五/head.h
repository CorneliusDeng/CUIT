#pragma once
#include <stdio.h>

int numbertower[100][100];//�洢����ԭʼ����
int temp[100][100];//�洢��̬�滮�����е�����
int nc;//��������

int max(int a, int b);//����a��b��ֵ�ϴ��һ��

int NumberTower();//��̬�滮����

void print_result();//���ݴ�ӡ������ѡ��·��

int KnapSack(int n, int w[], int v[], int x[], int C);//��̬�滮0/1�������⣬����������������ֵ