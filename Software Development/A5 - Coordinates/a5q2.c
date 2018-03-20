#include <stdio.h>

/* Main method */
int main (void){

  int points [10][2];
  /* Getting & storing the coordinate values */

  for (int i = 0; i < 10; i++){
    int x,y;
    scanf("%d %d",&x,&y);
    points [i][0] = x;
    points [i][1] = y;
  }
  /* Sorting the coordinates by x values */
  for (int i = 0; i < 10; i++){
    for (int j =0; j < 10 - i; j ++){

    if (points[j][0] > points[j+1][0]){
    int temp[2];
	temp [0] = points[j][0];
	temp [1] = points [j][1];

    points [j][1] =points[j+1][1];
	points [j][0] = points [j+1][0];
    points [j+1][0] = temp[0];
	points [j+1][1] = temp [1];
      }
    }
  }
int n = 0;
int max[10][2];
int largest = 0;
for (int i=0; i < 10; i++) {
  if (points[9-i][1] > largest) {
    largest = points[9-i][1];
    max[n][0] = points[9-i][0];
    max[n][1] = points[9-i][1];
	n++;
  }
}
for (int i = 0; i < n; i++) {
   printf("%d %d\n", max[i][0], max[i][1]);
}
return 0;
}
