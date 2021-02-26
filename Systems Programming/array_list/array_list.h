/* Stephen Terrio B00755443 */
#ifndef ARRAY_LIST_H
#define ARRAY_LIST_H
// Need to include this lib to use bool instead of _BOOL datatypes
#include <stdbool.h>

typedef struct _AList {
    void** arr; // A pointer to a void pointer (Acts as an array of void pointers)
    int size; // Current number of items held by this array list
    int maxSize; // Max number of items the array list can hold before a resize
    int itemSize; // The size of data type held by this array list in bytes
    char* type; // The name of data type held by this array list as string
} ArrayList;

// Forward declaring functions
ArrayList* alist_initialize(int, int, char*); // int for max size, int for data type size, and string for name of data type being stored
bool alist_add(ArrayList*, void*); // Pointer to an array list and a void pointer to an element
bool alist_add_at(ArrayList*, int, void*); // Pointer to an array list an int representing an index & void pointer to an element
void alist_clear(ArrayList*); // Pointer to an Array list
void* alist_get(ArrayList*, int); // Pointer to an Array List and an int representing index
int alist_index_of(ArrayList*, void*); // Pointer to an Array List and void pointer to an element
void* alist_remove(ArrayList*, int); // Pointer to ArrayList and int representing index
bool alist_destroy(ArrayList*); // Pointer to Arraylist
bool alist_resize(ArrayList*); // Pointer to an ArrayList

#endif

