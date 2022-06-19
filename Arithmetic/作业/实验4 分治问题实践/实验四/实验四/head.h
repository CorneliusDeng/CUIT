#pragma once
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void swap(int* a, int* b);//交换函数

void QuickSort(int a[], int low, int high);//快速排序

void Merge(int R[], int T[], int low, int mid, int high);//将有序地R[low...mid]和R[mid+1...high]归并为有序的T[low...high]

void QuickSort(int a[], int low, int high);//R[low...high]归并排序后放入T[low...high]中