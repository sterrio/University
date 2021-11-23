// Stephen Terrio, B00755443

// PACKAGES -
// Base taken from Assignement 2 PDF -
#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <semaphore.h>
#include <stdbool.h>

#define BUFFER_SIZE 5
typedef int buffer_item;

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
sem_t full = 0;
sem_t empty = BUFFER_SIZE;

// initialize buffer
buffer_item buffer[BUFFER_SIZE] = {-1, -1, -1, -1, -1};
int in = 0; // Next available free spot
int out = 0; // Earliest item
//create producer threads
//create consumer threads
// sleep & terminate
}

void *insert_item(int in, buffer_item item, buffer_item buffer[]){
  // inserting
  buffer[in] = item;
  in = (in + 1) % BUFFER_SIZE;
  return 0;
}
void *remove_item(int out, buffer_item buffer[]){
  // removing
  buffer[out] = -1;
  out = (out + 1) % BUFFER_SIZE;
  return 0;
}
void *producer(int in, buffer_item buffer[]) {
  buffer_item item;
  while (true) {
    // sleep for a random period of time: 0-4 seconds
    int r = rand() % 5;
    sleep(r);
    item = rand();
    printf("Producer inserted item %d into buffer[%d]", item, in);
    insert_item(in, item, buffer);
  }
}
void *consumer(int out, buffer_item buffer[]) {
  while (true) {
    // sleep for a random period of time: 0-4 seconds
    int r = rand() % 5;
    sleep(r);
    printf("Consumer removed item %d from buffer[%d]", buffer[out], in);
    remove_item(out, buffer);
  }
}
