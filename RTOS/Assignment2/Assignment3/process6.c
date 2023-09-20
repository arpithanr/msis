#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
	int id;
	id = fork();

	if(id < 0)
	{
		printf("Process not created\n");
		exit(-1);
	}else if(id == 0)
	{
		execlp("ls","ls","-l",NULL);
		perror("exec");
		exit(1);
	}else{
		wait(NULL);
	}
	return 0;
}
