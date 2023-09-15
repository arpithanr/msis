#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
	for(int i=0; i<3; i++)
	{
		pid_t pid = fork();
		if(pid<0)
		{
			printf("process is not created\n");
		}else if(pid == 0)
		{
			execlp("ls","ls",NULL);
		}else if(pid == 1)
		{
			execlp("date","date",NULL);
		}else if(pid == 2)
		{
			execlp("pwd","pwd", NULL);
		}
		else
		{
			wait(NULL);
		}
	}
}