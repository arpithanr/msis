#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SEGMENT_SIZE 2048

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <n>\n", argv[0]);
        exit(1);
    }

    int n = atoi(argv[1]);

    // Create shared memory segment
    int segment_id = shmget(IPC_PRIVATE, SEGMENT_SIZE, IPC_CREAT | IPC_EXCL | 0666);
    if (segment_id == -1) {
        perror("shmget");
        exit(1);
    }

    // Attach shared memory segment to parent process
    char *shared_memory = (char *)shmat(segment_id, NULL, 0);
    if (shared_memory == (char *)-1) {
        perror("shmat");
        exit(1);
    }

    // Write n strings to shared memory
    for (int i = 0; i < n; i++) {
        char string[100];
        printf("Enter string %d: ", i + 1);
        fgets(string, 100, stdin);

        strcpy(shared_memory + i * 100, string);
    }

    // Fork child process
    pid_t child_pid = fork();
    if (child_pid == -1) {
        perror("fork");
        exit(1);
    }

    // Child process code
    if (child_pid == 0) {
        // Capitalize first character of each string
        for (int i = 0; i < n; i++) {
            char string[100];
            strncpy(string, shared_memory + i * 100, 100);

            string[0] = toupper(string[0]);
            strcpy(shared_memory + i * 100, string);
        }

        exit(0);
    }

    // Parent process code
    waitpid(child_pid, NULL, 0);

    // Access shared memory and display contents
    printf("\nCapitalized strings:\n");
    for (int i = 0; i < n; i++) {
        char string[100];
        strncpy(string, shared_memory + i * 100, 100);

        printf("%s\n", string);
    }

    // Detach shared memory
    shmdt(shared_memory);

    // Remove shared memory segment
    shmctl(segment_id, IPC_RMID, NULL);

    return 0;
}
