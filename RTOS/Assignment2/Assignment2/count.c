#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	FILE *fp1;
	int ch, count = 0;

	fp1 = fopen("file1.txt","r");
	if(fp1 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}

	while( (ch = getc(fp1)) != EOF)
		count++;

	printf("Count of characters: %d /n", count);
	fclose(fp1);
	return 0;

}