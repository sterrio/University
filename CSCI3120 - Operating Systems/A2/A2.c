// Stephen Terrio B00755443

// Base taken from Assignement 2 PDF -
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <sys/wait.h>
#include "linked_list.h"

// CITED RESOURCES: LinkedList.c with its respective header has been taken from previous work done in the class: Systems Programming
// It is only used for the history command.

#define MAX_LINE 80 /* max command length */

// MAIN -
int main (void){
  /* flag for program execution vs termination */
  int should_run = 1;
  LinkedList* history = llist_initialize(sizeof(char*),"string");
  LinkedList* ids = llist_initialize(sizeof(int*),"integer");

  while(should_run == 1) {
    printf("CSCI3120>");
    fflush(stdout);

    /* Reading user input, refrencing back to my solution of A1... */
    char input[250];
    // getting input until new line & discarding, adding to history list & checking special commands
    scanf("%[^\n]%*c", input);

    if(!strcmp("!!",input)){
      if(history->size == 0){printf("No command in history!\n");continue;}
      strcpy(input,llist_get(history, 0));
      printf("CSCI3120>%s\n", input);

    }else if(input[0] == '!'){
      int index = input[1] - '0';
      if(index > history->size){printf("Such a command is NOT in history!\n"); continue;}
      strcpy(input,llist_get(history,index - 1));
      printf("CSCI3120>%s\n", input);
    }
    if(strcmp("history",input)){llist_add_first(history, input);}
    char *split = strtok(input, " ");
    // 41 tokens at most, 39 buffer tokens
    char *arrayofchars[80];
    int counter = 0;
    // looping till there can be no more splits
    while(split != NULL){
        arrayofchars[counter] = split;
        split = strtok(NULL, " ");
        counter = counter + 1;
      }

    // checking for exit command
    if(!strcmp("exit",arrayofchars[0])){should_run = 0;}

    // handling for history command
    if(!strcmp("history",arrayofchars[0])){
      if(history->size == 0){printf("No command in history!\n"); continue;}
      printf("ID   PID   Command\n");
      for(int i = 0; i < history->size && i < 10; i++){
      int tempID = (*(int *)llist_get(ids,i));
      printf("%d   %d   %s\n", i+1, tempID, llist_get(history,i));
      }
      continue;
    }
    // Keeping track of function stats in case of error
    int execpStatus;
    int waitStatus;
    /* Fork to a child process */
    pid_t child;
    child = fork();
    // saving to be used later in history
    void *id = &child;
    llist_add_first(ids, id);

    // should not be non-negative unless an error occured, referencing class notes pdf
    if(child < 0){
      printf("An error occured Forking");
      return 1;
    }
    /*Child Process Running Correctly*/
    else if(child == 0 && should_run != 0){
      execpStatus = execvp(arrayofchars[0], arrayofchars);
      if(execpStatus == -1){
        // an error has occured
          printf("Invalid command!");
          exit(1);
      }
    }
    /* Parent Process */
    else {
      wait(&waitStatus);
    }
  }
}
