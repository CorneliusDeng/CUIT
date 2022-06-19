#include "²Î¿¼.h"
#include <stdio.h>
#include <string.h>

int InitHashReference(HashTable HT)
{
	if (HT == NULL) return ERROR;

	for (int i = 0; i < HASH_MAX_SIZE; i++)
	{
		HT[i].key = EMPTY;
		HT[i].value = -1;
	}
	return OK;
}

int HashReference(KeyType key)
{
	int size = strlen(key);
	int hashVal = 0;
	for (int i = 0; i < size; i++)
	{
		hashVal += key[i];
	}
	return hashVal;
}

int InsertHashReference(HashTable HT, KeyType key)
{
	int hashVal = Hash(key);
	int address = hashVal;
	if (HT == NULL)
		return ERROR;
	if (HT[address].key == EMPTY)
	{
		HT[address].key = key;
		HT[address].value = address;
	}
	else
	{
		int d = 1;
		while (HT[address].key != EMPTY && address < HASH_MAX_SIZE)
		{
			address = (address + d * d);
			d++;
		}
		if (address < HASH_MAX_SIZE) {
			HT[address].value = address;
			HT[address].key = key;
		}
	}
	return address;
}

int HashDeleteReference(HashTable HT, KeyType key)
{
	int address = Hash(key);
	int i = 1;
	if (HT == NULL) return ERROR;

	while (HT[address].value != address && address < HASH_MAX_SIZE)
	{
		address = address + i * i;
	}
	if (address >= HASH_MAX_SIZE) return ERROR;
	HT[address].key = EMPTY;
	HT[address].value = -1;
	return OK;
}

int SearchHashReference(HashTable HT, KeyType key)
{
	int val = Hash(key);
	if (HT[val].value == val)
	{
		printf("Found ! ! !\n");
		return val;
	}
	else
	{
		int i = 1;
		while (HT[val].value != val)
		{
			val = val + i * i;
			if (val >= HASH_MAX_SIZE)
				return -1;
			i++;
		}
		return val;
	}
	return -1;
}

void PrintHashTableReference(HashTable HT)
{
	int i;

	printf("|%-10s | %-10s|\n", "Key", "HashValue");
	printf("|-----------|-----------|\n");
	for (i = 0; i < HASH_MAX_SIZE; i++)
	{
		if (HT[i].key != EMPTY)
		{
			printf("|%-10s | %-10d|\n", HT[i].key, HT[i].value);
			printf("|-----------|-----------|\n");
		}
	}
}