#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define ARR_SIZE 30000

int main(){
  
  // initiating clocks for row timer  
  clock_t rowStart, rowEnd;
  double cpu_time_used;
  
  // init array on heap
  char **pointer_to_array = (char **)malloc(ARR_SIZE * sizeof(char *)); 

  // init array[i] on heap
  for (int i = 0; i < ARR_SIZE; i++) {
    pointer_to_array[i] = (char *)malloc(ARR_SIZE * sizeof(char)); 
  }

  char a = 'a';

  // load array with value `a` via row                       
  rowStart = clock();
  for (int x = 0; x < ARR_SIZE; x++){
      for (int y = 0; y < ARR_SIZE; y++){
        pointer_to_array[x][y] = a;
      }
  }
  rowEnd = clock();
  cpu_time_used = ((double) (rowEnd - rowStart)) / CLOCKS_PER_SEC;
  
  // initiating timer for columns
  clock_t columnStart, columnEnd;
  double cpu_time_used2;

  // starting timer
  columnStart = clock();
  // loop via column
  for (int x = 0; x < ARR_SIZE; x++){
    for (int y = 0; y < ARR_SIZE; y++){
      pointer_to_array[y][x] = a;
    }
  }

  // stopping timer
  columnEnd = clock();
  cpu_time_used2 = ((double) (columnEnd - columnStart)) / CLOCKS_PER_SEC;

  // clean up memory
  for (int i = 0; i < ARR_SIZE; i++)
    free(pointer_to_array[i]);
  
  // print out results
  printf("Address of the array: %x\n\n\n", (unsigned int)pointer_to_array);
  printf("Time taken to traverse by row: %.2f seconds.\n", cpu_time_used);
  printf("Time taken to traverse by column: %.2f seconds.\n", cpu_time_used2);

  double timerResults = fabs(cpu_time_used - cpu_time_used2);
  printf("\nRow traversal is faster by: %.2f seconds.\n", timerResults);
  
  return 0;
}