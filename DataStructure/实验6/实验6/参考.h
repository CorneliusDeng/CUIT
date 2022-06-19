#pragma once

#define HASH_MAX_SIZE 100000
#define OK 111
#define ERROR -111
#define EMPTY NULL

typedef char* KeyType;

typedef struct {
	KeyType key;
	int value;
}HashTable[HASH_MAX_SIZE];

int SearchHashReference(HashTable HT, KeyType key);
int InitHashReference(HashTable HT);
int HashReference(KeyType key);
int InsertHashReference(HashTable HT, KeyType key);
int HashDeleteReference(HashTable HT, KeyType key);
void PrintHashTableReference(HashTable HT);
