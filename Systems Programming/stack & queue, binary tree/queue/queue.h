// Stephen Terrio
// Queue header
#ifndef QUEUE_H
#define QUEUE_H
// Need to include this lib to use bool instead of _BOOL datatypes
#include <stdbool.h>
#include "linked_list.h"

// defining structure - 
typedef struct _Queue {
    LinkedList* list;
} Queue;

// Forward declaring functions - 
Queue* queue_initialize(int,char*); // int for data type size, string representing name of data
bool queue_enqueue(Queue*, void*); // Pointer to a queue and a pointer to an element 
void* queue_dequeue(Queue*); // Pointer to a queue // remove and return front element
void* queue_peek(Queue*); // return a pointer to the element at front of queue
int queue_size(Queue*); // return an int representing number of elelemnts in queue
bool queue_contains(Queue*, void*); // true if element is in queue, false if not 
bool queue_destroy(Queue*); // true if deallocated succesfully, false if not

#endif

