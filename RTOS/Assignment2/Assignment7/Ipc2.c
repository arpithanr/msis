#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/mman.h>
#include <string.h>

#define SEGMENT_SIZE sizeof(char) * (10 + 26)

int main() {
  // Create a shared memory segment
  char *segment = mmap(NULL, SEGMENT_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);
  if (segment == MAP_FAILED) {
    perror("mmap");
    exit(1);
  }

  // Write characters 0 to 9 and a to z to the segment
  for (int i = 0; i < 10; i++) {
    segment[i] = '0' + i;
  }
  for (int i = 10; i < 10 + 26; i++) {
    segment[i] = 'a' + (i - 10);
  }

  // Fork a child process
  pid_t child_pid = fork();
  if (child_pid == 0) {
    // Child process: increment integers by 100 and convert characters to uppercase
    for (int i = 0; i < 10; i++) {
      segment[i] += 100;
    }
    for (int i = 10; i < 10 + 26; i++) {
      segment[i] = toupper(segment[i]);
    }
    exit(0);
  } else {
    // Parent process: wait for the child to finish
    wait(NULL);

    // Access the shared area and display its contents
    printf("Shared segment contents:\n");
    for (int i = 0; i < SEGMENT_SIZE; i++) {
      printf("%c", segment[i]);
    }
    printf("\n");

    // Unmap the shared memory segment
    munmap(segment, SEGMENT_SIZE);
  }

  return 0;
}
