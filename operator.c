#define START_INDEX 0
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int smallest_number(int *arr, int size)
{
	int i,j,small = arr[START_INDEX];
	for(i=0; i<size; i++)
	{
		if(small>arr[i])
			small=arr[i];
	}
	return small;
}

int scalling(int *arr,int size, int k)
{
	int i, j;
	for(i = 0; i<size; i++)
	{
		arr[i] =  arr[i] + k;
		printf("%d \t", arr[i]);
	}
	return 0;
}

void countOfAB(char *s, int *c1, int *c2)
{
	int i;
	for(i = 0; i<strlen(s); i++)
	{
		if(s[i] == 'a')
			(*c1)++;
		else if(s[i] == 'b')
			(*c2)++;
	}
	printf("%d \t %d \t", *c1, *c2);

}

void white_space(char *size)