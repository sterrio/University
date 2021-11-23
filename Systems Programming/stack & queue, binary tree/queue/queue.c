// Stephen Terrio
// Queue c file

// Packages
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "queue.h"
#include <stdbool.h>
#include "linked_list.h"

// Init the queue
Queue* queue_initialize(int dataSize,char* dataType) {
    Queue* queue = (Queue*) malloc(sizeof(Queue*));
    queue->list = llist_initialize(dataSize, dataType);
}
// Adding the current element to the end of the queue
bool queue_enqueue(Queue* queue, void* obj) {
    if(queue != NULL && obj != NULL){
        return llist_add_last(queue->list, obj);
    }
}
// Removing & returning the first element of the queue
void* queue_dequeue(Queue* queue) {
    if(queue != NULL){
        return llist_remove(queue->list, 0);
    }
}
// Using llist get to get the first element in the queue and return it
void* queue_peek(Queue* queue) {
    if(queue != NULL && llist_get(queue->list, 0) != NULL){
        return llist_get(queue->list, 0);
    }
}
// Getting the size of the queue using the list size property
int queue_size(Queue* queue) {
    if (queue != NULL) {
        return queue->list->size;
    }
}
// Finding it element is contained in the queue, return true if yes, false if no
bool queue_contains(Queue* queue, void* obj) {
    if(queue != NULL){
        if (llist_index_of(queue->list, obj) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
// deallocating and freeing all elements in queue
bool queue_destroy(Queue* queue) {
    llist_destroy(queue->list);
    free(queue);
    return true;
}
