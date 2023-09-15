#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
	int val;
	val = fork();
	if(val < 0)
	{
		printf("Enter the fork\n");
		exit(1);
	}
	else if(val == 0)
	{
		sleep(8);
		printf("I'm the child \n");
		printf("%d\n", getpid());
	}
	else
	{
		printf("I'm the parent\n");
		printf("%d\n", getpid());
	}
	return 0;
}