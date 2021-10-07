#include "linked_list.h"
#include <stdlib.h>
#include <string.h>

LinkedList* llist_initialize(int typeSize, char* typeName)
{
	// Create a linked list struct.
	LinkedList* llist = malloc(sizeof(*llist));

	// If the linked list can't have memory allocated, return NULL.
	if(llist == NULL)
		return NULL;

	// Initialize all of the linked list fields.
	llist->first = NULL;
	llist->last  = NULL;
	llist->size  = 0;
	llist->itemSize = typeSize;
	llist->type = malloc(strlen(typeName));
	strcpy(llist->type, typeName);

	// Return the empty linked list.
	return llist;
}

bool llist_add_at(LinkedList* llist, int index, void* element)
{
	// If the list or element are null, return false.
	if(llist == NULL || element == NULL)
		return false;

	// If the index doesn't fit in the bounds of the
	// list, we can return false.
	if(index < 0 || index > llist->size)
		return false;

	// Create a new node and populate its data.
	Node *node = malloc(sizeof(*node));
	node->data = malloc(llist->itemSize);
	memcpy(node->data, element, llist->itemSize);

	// If we haven't added any nodes yet, we need to
	// ensure both the first and last are updated.
	if(llist->size == 0)
	{
		llist->first = node;
		llist->last  = node;
		node->next = NULL;
		node->prev = NULL;
	}
	// If we are adding on the front of the list,
	// we only need to deal with the first pointer.
	else if(index == 0)
	{
		node->next = llist->first;
		node->prev = NULL;
		llist->first->prev = node;
		llist->first = node;
	}
	// If we are adding on the end of the list,
	// we only need to deal with the last pointer.
	else if(index == llist->size)
	{
		node->next = NULL;
		node->prev = llist->last;
		llist->last->next = node;
		llist->last = node;
	}
	// If we get here, we are inserting somewhere
	// in the middle of the list.
	else
	{
		// Create a temporary traversal node.
		Node *temp = llist->first;

		// Iterate until we get to the node to be removed.
		for(int i=0; i < index; i++)
			temp = temp->next;

		// Set the new node's previous to the current node's previous.
		node->prev = temp->prev;

		// Set the new node's next to the current node.
		node->next = temp;

		// Set the previous node to point to the new one.
		temp->prev->next = node;

		// Set the current node to point to the new one.
		temp->prev = node;
	}

	// Increase the size of the linked list by 1.
	llist->size++;
	return true;
}

bool llist_add_first(LinkedList* llist, void* element)
{
	// We can simply call/return "add_at". It will check for NULL.
	return llist_add_at(llist, 0, element);
}

bool llist_add_last(LinkedList* llist, void* element)
{
	// We need to check if llist is null before we
	// use llist->size, otherwise we'll seg fault.
	if(llist == NULL)
		return false;

	// Return the value of "add_at" on the list size.
	return llist_add_at(llist, llist->size, element);
}

void* llist_get(LinkedList* llist, int index)
{
	// If the list is null, we return null.
	if(llist == NULL)
		return NULL;

	// If the index isn't in the list right now, return null.
	if(index < 0 || index >= llist->size)
		return NULL;

	// Create a temporary node variable and store the first node.
	Node *temp = llist->first;

	// Iterate through the list until we find the element.
	for(int i=0; i < index; i++)
		temp = temp->next;

	// Return a pointer to the element.
	return temp->data;
}

int llist_index_of(LinkedList* llist, void* element)
{
	// If the list is null or the element is null, we return -1.
	if(llist == NULL || element == NULL)
		return -1;

	// Create a temporary node variable and store the first node.
	Node *temp = llist->first;

	// Iterate through the list until we find the element.
	for(int i=0; i < llist->size; i++)
	{
		// Compare the element to the stored data of this node.
		// If the data matches the element, return the index.
		if(memcmp(temp->data, element, llist->itemSize) == 0)
			return i;

		// Move to the next list node.
		temp = temp->next;
	}

	// If we get here, the list didn't have the element. Return -1.
	return -1;
}

void* llist_remove(LinkedList* llist, int index)
{
	// If the list is null, return null.
	if(llist == NULL)
		return NULL;

	// If the index is out of bounds, return null.
	if(index < 0 || index >= llist->size)
		return NULL;

	// Create a temporary node.
	Node *temp = llist->first;

	// Iterate until we get to the node to be removed.
	for(int i=0; i < index; i++)
		temp = temp->next;

	// Adjust the pointers of adjacent nodes and linked list:
	// 1) If the list only has one node, we simply set the
	//    linked list's first and last pointers to NULL.
	// 2) If we are removing the first node, we only have to
	//    adjust the next node's pointers and update the
	//    linked list's first node pointer.
	// 3) If we are removing the last node, we only have to
	//    adjust the previous node's pointers and update the
	//    linked list's last node pointer.
	// 4) Otherwise we adjust the next and prev nodes to make
	//    sure they point to each other.
	if(llist->size == 1)
	{
		llist->first = NULL;
		llist->last  = NULL;
	}
	else if(index == 0)
	{
		llist->first = temp->next;
		llist->first->prev = NULL;
	}
	else if(index == llist->size-1)
	{
		llist->last = temp->prev;
		llist->last->next = NULL;
	}
	else
	{
		temp->prev->next = temp->next;
		temp->next->prev = temp->prev;
	}

	// Reduce the size of the linked list by 1.
	llist->size--;

	// Save the data from the node.
	void* data = temp->data;

	// Free the node.
	free(temp);

	// Return the removed node. It is up to the owner to free it.
	return data;
}

void* llist_remove_first(LinkedList* llist)
{
	// We can call "remove" on the first index.
	return llist_remove(llist, 0);
}

void* llist_remove_last(LinkedList* llist)
{
	// If llist is null, we can't use the the
	// llist->size member without a seg fault.
	if(llist == NULL)
		return false;

	// We can call "remove" on the last index.
	return llist_remove(llist, llist->size-1);
}

bool llist_destroy(LinkedList* llist)
{
	// If the list is null, we can't destroy it. Return false.
	if(llist == NULL)
		return false;

	// If there are nodes available in the list, free them.
	if(llist->size > 0)
	{
		// Create a temporary node for holding nodes.
		Node *current = llist->first;
		Node *next    = NULL;

		// Iterate through all of the nodes.
		for(int i=0; i < llist->size; i++)
		{
			// Store a pointer to the next node.
			next = current->next;

			// Free this node's data.
			free(current->data);

			// Free this node.
			free(current);

			// We move to the next node.
			current = next;
		}
	}

	// Free the necessary linked list fields.
	free(llist->type);

	// Free the linked list.
	free(llist);

	// We destroyed the list. Return true.
	return true;
}
