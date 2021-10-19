// Stephen Terrio B00755443, CSCI 3120 A3
// Sorting ALG reference: https://www.programiz.com/dsa/bubble-sort
// Merging ALG reference: https://en.wikipedia.org/wiki/Merge_algorithm

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure for passing data to threads
typedef struct params{
  int starting_index;
  int ending_index;
  int array[501];
} parameters;

// Structure for passing data to merger method, and returning result
typedef struct merge{
  struct params firstData;
  struct params secondData;
  int result[501];
} mergeHelper;

void *sorter(void *params); // thread that performs sorting
void *merger(void *params); // thread that performs merging

int main(int args, const char* argv[]){
  int arr[501];
  // reading from file to get input, if file is not found, error handle
  FILE *file = fopen("IntegerList.txt", "r");
  if(file == NULL){
    printf("No such file: IntegerList.txt could not be read");
    return 1;
  }
  // get the line of integers and store to current to div using strtok method from A1 -
  char current[2001];
  fgets(current, 2000, file);
  fclose(file);
  char *split = strtok(current, ",");
  int index = 0;
  while(split != NULL){
    arr[index] = atoi(split);
    index ++;
    split = strtok(NULL, ",");
  }
  // index now is arr size, and arr contains our int list -
  int midpoint;
  if(index % 2 == 0){
    midpoint = index/2;
  } else{ midpoint = (index + 1)/2;}

  // create the first sorting pthread
  parameters *data = (parameters *) malloc(sizeof(parameters));
  data->starting_index = 0;
  data->ending_index = midpoint -1;
  memcpy(data->array, arr, sizeof(arr));
  pthread_t tid;
  pthread_create(&tid, NULL, sorter, data);
  // create the second sorting pthread
  parameters *data2 = (parameters *) malloc(sizeof(parameters));
  data2->starting_index = midpoint;
  data2->ending_index = index -1;
  memcpy(data2->array, arr, sizeof(arr));
  pthread_t tid2;
  pthread_create(&tid2, NULL, sorter, data2);
  // now wait for the 2 sorting threads to finish
  pthread_join(tid, NULL);
  pthread_join(tid2, NULL);

  // create the merge thread and result array
  int result[501];
  mergeHelper *Sol = (mergeHelper *) malloc(sizeof(mergeHelper));
  Sol->firstData = *data;
  Sol->secondData = *data2;
  pthread_t tid3;
  pthread_create(&tid3, NULL, merger, Sol);
  // wait for merge thread to finish
  pthread_join(tid3, NULL);

  // Outputting to file -
  // Creating a file to write to as output.txt
  FILE *fileO = fopen("SortedIntegerList.txt", "w");
  if (fileO == NULL){
    // error handling incase output.txt cannot be made
    printf("There was an error trying to create output file");
    exit(1);
  }

  // output the sorted array to SortedIntegerList file
  for(int i = 0; i < index - 1; i++){
    fprintf(fileO, "%d,",Sol->result[i]);
  }
  fprintf(fileO, "%d",Sol->result[index-1]);

}
// SORTING LOGIC -
void *sorter(void *parameters){
  // sorting algorithm: bubbleSort (simplicity) - Reference: https://www.programiz.com/dsa/bubble-sort
  struct params *data = parameters;
  int size = data->ending_index;
  // initiating bubblesort algorithm using the above knowledge
  for(int loop = data->starting_index; loop < size; loop++){
    for(int swap = data->starting_index; swap < size; swap++){
      if(data->array[swap] > data->array[swap +1]){
        int event = data->array[swap];
        data->array[swap] = data->array[swap + 1];
        data->array[swap + 1] = event;
      }
    }
  }
  return 0;
}
// MERGING LOGIC -
void *merger(void *mergeHelper){
  //merge algorithm: Merge Sorted Lists - Reference: https://en.wikipedia.org/wiki/Merge_algorithm
  struct merge *Sol = mergeHelper;
  int headA = Sol->firstData.starting_index;
  int headB = Sol->secondData.starting_index;
  int step = 0; // used to traverse result array
  while(headA <= Sol->firstData.ending_index && headB <= Sol->secondData.ending_index){
    if(Sol->firstData.array[headA] <= Sol->secondData.array[headB]){
      Sol->result[step] = Sol->firstData.array[headA];
      headA++;
      step++;
    } else{
      Sol->result[step] = Sol->secondData.array[headB];
      headB++;
      step++;
    }
  }
  while(headA <= Sol->firstData.ending_index){
    Sol->result[step] = Sol->firstData.array[headA];
    headA++;
    step++;
  }
  while(headB <= Sol->secondData.ending_index){
    Sol->result[step] = Sol->secondData.array[headB];
    headB++;
    step++;
  }
  return 0;
}
