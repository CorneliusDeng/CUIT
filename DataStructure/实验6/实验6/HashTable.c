#include "head.h"

int Hash(int data) 
{//�����ϣ��ַ�����ó���������
	return data % HashSize;
}

void InitialHash(HashTable *ht)
{//��ʼ����ϣ��
	int m = HashSize;

	ht->elem = (int*)malloc(sizeof(int) * m); //��̬��ֵ�洢�ռ�
	ht->length = m;//��ϣ���е�Ԫ�ظ���

	if (ht->elem == NULL) exit(0);

	for (int i = 0; i < m; i++)
	{
		ht->elem[i] = NullKey;//�Թ�ϣ�����������г�ʼ��
	}
}

int SearchHash(HashTable* ht, int data)
{//�ڹ�ϣ���в��ҹؼ���
	int hashaddress = Hash(data);

	while (ht->elem[hashaddress] != data)
	{
		hashaddress = (++hashaddress) % HashSize;

		if (ht->elem[hashaddress] == NullKey || hashaddress == Hash(data))
		{
			return ERROR;//����ʧ��

			/*ht->elem[hashaddress] == NullKey��������Ԫ�ص�λ�ô�������������
			��ʱ�����������ҵķ�Χ�Ѿ�������������ķ�Χ ����ʧ��

			hashaddress == Hash(data)˵������Ԫ��λ�ô���������
			�����Ѿ������ص���ϣ���������λ�ã�˵��Ҫ��ѯ������û���ҵ�����ѯʧ��*/
		}
	}
	return hashaddress;//�������ݵ�����λ��
}

void InsertHash(HashTable *ht, int data)
{//���ϣ���в���ؼ���
	int hashaddress;//��¼Ԫ�ز����λ��
	hashaddress = Hash(data);

	while (ht->elem[hashaddress] != NullKey)
	{
		hashaddress = (++hashaddress) % HashSize;
	}
	ht->elem[hashaddress] = data;//��������
}

int DeleteHsh(HashTable *ht, int data)
{//ɾ����ϣ���е�ĳһ�ؼ���
	int post = SearchHash(ht, data);

	if (post != ERROR)
	{
		ht->elem[post] = NullKey;
		return OK;//ɾ���ɹ�
	}
	else return ERROR;//ɾ��ʧ��
}

void PrintHash(HashTable* ht)
{//��ӡ�����ϣ��
	for (int i = 0; i < ht->length; i++)
	{
		if (ht->elem[i] != NullKey)
		{
			printf("%d\t", ht->elem[i]);
		}
		
	}
}