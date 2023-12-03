#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/shm.h>
#include <string.h>

int main() {

  // Create a shared memory segment of length 100 bytes
  int shmid = shmget((key_t)12345, 100, IPC_CREAT | IPC_EXCL | 0666);
  if (shmid < 0) {
    perror("shmget");
    exit(1);
  }

  // Attach the shared memory segment to the process
  void *shared_memory = shmat(shmid, NULL, 0);
  if (shared_memory == (void *)-1) {
    perror("shmat");
    exit(1);
  }

  // Write 'A' to 'Z' to the shared memory segment
  char *shm_ptr = (char *)shared_memory;
  for (char c = 'A'; c <= 'Z'; c++) {
    *shm_ptr++ = c;
  }

  // Access the segment area and display its contents to the screen (all 100 bytes)
  printf("Shared memory contents: %s\n", shared_memory);

  // Convert the case of the alphabets in the segment to lowercase
  for (char *c = (char *)shared_memory; c < (char *)shared_memory + 100; c++) {
    *c = tolower(*c);
  }

  // Access the same area and display the segment contents once again to the screen
  printf("Shared memory contents after converting case to lowercase: %s\n", shared_memory);

  // Detach the shared memory segment from the process
  shmdt(shared_memory);

  // Remove the shared memory segment
  shmctl(shmid, IPC_RMID, NULL);

  return 0;
}
