// Stephen Terrio, B00755443
// C file for Heap
#include "heap.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

// Helper functions:
// Helper function for Heapify functions
bool _swap_values(Heap* heap, int index1, int index2) {
    if (heap != NULL && _in_bounds(heap, index1) && _in_bounds(heap, index2)) {
        // Swap values in array
        void* temp = heap->list->arr[index1];
        heap->list->arr[index1] = heap->list->arr[index2];
        heap->list->arr[index2] = temp;
        return true;
    }
    return false;
}

bool _in_bounds(Heap* heap, int index) {
    if (index < heap_size(heap) && index >= 0) {
        return true;
    }
    return false;
}

// Defining Functions - 
Heap* heap_initialize(int dataTypeSize, char* dataType, int(*compare)(void*,void*),void(*print)(void*)){
    // Allocating memory for heap
    Heap* heap = malloc(sizeof(*heap));
    heap->list = alist_initialize(10, dataTypeSize, dataType);
    // Declaring functions
    heap->compare = compare;
    heap->print = print;
    return heap;
}
bool heap_insert(Heap* heap,void* element){
     if (heap != NULL) {
        // Add element to end of list
        if (alist_add(heap->list, element)) {
            // Heapify up
            return _heapify_up(heap, heap_size(heap) - 1);
        }
    }
    return false;
}
void* heap_remove(Heap* heap){
    if (heap != NULL) {
        if (_swap_values(heap, 0, heap_size(heap) - 1)) {
            void* element = alist_remove(heap->list, heap_size(heap) - 1);
            if (element != NULL) {
                _heapify(heap, 0);
                return element; 
            }
        }
    }
    return NULL;
}
void* heap_peek(Heap* heap){
    if (heap != NULL) {
        return alist_get(heap->list, 0);
    }
    return NULL;
}
// Finding Size
int heap_size(Heap* heap){
    if (heap != NULL) {
        return heap->list->size;
    }
    return -1;
}
// true if contains, otherwise false
bool heap_contains(Heap* heap, void* element){
     if (heap != NULL && element != NULL) {
         // finding the index, if index doesn't exist then element is not contained
        if (alist_index_of(heap->list, element) >= 0) {
            return true;
        }
    }
    return false;
}

/*
i*2 + 1 : where i is index, and result is the left child node in a binary tree representation
i*2 + 2 : where i is index, and result is the right child node in a binary tree representation
*/
// Heapify Down
bool _heapify(Heap* heap,int index){
    /* not null & children nodes do not go out of bounds */ 
    if (heap != NULL) {
        // Finding index of Children
        int leftChildIndex = 2*index + 1; // formula above
        int rightChildIndex = 2*(index+1); // formula above

        if (_in_bounds(heap, index)) {
            int top = index;
            // Comparing parent value to left child value
            if (_in_bounds(heap, leftChildIndex) && heap->compare(alist_get(heap->list, leftChildIndex), alist_get(heap->list, top)) > 0){
                top = leftChildIndex;
            }
            // comparing current top value to right child value
            if (_in_bounds(heap, rightChildIndex) && heap->compare(alist_get(heap->list, rightChildIndex) ,alist_get(heap->list, top)) > 0){
                top = rightChildIndex;
            }
            // If top value no longer equals parent value index - swap 
            if (top != index){
                _swap_values(heap, index, top); 
                return _heapify(heap, top);
            }
        } else {
            return true;
        }
    }
    // cannot heapify NULL heap
    return false;
}
// Heapify up using - (index -1)/2
bool _heapify_up(Heap* heap,int index){
     if (heap != NULL) {
         // Finding the index of the parent node to the index
        int parentIndex = ceil((index - 1) / 2);
        // if at the top of the tree, complete
        if (parentIndex < 0) {
            return true;
        }
        // finding parent node and setting child node
        void* parent = alist_get(heap->list, parentIndex);
        void* child = alist_get(heap->list, index);
        // if they swap - recursively call heapify
        if (heap->compare(child, parent) > 0) {
            if (_swap_values(heap, parentIndex, index)) {
                return _heapify_up(heap, parentIndex);
            }
        } else {
            // heapify complete
            return true;
        }
    }
    // cannot heapify a NULL heap
    return false;
}
