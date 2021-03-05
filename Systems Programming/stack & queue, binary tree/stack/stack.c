// Stephen Terrio
// Stack C file


// Packages
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "stack.h"
#include <stdbool.h>
#include "linked_list.h"


Stack* stack_initialize(int dataSize, char* dataType) {
    Stack* stack = (Stack*) malloc(sizeof(stack));
    stack->list = llist_initialize(dataSize, dataType);
}

bool stack_push(Stack* stack, void* obj) {
    if(stack != NULL && obj != NULL){
        return llist_add_last(stack->list, obj);
    }
}

void* stack_pop(Stack* stack) {
    if (stack != NULL){
        return llist_remove(stack->list, stack->list->size - 1);
    }
}

void* stack_peek(Stack* stack) {
    if(llist_get(stack->list, stack->list->size - 1) != NULL){
        return llist_get(stack->list, stack->list->size - 1);
    }
}

int stack_size(Stack* stack) {
    if(stack != NULL){
        return stack->list->size;
    }
}

bool stack_contains(Stack* stack, void* obj) { 
    if(stack != NULL){
        if (llist_index_of(stack->list, obj) != -1) {
            return true;
        } else {
            return false;
        }
    }
}

bool stack_destroy(Stack* stack) {
    llist_destroy(stack->list);
    free(stack);
    return true;
}
