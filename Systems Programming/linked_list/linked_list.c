// Linked Lists
/* Stephen Terrio B00755443 */

// Packages
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "linked_list.h"
#include <stdbool.h>

// Creating Linked List Structure 
LinkedList* llist_initialize(int x, char* dType){
    // Allocating memory to store the list information
    LinkedList* list = (LinkedList*) malloc(sizeof(LinkedList));
    // Node next
    list->first = NULL;
    // Node prev
    list->last = NULL;
    list->size = 0;
    list->itemSize = x;
    list->type = dType;
    return list;
}

bool llist_add_at(LinkedList* list, int index, void* objV) { 
    if (list != NULL && objV != NULL) {
        Node* obj = (Node*)malloc(sizeof(Node));
        if (strcmp(list->type, "int")) {
            obj->data = (int*)objV;
        } else if (strcmp(list->type, "string")) {
            obj->data = (char*)objV;
        }
        
        Node* current = list->first;
        for (int i = 0; i < list->size; i++) {
            if (i == index) {
                if (i == 0 && list->first == NULL) {
                    list->first = obj;
                } else if (i == 0) {
                    // adding in at the start
                    list->first->prev = obj;
                    obj->next = list->first;
                    list->first = obj;
                } else if (i == list->size - 1) {
                    // adding in at the end
                    list->last->next = obj;
                    obj->prev = list->last;
                    list->last = obj;
                } else {
                    // adding in the middle
                    obj->prev = current->prev;
                    current->prev->next = obj;
                    current->prev = obj;
                    obj->next = current;
                }
                list->size++;
                return true;
            }
            current = current->next;
        }
    }
    return false;
}

bool llist_add_first(LinkedList* list, void* objV) {
    Node* obj = (Node*)malloc(sizeof(Node));
    if (strcmp(list->type, "int")) {
        obj->data = (int*)objV;
    } else if (strcmp(list->type, "string")) {
        obj->data = (char*)objV;
    }

    if (list->size > 0) {
        obj->next = list->first;
        list->first->prev = obj;
    } else {
        list->last = obj;
    }
    list->first = obj;
    list->size++;
    return true;
}

bool llist_add_last(LinkedList* list, void* objV) {    
    Node* obj = (Node*)malloc(sizeof(Node));
    if (strcmp(list->type, "int")) {
        obj->data = (int*)objV;
    } else if (strcmp(list->type, "string")) {
        obj->data = (char*)objV;
    }

    if (list->size > 0) {
        list->last->next = obj;
        obj->prev = list->last;
    } else {
        list->first = obj;
    }
    list->last = obj;
    list->size++;
    return true;
}

void* llist_get(LinkedList* list, int index) {
    // Error handling
    if (index > list->size) {
        return NULL;
    }

    Node* current = list->first;
    for (int i = 0; i < list->size; i++) {
        if (i == index) {
            return current->data;
        }
        current = current->next;
    }
    return current->data;
}

int llist_index_of(LinkedList* list, void* objV) {
    if (list != NULL && objV != NULL) {
        int* obj = (int*)objV;
        Node* current = list->first;
        for (int i = 0; i < list->size; i++) {
            if (current->data == obj) {
                return i;
            }
            current = current->next;
        }
    }
    return -1;
}

void* llist_remove(LinkedList* list, int index) {
    Node* current = list->first;
    for (int i = 0; i < list->size; i++) {
        if (i == index) { 
            if (current->next != NULL) {
                current->next->prev = current->prev;
            }
            if (current->prev != NULL) {
                current->prev->next = current->next;
            }
            list->size--;
            return current->data;
        }
        current = current->next;
    }

    return NULL;
}

void llist_remove_first(LinkedList* list) {
    if (list != NULL) {
        if (list->size != 0) {
            list->size--;
            if (list->first->next != NULL) {
                list->first->next->prev = NULL;
                list->first = list->first->next;
            }
        }
    }
}

void llist_remove_last(LinkedList* list) {
    if (list != NULL) {
        if (list->size != 0) {
            list->size--;
            if (list->last->prev != NULL) {
                list->last->prev->next = NULL;
                list->last = list->last->prev;
            }
        }
    }
}

bool llist_destroy(LinkedList* list) {
    if (list->size > 0) {
        Node* current = list->first;
        for (int i = 0; i < list->size; i++) {
            Node* next = current->next;
            free(current);
            current = next;
        }
        free(list);
        return true;
    } else {
        return false;
    }
}
