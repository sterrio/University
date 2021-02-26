/* Stephen Terrio B00755443 */
#ifndef LINKED_LIST_H
#define LINKED_LIST_H
// Need to include this lib to use bool instead of _BOOL datatypes
#include <stdbool.h>

// Defining a Node
typedef struct _Node {
    void* data; // Data held by this node
    struct _Node* next; // Node after current node in LinkedList
    struct _Node* prev; // Node before current node in LinkedList
} Node;

// Defining a List
typedef struct _LList {
    Node* first; // A pointer to the first node in the Linked List
    Node* last; // A pointer to the last node in the Linked List
    int size; // Current number of nodes in Linked List
    int itemSize; // Size of data held by this Linked List in bytes
    char* type; // The name of data type held by this linked list as a string
} LinkedList;

// Forward Declaring functions
LinkedList* llist_initialize(int, char*); // int for setting data type, char* for string representation of that type
bool llist_add_at(LinkedList*, int, void*); // A pointer to a linked list, an integer index, and a void pointer to an element
bool llist_add_first(LinkedList*, void*); //A pointer to a linkedlist and a void pointer to an element.
bool llist_add_last(LinkedList*, void*); //A pointer to linkedlist and a void pinter to an eleement
void* llist_get(LinkedList*, int); // Pointer to LinkedList and an int representing index
int llist_index_of(LinkedList*, void*); // Pointer to linkedlist and void pointer to an element
void* llist_remove(LinkedList*, int); // A pointer to a LinkedLIst and an int representing an index
void llist_remove_first(LinkedList*); // A pointer to linkedlist
void llist_remove_last(LinkedList*); // A pointer to linkedlist
bool llist_destroy(LinkedList*); // A pointer to linkedlist

#endif