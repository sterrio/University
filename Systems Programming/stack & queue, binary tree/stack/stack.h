// Stephen Terrio 
// Stack header file 
#ifndef STACK_H
#define STACK_H
// Need to include this lib to use bool instead of _BOOL datatypes
#include <stdbool.h>
#include "linked_list.h"

// defining structure - 
typedef struct _Stack {
    LinkedList* list;
} Stack;

// Forward Declaring Functions - 
Stack* stack_initialize(int, char*);// int for datatype size, string for name of data 
bool stack_push(Stack*, void*); // pointer to stack, and void pointer to an element, push to top of stack
void* stack_pop(Stack*); // pop element of top of stack and return it
void* stack_peek(Stack*); // return a pointer to element on top of stack 
int stack_size(Stack*); // int representing number of elements in the stack
bool stack_contains(Stack*, void*); // True if element is in the stack, otherwise false
bool stack_destroy(Stack*); // deallocate all elements, then the stack itself

#endif
