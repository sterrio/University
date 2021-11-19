// Stephen Terrio, B00755443 - A4
// Referencing back to A3 during certain sections of code.

// references:
//https://stackoverflow.com/questions/1343890/how-do-i-restrict-a-float-value-to-only-two-places-after-the-decimal-point-in-c
//https://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/
//https://www.easycodingzone.com/2021/06/c-program-on-sjfshortest-job-first.html

// PACKAGES -
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

// Structure for containing task information -
typedef struct task{
  char* taskName; // input
  int arrival_T; // input
  int burst_T; // input
  int waiting_T; // this will be calculated depending on current ALG
  int concurent_T; // Need this for PSJF
} task;

int main(int args, const char* argv[]){

// Referencing back to A3 to read file -
  FILE *file = fopen("TaskSpec.txt", "r");
  if (file == NULL){
    printf("No such file: TaskSpec.txt could not be read.");
    return 1;
  }
  // reading from file
  char* commands[50];
  char input[50];
  int count = 0;
  while(fgets(input, sizeof(input), file)){
    // using strdup so value is not overritten by fgets
    commands[count] = strdup(input);
    count+= 1;
    }
  fclose(file);

  // Creating Output File to be written to
  FILE *fileO = fopen("Output.txt", "w");
  if (fileO == NULL){
    // error handling incase output.txt cannot be made
    printf("There was an error trying to create output file");
    exit(1);
  }

// we now have an array (commands) filled with our values in string format
  struct task tasks[count]; // MAIN ARRAY
  for(int i = 0; i < count; i ++){
    char* temp[3]; // using one extra index as buffer
    char *current = commands[i];
    char *split = strtok(current,",");
    int index = 0;
    // isolating elements from input lines and storing in temp array
    while(split != NULL){
      temp[index] = split;
      index++;
      split = strtok(NULL, ",");
    }
    // converting and adding elements to struct to be stored
    task *t = (task *) malloc(sizeof(task));
    t->taskName = strdup(temp[0]);
    t->arrival_T = atoi(temp[1]);
    t->burst_T = atoi(temp[2]);
    t->waiting_T = 0;
    t->concurent_T = 0;
    tasks[i] = *t;
  }
  // we now have an array of structs to access our task information (tasks)
  // HANDLE: FCFS - can be done using a simple for() loop
  int starting_time = 0;
  int waiting_times[count];
  fprintf(fileO, "FSFC:\n");
  for(int i = 0; i < count; i++){
    waiting_times[i] = starting_time - tasks[i].arrival_T;
    int ending_time = starting_time + tasks[i].burst_T;
    fprintf(fileO, "%s %d %d\n", tasks[i].taskName, starting_time, ending_time);
    starting_time += tasks[i].burst_T;
  }
  // Finding AVG waiting time:
  float avg_waiting = 0;
  for(int i = 0; i < count; i++){
    fprintf(fileO, "Waiting Time %s: %d\n", tasks[i].taskName, waiting_times[i]);
    avg_waiting += waiting_times[i];
  }
  avg_waiting = avg_waiting/count;
  // referenced how to floor a float:
  // https://stackoverflow.com/questions/1343890/how-do-i-restrict-a-float-value-to-only-two-places-after-the-decimal-point-in-c
  avg_waiting = floorf(avg_waiting * 100)/100;
  fprintf(fileO, "Average Waiting Time: %.2f\n", avg_waiting);

  // HANDLE: ROUND ROBIN - Assuming Time Quantum: 4
  // referenced https://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/
  fprintf(fileO, "\nRR:\n");
  // tasks[] is an array sorted by arrival time, we can therefore use that to find when to add other task to ready q
  int rrCurrentT = 0; // used to keep track of current running time value
  struct task rr[count];
  for (int i = 0; i < count; i++){
    rr[i].taskName = NULL;
  }
  int curSize = 0; // size of ready queue
  int timeQuantum = 4;
  while(true){
    roundstart:
    // Accounting for Arrival Times
    for(int i = 0; i < count; i++){
      // If there is already info defined, skip
      if(rr[i].taskName != NULL){continue;}
      // otherwise, write to the ready queue if we recieve new tasks within time quantum
      if(tasks[i].arrival_T <= rrCurrentT + timeQuantum){
        memcpy(&rr[i], &tasks[i], sizeof(tasks[i]));
        curSize++; // updating size of ready queue
      }
    }
    bool singleCase = false;
    int singleCaseQuantum = 0;
    int rrRemainder = 0;
    if(curSize == 1){
      while(true){
        for(int i = 1; i < count; i++){
          if(rrCurrentT > tasks[i].arrival_T){
            goto roundstart;
          }
        }
        if(rr[0].burst_T > timeQuantum){
          singleCaseQuantum ++;
          rr[0].burst_T = rr[0].burst_T - timeQuantum;
          rrCurrentT += timeQuantum;
        }else{
          rrRemainder = rr[0].burst_T;
          rrCurrentT = rrCurrentT + rrRemainder;
          rr[0].waiting_T = rrCurrentT - tasks[0].burst_T - tasks[0].arrival_T;
          rr[0].burst_T = 0;
          singleCase = true;
          goto roundend;
        }
      }
      singleCase = true;
    }
    roundend:
    if (singleCase){
      fprintf(fileO, "%s  %d  %d\n",rr[0].taskName, rr[0].arrival_T, rrCurrentT);
      break;
    }

    bool done = true;
    for(int i = 0; i < curSize; i++){
      if(rr[i].burst_T > 0){
        done = false;
        if(rr[i].burst_T > timeQuantum){

          fprintf(fileO, "%s  %d  %d\n",rr[i].taskName, rrCurrentT, rrCurrentT + timeQuantum);
          rrCurrentT += timeQuantum;
          rr[i].burst_T = rr[i].burst_T - 4;

        }else{
          int endTime = rrCurrentT + rr[i].burst_T;
          fprintf(fileO, "%s  %d  %d\n",rr[i].taskName, rrCurrentT, endTime);
          rrCurrentT = rrCurrentT + rr[i].burst_T;
          rr[i].waiting_T = rrCurrentT - tasks[i].burst_T - tasks[i].arrival_T;
          rr[i].burst_T = 0;
        }
      }
    }
    if(done == true){break;}
  }
  // printing wait times
  float rrAvgWTime = 0;
  for(int i = 0; i < count; i ++){
    fprintf(fileO, "Waiting Time %s: %d\n", tasks[i].taskName, rr[i].waiting_T);
    rrAvgWTime += rr[i].waiting_T;
  }
  rrAvgWTime = rrAvgWTime/count;
  rrAvgWTime = floorf(rrAvgWTime * 100)/100;
  fprintf(fileO, "Average Waiting Time: %.2f\n", rrAvgWTime);

  // HANDLE: Non-preemptive Shortest-Job-First (NSJF)
  fprintf(fileO, "\nNPSJF:\n");
  struct task ns[count];
  for(int i = 0; i < count; i ++){
    ns[i].taskName = NULL;
  }

// Variables to be used in NPSJF
  int nsCurrentT = 0;
  int nsCurrSize = 0;
  int burstsRan = 0;
  int smallestBurst = 10000;
  float nsAvg = 0;

// Commencing ALGO -
  while(true){
    // Accounting for Arrival Time
    for(int i = 0; i < count; i++){
      if(tasks[i].arrival_T <= nsCurrentT && ns[i].taskName == NULL){
        ns[i] = tasks[i];
        nsCurrSize++;
      }
    }
    // Checking for smallest burst of recieved tasks
    for(int i = 0; i < nsCurrSize; i++){
      if(ns[i].burst_T != 0 && ns[i].burst_T < smallestBurst){
        smallestBurst = ns[i].burst_T;
    }
  }
  // if an element is in ready queue
    if(nsCurrSize >= 1){
      // find the element with smallest burst in ready queue and run.
      for(int i = 0; i < nsCurrSize; i ++){
        if(ns[i].burst_T > 0 && ns[i].burst_T == smallestBurst){
          // printing values
          fprintf(fileO, "%s  %d  %d\n", ns[i].taskName, nsCurrentT, nsCurrentT + ns[i].burst_T);
          nsCurrentT = nsCurrentT + ns[i].burst_T;
          ns[i].waiting_T = nsCurrentT - ns[i].burst_T - ns[i].arrival_T;
          ns[i].burst_T = 0;
          smallestBurst = 10000; // resetting smallest burst
          burstsRan++;
        }
      }
    }
    // when all bursts have run, break out of the loop
    if(burstsRan == count){goto nsEnd;}
  }
  nsEnd:
  for (int i = 0; i < count; i++){
    fprintf(fileO, "Waiting Time %s: %d\n", tasks[i].taskName, ns[i].waiting_T);
    nsAvg += ns[i].waiting_T;
  }
  nsAvg = nsAvg/count;
  nsAvg = floorf(nsAvg * 100)/100;
  fprintf(fileO, "Average Waiting Time: %.2f\n", nsAvg);

  // HANDLE: Preemptive Shortest-Job-First (SJF)
  // AKA: Shortest Remaining Time First
  // Studied and based on: https://www.easycodingzone.com/2021/06/c-program-on-sjfshortest-job-first.html
  fprintf(fileO, "\nPSJF:\n");
  // initializing new array of structs
  struct task sj[count];
  memcpy(&sj, &tasks, sizeof(tasks));
  // created a local maxima at the end of the new array
  sj[count].burst_T = 100; // Maxima
  int completed = 0; // Number of completed Tasks
  int shortestBurst; // current shortest burst time
  int sjTotalTime = 0; // total running time of sjf
  int temptimer = 0; // current running time of task
  struct task tempCheck = tasks[0]; // init check

  // in this loop, i represents our current time spent processing tasks
  for(int i = 0; completed != count; i ++){
    bool ran = false; // bool for checking if uncompleted task has run previously
    int shortestBurst = count;
    for(int y = 0; y < count; y++){
      if(sj[y].burst_T < sj[shortestBurst].burst_T && (sj[y].arrival_T <= i && sj[y].burst_T > 0)){
        shortestBurst = y;
      }
    }
    sj[shortestBurst].burst_T = sj[shortestBurst].burst_T - 1;
    temptimer++;
    // figure out what # comes next
    int shortestBurstTemp = count;
    for(int y = 0; y < count; y++){
      if(sj[y].burst_T < sj[shortestBurstTemp].burst_T && (sj[y].arrival_T <= i + 1 && sj[y].burst_T > 0)){
        shortestBurstTemp = y;
      }
    }
    // if a task is not completed:
    if(tempCheck.taskName != sj[shortestBurst].taskName && sj[shortestBurst].burst_T != 0){
      if(shortestBurstTemp == 1 && strcmp(tempCheck.taskName, "T1") == 0){fprintf(fileO, "%s  %d  %d\n", tempCheck.taskName, tempCheck.concurent_T, sjTotalTime);}
      if(sj[shortestBurstTemp].burst_T != 0 && shortestBurstTemp != shortestBurst){fprintf(fileO, "%s  %d  %d\n", sj[shortestBurst].taskName, sjTotalTime, temptimer);}
      sj[shortestBurst].concurent_T = i;
      ran = true;
    }
    // If a tasks is completed:
    if(sj[shortestBurst].burst_T == 0 && !ran){
      if(tempCheck.taskName == sj[shortestBurst].taskName){
        if(sj[shortestBurst].concurent_T == 0){sj[shortestBurst].concurent_T = abs(sjTotalTime - (sjTotalTime - (sj[shortestBurst].burst_T - sj[shortestBurst].arrival_T)));}
        fprintf(fileO, "%s  %d  %d\n", sj[shortestBurst].taskName, sj[shortestBurst].concurent_T, temptimer);
        // Calc waiting time (sjTotalTime+1 to account for current cycle)
        sj[shortestBurst].waiting_T = (sjTotalTime+1) - sj[shortestBurst].arrival_T - tasks[shortestBurst].burst_T;
      }
      completed++;
    }
    sjTotalTime++;
    tempCheck = sj[shortestBurst];
  }

  float sjAvg = 0;
  // Printing wait times:
  for(int i = 0; i < count; i++){
    fprintf(fileO, "Waiting Time %s: %d\n", sj[i].taskName ,sj[i].waiting_T);
    sjAvg = sjAvg + sj[i].waiting_T;
  }
  sjAvg = sjAvg/count;
  sjAvg = floorf(sjAvg * 100)/100;
  fprintf(fileO, "Average Waiting Time: %.2f\n", sjAvg);

}
