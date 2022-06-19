#pragma once
#include <stdio.h>

void BubbleSort(int array[], int n);//冒泡排序

void HeapAdjust(int K[], int i, int n);//调整一个数列变成大顶堆的非递归算法

void HeapSort(int K[], int n);//堆排序变成递增的数列

void SelectSort(int array[], int n);//选择排序

void StraightInsertionSort(int array[], int n);//直接插入排序（简单插入排序）

void QuickSort(int a[], int low, int high);//快速排序

void swap(int* a, int* b);//交换数据

void Merge(int R[], int T[], int low, int mid, int high);//将有序地R[low...mid]和R[mid+1...high]归并为有序的T[low...high]

void MergingSort(int R[], int T[], int low, int high);//R[low...high]归并排序后放入T[low...high]中