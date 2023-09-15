#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>

int main()
{
	int id;
	id = fork();
	if(id < 0)
	{
		printf("Child creation failed\n");
		exit(-1);
	}
	else if(id == 0)
	{
		printf("List of ls commands:\n");
		system("ls");
	}
	else
	{
		wait(NULL);
		printf("Parent: child process completed\n");
	}
}