#pragma once
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void swap(int* a, int* b);//��������

void QuickSort(int a[], int low, int high);//��������

void Merge(int R[], int T[], int low, int mid, int high);//�������R[low...mid]��R[mid+1...high]�鲢Ϊ�����T[low...high]

void QuickSort(int a[], int low, int high);//R[low...high]�鲢��������T[low...high]��