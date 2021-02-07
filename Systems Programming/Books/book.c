/* Stephen Terrio B00755443 */

// Packages
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "book.h"

// INIT THE STRUCTURE TO STORE BOOK -
// Creating a "Book" Using the total size that is passed in via integer.
Book* make_book(int total){
  // Allocating memory to store the book information
  Book* book = (Book*)malloc(sizeof(Book));
  // Initializing variables when they have not been already
  if (book != NULL){
    book->characterCount = 0; // char count
    book->lineCount = 0; /// line count
    // Allocating memory for each line to be stored as a string (char**) (based on size of char*)
    book->lines = malloc(total * sizeof(char*));
    book->total = total; // Set to the input's Line Total
    for (int i = 0; i < total; i++){
      //Initialise each line, they will later be filled by the function fill_book
      book->lines[i] = NULL;
    }
  }
  return book;
}

// ERASE BOOK INFO -
// Deallocate the memory of the passed in address that contains book info
void burn_book(Book *book){
  // if there book contains information
  if (book != NULL){
    // if the lines in the book contains information
    if (book->lines != NULL){
      // looping through all the chars of the book lines and deallocating each
      for (int i = 0; i < book->total; i++){
        if (book->lines[i] != NULL){
          // deallocation
          free(book->lines[i]);
          // Setting chars to null
          book->lines[i] = NULL;
        }
      }
      // deallocating the char** (lines) which contained the Characters
      free(book->lines);
      // setting the array to null
      book->lines = NULL;
    }
    // deallocating the entire book structure
    free(book);
  }
}

// Writing to a file -
// Allowing for the writing of a book struct to a file of specified name
bool save_book(Book *book, char* file){
  if (book != NULL){
    //Making the output file
    FILE *output = fopen(file, "w");
      // looping through all line in the book, i
      for (int i = 0; i < book->total; i++){
        if (book->lines[i] != NULL){
          //Writing the lines to the output file
          fprintf(output, "%s", book->lines[i]);
        }
      }
      //Closing and returning true if successful
      fclose(output);
      return true;
  }
  // return false if the book could not be written to the file
  return false;
}

// Reading from a File -
// Taking file information and storing it into the book structure
bool fill_book(Book *book, char* file){
  if (book != NULL){
    //Reading the book
    FILE *input = fopen(file, "r");

    int charNum = 0; // Storing the length of each line, with the help of lineLength
    char lineLength[2500] = { '\0' }; // All char** end with '\0' therefore, we can use this fact to determine the length of the line

    while ((book-> lineCount < book-> total) && fgets(lineLength, sizeof(lineLength), input) != NULL){
        // Getting the amount of chars in the Line
        charNum = strlen(lineLength);
        // Allocating the proper memory based on the amount of characters we have currently
        book->lines[book->lineCount] = malloc(charNum+1*sizeof(char));
        // Copying values to the book structure
        strncpy(book->lines[book->lineCount], lineLength, charNum);
        book->lines[book->lineCount][charNum] = '\0';
        ++(book->lineCount);
        book->characterCount += charNum;
      }
    fclose(input); /* Finished writting, closing input file */
    return true;
  }
  return false; /* Returning False if we could not write information from input */
}

// Editing Book Struct -
// Removing the lines in which contain the specified input string, return amount of edits
int edit_book(Book *book, char* input){
  // Keeping track of number of edits, and current scanValue
  int edits = 0;
  char *scanValue = NULL;
  // Looping through all the lines in the book for occurences
  for (int i = 0; i < book->total; i++){
    if (book->lines[i] != NULL){
      // Using strstr to scan through the input for occurences of the input string, if there are none, then...
      scanValue = strstr(book->lines[i], input);
      // this code will not run - therefore bringing us to the end of the edits
      if (scanValue != NULL){
        // Deallocate
        free(book->lines[i]);
        // Remove the line, increase the edits
        book->lines[i] = NULL;
        (book->lineCount)-= 1;
        edits++;
      }
    }
  }
  return edits;
}

// Printing to STDOUT -
// Finally, reading through the book via each line
void read_book(Book *book){
  //Looping through and printing lines until we reach the total amount of lines
  for (int i = 0; i < book->total; i++){
    if (book->lines[i] != NULL){
      printf("%s", book->lines[i]);
    }
  }
}
