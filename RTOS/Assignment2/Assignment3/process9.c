#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
	if(argc != 2)
	{
		fprintf(stderr, "Usage: %s <n> \n", argv[0]);
		return 1;
	}

	int n = atoi(argv[1]);

	pid_t pid = fork();
	if(pid < 0)
	{
		perror("fork");
	}else if(pid == 0)
	{
		int sum = 0;
		for(int i =1; i<=n; i++)
		{
			sum = sum + i;
		}
		printf("Child process: Sum of first %d natural numbers = %d \n", n, sum);
	}else{
		wait(NULL);
	}
	return 0;
}