// Stephen Terrio, B00755443
// Header file for Heap 
#ifndef __HEAP_H
#define __HEAP_H
#include <stdbool.h>
#include "array_list.h"

// Defining Struct - 
typedef struct _Heap {
    ArrayList* list;
    int (*compare)(void*,void*);
	void (*print)(void*);	
} Heap;

// Forward Declaring Functions - 
Heap* heap_initialize(int,char*,int(*)(void*,void*),void(*)(void*));
bool heap_insert(Heap*,void*);
void* heap_remove(Heap*);
void* heap_peek(Heap*);
int heap_size(Heap*);
bool heap_contains(Heap*, void*);
bool _heapify(Heap*,int);
bool _heapify_up(Heap*,int);

// Helper functions -
bool _in_bounds(Heap*, int);
bool _swap_values(Heap*, int, int);

#endif