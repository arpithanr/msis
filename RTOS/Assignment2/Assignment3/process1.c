#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
	int val;
	printf("Main, my ID is %d \n", getpid());
	printf("I'm the main thread");

	val = fork();
	if(val == -1)
	{
		printf("Enter the fork\n");
		exit(1);
	}
	else if(val == 0)
	{
		printf("I'm the child \n");
		execl("bin/ls", "ls-l", NULL);
		printf("%d\n", getpid());
	}
	else
	{
		sleep(2);
		printf("I'm the main, the parent\n");
		printf("%d\n", getpid());
	}
	return 0;
}