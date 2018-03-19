#include <stdio.h>

/* Main method */
int main (void){

  int height;
  scanf("%d",&height);
  /* Print an error message and terminate if height input is not valid */
  if (height != 1 && height != 2 && height != 3){
    printf("Error: Incorrect input selection. Please enter a number 1 to 3.");
    return 0;
  }
  int students;
  scanf("%d",&students);

  /* If there is a negative amount of students, print an error message and terminate */
  if (students < 0){
    printf("Error: Incorrect input. Please enter a positive student value.");
    return 0;
  }
  float calc[students];

  for(int i = 0; i < students; i = i + 1){

    /* Getting the test scores */
    int g1,g2,g3,g4;
    scanf("%d %d %d %d",&g1,&g2,&g3,&g4);

    /* If a test score input is invalid, print an error message and terminate */
    if (g1 > 100 || g1 < 0 || g2 > 100 || g2 < 0 ||g3 > 100 || g3 < 0 ||g4 > 100 || g4 < 0 ){
      printf("Error: Invalid test score input. Make sure the value is within 0 to 100.");
      return 0;
    }
    calc[i] = (g1 + g2 + g3 +g4)/4.0;	
  }

  /* Finding the minimum */
  if (height == 1){
    float minimum;
    /* Setting min to first element */
    minimum = calc[0];
    /* Loop throught the array and change out the min if conditions are met */
    for (int i =0; i < students; i = i+1){
      if ( calc [i] < minimum){
        minimum = calc[i];
      }
    }
    printf("%.2f",minimum);
  }

  /* Finding the maximum */
  if (height == 2){
    float maximum;
    /* Setting max to first element */
    maximum = calc[0];

    /* Loop throught the array and change out the max if conditions are met */
    for (int i =0; i < students; i = i+1){
      if ( calc [i] > maximum){
        maximum = calc[i];
      }
    }
    printf("%.2f", maximum);
  }

  /* Finding the average */
  if (height == 3){
    float average;
    average = 0;
    /* Adding up all the grades */
    for (int i = 0; i < students; i = i+ 1){
      average = average + calc [i];
    }
    /* Getting the actual average of the grades by dividing by amount*/
    average = average/(float)students;
    printf("%.2f",average);
  }
}

