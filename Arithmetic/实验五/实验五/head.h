#pragma once
#include <stdio.h>

int numbertower[100][100];//存储数塔原始数据
int temp[100][100];//存储动态规划过程中的数据
int nc;//数塔层数

int max(int a, int b);//返回a、b中值较大的一个

int NumberTower();//动态规划数塔

void print_result();//回溯打印数塔的选择路径

int KnapSack(int n, int w[], int v[], int x[], int C);//动态规划0/1背包问题，返回其容量内最大价值