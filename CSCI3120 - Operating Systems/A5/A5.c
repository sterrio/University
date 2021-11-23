// Stephen Terrio, B00755443
// Referencing Assignement 2 for pthread methods

// PACKAGES -
#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#include <stdbool.h>

// GLOBAL VAR -
#define BUFFER_SIZE 5
typedef int buffer_item;
pthread_mutex_t mutex;
pthread_mutex_t mutex2;
sem_t *full;
sem_t *empty;

// Struct to pass in Arguments to pthread_create
typedef struct params{
  int in;
  int out;
  int PthreadID;
  int CthreadID;
  buffer_item buffer[BUFFER_SIZE];
} parameters;

// METHODS -
void *insert_item(int in, buffer_item item, buffer_item buffer[]){
  buffer[in] = item;
  return 0;
}
void *remove_item(int out, buffer_item buffer[]){
  buffer[out] = -1;
  return 0;
}
void *producer(void *parameters) {
  struct params *data = parameters;
  int ID = data->PthreadID;
  pthread_mutex_unlock(&mutex2); //Ensuring ID is consistent using second mutex lock
  buffer_item item;
  while (true) {
    // sleep for a random period of time: 0-4 seconds
    int r = rand() % 5;
    sleep(r);
    // Job Start -
    sem_wait(empty);
    pthread_mutex_lock(&mutex);
    item = rand();
    printf("Producer %d inserted item %d into buffer[%d]\n", ID, item, data->in);
    insert_item(data->in, item, data->buffer);
    data->in = (data->in + 1) % BUFFER_SIZE;
    pthread_mutex_unlock(&mutex);
    sem_post(full);
  }
}
void *consumer(void *parameters) {
  struct params *data = parameters;
  int ID = data->CthreadID;
  pthread_mutex_unlock(&mutex2); //Ensuring ID is consistent using second mutex lock
  // Looping
  while (true) {
    int r = rand() % 5;
    sleep(r);
    // Job Start -
    sem_wait(full);
    // conditional check to ensure we do not remove -1;
    concheck:
    pthread_mutex_lock(&mutex);
    if(data->buffer[data->out] == -1){
      data->out = (data->out + 1) % BUFFER_SIZE;
      pthread_mutex_unlock(&mutex);
      goto concheck;
    }
    printf("Consumer %d removed item %d from buffer[%d]\n", ID, data->buffer[data->out], data->out);
    remove_item(data->out, data->buffer);
    data->out = (data->out + 1) % BUFFER_SIZE;
    pthread_mutex_unlock(&mutex);
    sem_post(empty);
  }
}
// MAIN -
int main(int argc, char *argv[]){
  // Getting command line args
  int mainSleep; // Sleep timer
  int producers; // Producer count
  int consumers; // Consumer count
  srand(time(NULL)); // Setting random seed

  /* Reading user input, refrencing back to my solution of A1 & A2 */
  char input[10];
  // getting input until new line & discarding that character
  scanf("%[^\n]%*c", input);
  // Splitting input via spaces
  char *split = strtok(input, " ");
  // 3 tokens at most, 1 buffer token
  char *arrayofchars[4];
  int counter = 0;
  // looping till there can be no more splits
  while(split != NULL){
      arrayofchars[counter] = split;
      split = strtok(NULL, " ");
      counter = counter + 1;
    }
  // Variables now hold input information
  mainSleep = atoi(arrayofchars[0]);
  producers = atoi(arrayofchars[1]);
  consumers = atoi(arrayofchars[2]);

  // initialize sempahores and mutex lock
  full = sem_open("full",O_CREAT, 0666, 0);
  empty = sem_open("empty",O_CREAT, 0666, BUFFER_SIZE);
  pthread_mutex_init(&mutex, NULL);
  pthread_mutex_init(&mutex2, NULL);

  // initialize buffer
  buffer_item buffer[BUFFER_SIZE] = {-1, -1, -1, -1, -1};
  int in = 0; // Next available free spot
  int out = 0; // Earliest item

  // Defining Struct elements for pthread_create
  parameters *data = (parameters *) malloc(sizeof(parameters));
  data->in = in;
  data->out = out;
  data->PthreadID = 0;
  data->CthreadID = 0;
  memcpy(data->buffer, buffer, sizeof(buffer));
  sem_post(empty);

  //create producer threads
  pthread_t threadsP[producers];
  pthread_t threadsC[consumers];

  for(int i = 0; i < producers; i++){
    pthread_mutex_lock(&mutex2);
    data->PthreadID = i;
    pthread_create(&threadsP[i], NULL, producer, data);
  }
  for(int y = 0; y < consumers; y++){
    pthread_mutex_lock(&mutex2);
    data->CthreadID = y;
    pthread_create(&threadsC[y], NULL, consumer, data);
  }
pthread_mutex_unlock(&mutex2);
sleep(mainSleep);
}
