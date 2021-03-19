#include "array_list.h"

#include <stdlib.h>
#include <string.h>

ArrayList* alist_initialize(int size, int typeSize, char* typeName)
{
	// Create the memory for holding the array list.
	ArrayList* alist = malloc(sizeof(*alist));

	// If we couldn't allocate enough memory, return here.
	if(alist == NULL)
		return NULL;

	// Initialize the starting size and set the counts.
	alist->arr  = malloc(sizeof(*(alist->arr)) * size);
	alist->size = 0;
	alist->maxSize = size;
	alist->itemSize = typeSize;

	// Allocate memory for the type name.
	alist->type = malloc(strlen(typeName)+1);
	
	// Set the type name for reference purposes.
	strcpy(alist->type, typeName);
	
	// Return the array list structure.
	return alist;
}

bool alist_add(ArrayList* alist, void* element)
{
	// If the incoming array list is null, we can return
	// false here. The element is checked in "add_at".
	if(alist == NULL)
		return false;

	// Attempt to add the element to the end of the list.
	return alist_add_at(alist, alist->size, element);
}

bool alist_add_at(ArrayList* alist, int index, void* element)
{
	// Check if the incoming pointers are null. If so, return false.
	if(alist == NULL || element == NULL)
		return false;

	// We can't add at an index that isn't yet initialized.
	if(index < 0 || index > alist->size)
		return false;

	// If we have no room for the new element, increase
	// the size of this array list by double.
	if(alist->size == alist->maxSize)	
	{
		// Attempt to resize the list.
		bool success = _alist_resize(alist);

		// If the list failed to resize, return false.
		if(!success)
			return false;
	}
	
	// Move all of the elements after the given index
	// one space to the right to make room.
	for(int i=alist->size; i > index; i--)
		alist->arr[i] = alist->arr[i-1];
	
	// Allocate memory to the void pointer at the given index.
	alist->arr[index] = malloc(alist->itemSize);

	// Add this value to the end of the list.
	memcpy(alist->arr[index], element, alist->itemSize);

	// Increase the size by 1.
	alist->size++;

	// Since we didn't fail earlier, we succeed here.
	return true;
}

void alist_clear(ArrayList* alist)
{
	// Set every element in maxSize to null.
	for(int i=0; i < alist->maxSize; i++)
	{
		free(alist->arr[i]);
		alist->arr[i] = NULL;
	}
	
	// Set the size to 0
	alist->size = 0;
}

void* alist_get(ArrayList* alist, int index)
{
	// Check if the array list is null. If yes, return false.
	if(alist == NULL)
		return false;

	// If the index doesn't exist in the bounds, return null.
	if(index < 0 || index >= alist->size)
		return NULL;
		
	// Since the index has to exist, we can return it.
	return alist->arr[index];
}

int alist_index_of(ArrayList* alist, void* element)
{
	// Check if the incoming pointers are null. If yes, return -1.
	if(alist == NULL || element == NULL)
		return -1;

	// Iterate through the whole array if necessary.
	for(int i=0; i < alist->size; i++)
	{
		// Compare the current item to the incoming element.
		// If the elements match, return i.
		if(memcmp(alist->arr[i], element, alist->itemSize) == 0)
			return i;
	}

	// If we got here, then the element wasn't in the
	// list, so we can return -1.
	return -1;
}

void* alist_remove(ArrayList* alist, int index)
{
	// Check if the array list is null. If yes, return NULL.
	if(alist == NULL)
		return NULL;

	// If the index isn't in the bounds of initialized values, return null.
	if(index < 0 || index >= alist->size)
		return NULL;
	
	// Save the element being removed.
	void* element = alist->arr[index];

	// Start at the provided index and iterate to the end of the list-1 .
	// At each step, move the index into the current index position.
	for(int i=index; i < alist->size-1; i++)
		alist->arr[i] = alist->arr[i+1];

	// Set the current last index to null.
	alist->arr[alist->size-1] = NULL;

	// Set the new size value.
	alist->size--;

	// Return the removed element.
	return element;
}

bool alist_destroy(ArrayList* alist)
{
	// Clear the array list. This also deallocates all elements.
	alist_clear(alist);

	// Free the type string.
	free(alist->type);

	// Free the array list.
	free(alist);

	// Return true when everything is deallocated.
	return true;
}

bool _alist_resize(ArrayList* alist)
{	
	// Check if the array list is NULL. If yes, return false.
	if(alist == NULL)
		return false;

	// Attempt to reallocate the array using the new appropriate sizes.
	// Doing this separately ensures that we don't overwrite the original array
	// with a NULL pointer, because on failure realloc doesn't change the original
	// memory space or pointer. If this is NULL, we can fail, and the array will be the same.
	void* tempPointer = realloc(alist->arr, alist->maxSize * 2 * sizeof(*(alist->arr)));
	
	// If we couldn't properly rellocate, then return false.
	if(tempPointer == NULL)
		return false;
	
	// If we get here, then relloac was succesful. That means:
	// 	1. alist->arr is now freed, but its elements are not.
	// 	2. We no longer own alist->arr's memory space, so it
	// 	   should be updated to NULL or a new pointer.
	// 	3. The tempPointer is now holding the array content with
	// 	   the extra requiured space, so we need to make sure it
	// 	   is stored correctly and the associated values are updated.

	// Multiply the maximum size by 2.
	alist->maxSize *= 2;

	// Update the arr pointer to be the reallocated pointer.
	alist->arr = tempPointer;

	// Return true if we get here.
	return true;
}

