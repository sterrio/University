/*
This program uses a loop to populate an integer
array of size INT_MAX with 1's.
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <limits.h>


int main()
  {
    //measure when the function begins execution
    time_t time1 = time(NULL);

    // Create a memory space for holding INT_MAX integers.
     int *arr = (int*)(malloc(sizeof(int)*INT_MAX));

    printf("Array created.\n");

    //populate the array with 1's.

    /*
    !!!!!!!
    PUT YOUR CODE HERE!
    (hint: use a for loop)
    !!!!!
    */

   for (int i =0; i < INT_MAX; i++){
     arr[i] = 1;
   }

    printf("Array filled.\n");

    //measure when the function ends execution
     time_t time2 = time(NULL);

     //report how much time it took to run the function
     printf("Time taken: %f\n", difftime(time2, time1));

     return 0;
}
