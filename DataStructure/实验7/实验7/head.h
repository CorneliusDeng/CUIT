#pragma once
#include <stdio.h>

void BubbleSort(int array[], int n);//ð������

void HeapAdjust(int K[], int i, int n);//����һ�����б�ɴ󶥶ѵķǵݹ��㷨

void HeapSort(int K[], int n);//�������ɵ���������

void SelectSort(int array[], int n);//ѡ������

void StraightInsertionSort(int array[], int n);//ֱ�Ӳ������򣨼򵥲�������

void QuickSort(int a[], int low, int high);//��������

void swap(int* a, int* b);//��������

void Merge(int R[], int T[], int low, int mid, int high);//�������R[low...mid]��R[mid+1...high]�鲢Ϊ�����T[low...high]

void MergingSort(int R[], int T[], int low, int high);//R[low...high]�鲢��������T[low...high]��