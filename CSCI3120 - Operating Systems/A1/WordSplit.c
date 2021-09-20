/* Stephen Terrio B00755443 */

// Packages
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Main Function -
int main (){

char input[250]; // between 1 - 200 with 50 buffer
printf("Please enter your sentence:");
scanf("%[^\n]%*c", input); // getting input until new line & discarding

// setting up an array of 115, as with 200 characters there cannot be more than 100 words and 100 spaces to seperate them
// using a buffer of 15 just in case
char words[115];
// splitting the sentence using space as delimiter
char *split = strtok(input, " ");

// Creating a file to write to as output.txt
FILE *file = fopen("Output.txt", "w");
if (file == NULL){
  // error handling incase output.txt cannot be made
  printf("There was an error trying to create output file");
  exit(1);
}
// looping till there can be no more splits
while(split != NULL){
  // printing the split string to stdout in order:
  printf("%s\n", split);
  fprintf(file, "%s\n", split);
  split = strtok(NULL, " ");
  }

// output.txt results have finished writing
fclose(file);
}
