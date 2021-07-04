// Stephen Terrio, B00755443
// Following Alex Brodskys Overview Session.

// Packages -
#include <stdlib.h>
#include <printf.h>
#include "nonce.h"
#include "siggen.h"
#include "pthread.h"
#include <assert.h>

// STRUCT - Runner function parameters
typedef struct {
    int num_threads;
    int id;
    unsigned int sig;
} runnerArgs;

// Global Variables -
unsigned int* foundNonce;
pthread_mutex_t lock;

// Defining Runner for use in nonce calculation
static void* *runner(void *args){
    runnerArgs *unpackedArgs = args;
    // instead of using a condition, break when we find a nonce
    for (int n = 0; ; n++) {
        unsigned int nonce = unpackedArgs->id + unpackedArgs->num_threads * n;
        printf("Thread %d checking nonce 0x%8.8x\n", unpackedArgs->id, nonce);
        if ((siggen_int(unpackedArgs->sig, nonce) & 0xff000000) == 0) {
            // Mutex Locking
            pthread_mutex_lock(&lock);
            // If there is no current nonce, or if the current nonce is less than one we've found
            if ( *foundNonce == 0 || *foundNonce > nonce) {
                *foundNonce = nonce;
            }
            pthread_mutex_unlock(&lock);
            break;
        }
        assert(nonce + 1 != 0);
    }
    free(unpackedArgs);
    return 0;
}
// Nonce function to be called in main.c
extern unsigned int get_nonce(unsigned int partial_sig, int num_threads){
  foundNonce = malloc(sizeof(unsigned int));
  *foundNonce = 0;
  // Array of thread ids (pthread_t)
  pthread_t ids[num_threads];

  // Initializing lock to be used in runner
  pthread_mutex_init(&lock, NULL);
  // Creating the specified amount of threads
  for (int i=0; i < num_threads; i++) {
      runnerArgs *args = malloc(sizeof *args);
      // Setting runner parameters
      args->num_threads = num_threads;
      args->id = i;
      args->sig = partial_sig;
      // Creating Threads
      pthread_create(&ids[i], NULL, (void *(*)(void *)) runner, args);
  }
    // Joining threads to ensure they all suspend while running
  for (int i=0; i < num_threads; i++) {
      pthread_join(ids[i], NULL);
  }
  return *foundNonce;
}
