#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main()
{
	//count number of alphabets and number of white spaces (blanks and tabs) in a given line of input
	char str[]="All is well		
				Fine is fine";
	int count_letter = 0;
	int count_space = 0;
	int i;

	for(i = 0; i<str.length(); i++)
	{
		char ch = str[i];
		if(ch >= 'a' && ch<= 'z' || ch >= 'A' && ch<= 'Z')
			count_letter++;
		else if(ch == ' ' || ch == '\n' || ch == '\t')
			count_space++;
	}
//	while(str[i]!='\0')
	
	printf("letters: %d\t space:%d\n",count_letter,count_space);
	return 0;

}