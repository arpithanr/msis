#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
//#include <unistd.h>
#include <stdint.h>

//Mutex lock to protect the shared resource
pthread_mutex_t mutex;

//file pointer to the shared resource
FILE *file;

//function executed by the reader thread
void *reader_thread(void *arg)
{
    //Acquire the lock
    pthread_mutex_lock(&mutex);
    sleep(1);
    //Read the contents of the file
    char line[1024];

    while(fgets(line, sizeof(line), file) != NULL)
    {
        printf("%s",line);
    }

    //release the lock
    pthread_mutex_unlock(&mutex);

    return NULL;
}

void *writer_thread(void *arg)
{
    //acquire the lock
    pthread_mutex_lock(&mutex);

    //append the user provided message to the file n times
    for(int i=0; i<10; i++)
    {
        fprintf(file,"This is a message from the writer thread. \n");
    }
    //release the lock
    pthread_mutex_unlock(&mutex);
}

int main()
{
    //initialize the mutex lock
    pthread_mutex_init(&mutex, NULL);

    //open the shared file
    file = fopen("shared.txt","r+");

    //create two threads, one reader and one writer
    pthread_t reader_thread_id, writer_thread_id;

    pthread_create(&reader_thread_id, NULL, reader_thread, NULL);
    pthread_create(&writer_thread_id, NULL, writer_thread, NULL);

    //wait for the threads to finish executing
    pthread_join(reader_thread_id, NULL);
    pthread_join(writer_thread_id, NULL);

    //close the shared file
    fclose(file);

    //Destroy the mutex lock
    pthread_mutex_destroy(&mutex);

    return 0;
}
