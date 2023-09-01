#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	FILE *fp1, *fp2, *fp3 ;
	int ch;

	fp1 = fopen("file3.txt","r");
	if(fp1 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}
	fp2 = fopen("file4.txt","r");

	if(fp2 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}
	fp3 = fopen("file5.txt","w");

	if(fp3 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}

	while( (ch = getc(fp1)) != EOF)
		putc(ch, fp3);

	fclose(fp1);
	fclose(fp2);
	fclose(fp3);

	fp2 = fopen("file4.txt", "r");
	fp3 = fopen("file5.txt", "a");
	if(fp3 == NULL)
	{
		printf("Cannot open the file");
		exit(-1);
	}

	while( (ch = getc(fp2)) != EOF)
		putc(ch, fp3);

	fclose(fp2);
	fclose(fp3);

	return 0;

}