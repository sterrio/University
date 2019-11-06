/*
This program uses 4 threads to populate an integer
array of size INT_MAX with 1's.
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <limits.h>

#define THREADS 4

//define a struct to hold functio arguments.
typedef struct
 {
      int start;
      int stop;
      int *arr;
 } Args;


void *insertValues(void *inArgs)
{
     Args args = *((Args*)inArgs);

      while( args.start < args.stop )
      {
        //populate the range of arr
        //between start and stop with 1's.

        /*!!!!!!
        There are two lines of code missing here!!
        !!!!*/
      }

      return inArgs;
  }

  int main()
  {
     time_t time1 = time(NULL);
      // Create a memory space for holding INT_MAX integers.
      int *arr = (int*)(malloc(sizeof(int)*INT_MAX));

      printf("Array created.\n");

      // Create an array of pthreads.
      pthread_t threads[THREADS];

      // Create an array of Args.
      Args args[THREADS];

      // Set the initial starting point.
      int lastStop = 0;

      int i;


     // Initialize the argument values.
      for(i=0; i < THREADS; ++i)
      {
          args[i].start = lastStop;
          args[i].stop = args[i].start + INT_MAX/THREADS;
          args[i].arr = arr;
          lastStop = args[i].stop;
      }

      // Create all the threads.
      for(i=0; i < THREADS; ++i)
     {
         /*!!!!!!
         There is one line of code missing here!!
         !!!!*/
      }

      // Wait for all the threads to finish.
      for(i=0; i < THREADS; ++i)
     {
       /*!!!!!!
       There is one line of code missing here!!
       !!!!*/
      }

      time_t time2 = time(NULL);

      printf("Time taken: %f\n", difftime(time2, time1));

      return 0;
  }
