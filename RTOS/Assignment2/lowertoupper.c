#include <stdio.h>
#include <stdlib.h>
#include <ctype.h> 

int main(int args, char *argv[])
{
	FILE *fp1, *fp2;
	int ch;
	fp1 = fopen("file1.txt", "r");
	if(fp1 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}
	fp2 = fopen("file6.txt","w");

	if(fp2 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}

	while( (ch = getc(fp1)) != EOF)
		putc(toupper(ch), fp2);

	fclose(fp1);
	fclose(fp2);
	return 0;
}