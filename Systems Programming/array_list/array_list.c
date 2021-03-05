/* Stephen Terrio B00755443 */

// Packages
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "array_list.h"
#include <stdbool.h>

// Creating Array List init.
ArrayList* alist_initialize(int maxSize, int dataTypeSize, char* dType) {
    ArrayList* list = (ArrayList*) malloc(sizeof(ArrayList));
    list->maxSize = maxSize;
    list->size = 0; 
    list->itemSize = dataTypeSize;
    list->type = dType;
    list->arr = malloc(sizeof(void*) * maxSize);

    return list;
}

bool alist_add(ArrayList* list, void* objV) {
    if (list != NULL && objV != NULL) {
        if (list->size >= list->maxSize) {
            bool success = alist_resize(list);
            if (!success) {
                return false;
            }
        }
        list->arr[list->size] = objV;
        list->size++;
        return true;
    }
    return false;
}

bool alist_add_at(ArrayList* list, int x, void* objV) {
    if (list != NULL && objV != NULL && x < list->size) {
        if (list->size + 1 > list->maxSize) {
            bool success = alist_resize(list);
            if (!success) {
                return false;
            }
        }
        // Move every element over 1 to the right to make space for object X  {1,2, 1, 3,4,5,6,7,8,9,10};
        for (int i = list->size; i >= x; i--) {
            list->arr[i] = list->arr[i - 1];
        }
        // Add object X and increase size
        list->arr[x] = objV;
        list->size++;
        return true;
    }
    return false;
}

void alist_clear(ArrayList* list) {
    if (list != NULL) {
        for (int i = 0; i < list->size; i++) {
            free(list->arr[i]);
        }
        free(list->arr);
        list->maxSize = 0;
        list->size = 0;
    }
}

void* alist_get(ArrayList* list, int x) {
    if (list != NULL && x < list->size) {
        return list->arr[0];
    }
    return NULL;
}

int alist_index_of(ArrayList* list, void* objV) {
    if (list != NULL && objV != NULL) {
        for (int i = 0; i < list->size; i++) {
            if (strcmp(objV, list->arr[i]) == 0) {
                return i;
            }
        }
    }
    return -1;
}

void* alist_remove(ArrayList* list, int x) {
    if (list != NULL && list->size > x) {
        void* value = list->arr[x];
        for (int i = x; i < list->size; i++) {
            if (i + 1 < list->maxSize){
                list->arr[i] = list->arr[i + 1];
            } else {
                // Handle last element in the array when array is maxed
                list->arr[i] = NULL;
            }
        }
        list->size--;
        return value;
    } else {
        return NULL;
    }
}

bool alist_destroy(ArrayList* list) {
    if (list != NULL) {
        // // Delete array itself
        free(list->arr);
        // Free list object
        free(list);
        return true;
    } 
    return false;
}

bool alist_resize(ArrayList* list) {
    if (list != NULL) {
        // copy array
        void** doubleArr;
        int doubledSize = list->maxSize * 2;
        doubleArr = (void**) malloc(sizeof(void*) * doubledSize);

        for (int i = 0; i < list->size; i++) {
            doubleArr[i] = list->arr[i];
        }
        list->maxSize = doubledSize;
        // Only free the arr because new doubled array is still pointing to old values
        free(list->arr);
        list->arr = doubleArr;
        return true;
    }
    return false;
}