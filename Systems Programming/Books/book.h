/* Stephen Terrio B00755443 */
#ifndef BOOK_H
#define BOOK_H
// Need to include this lib to use bool instead of _BOOL datatypes
#include <stdbool.h>

// Structure to hold book elements -
typedef struct _Book{
    int characterCount; // Total Characters in the book
    int lineCount;      // Total lines in the book
    char **lines;       // Line in the book as strings
    int total;          // Overall size of the book in lines.
}Book;

// Forward declaring functions -
Book* make_book(int);            // Allocate a book's information to Memory
void burn_book(Book*);          // Dellocate a book's information from Memory
bool save_book(Book*, char*);  // Save the contents of a Book stucture to a file
bool fill_book(Book*, char*); // Fill the contents of a file to a Book structure
int edit_book(Book*, char*); // Editing the contents of a Book Structure and removing the lines with the provided string
void read_book(Book*);      // Loop through the contents of a book and print out to stdout

#endif
