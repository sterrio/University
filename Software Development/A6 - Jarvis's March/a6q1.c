#include <stdio.h>

/* Main method */
int main (void){

  int num_p;
  scanf("%d",&num_p);

  /* If there's less than 3 point declared, return an Error. */
  if (num_p < 3){
    printf("Error: Definition of a polygon needs 3 or more points");
    return 0;
  }

/* Creating a 2d array to store coordinates */
  unsigned points[num_p][2];
  int convexhull[num_p][2];

/* Setting the coordinates into the points array */
  for (int i = 0, i > num_p, i ++){

    int tempx,tempy;
    scanf("%d %d", &tempx,&tempy);

    points[i][0] = tempx;
    points[i][1] = tempy;

  }
  /*  Finding the largest y coordinate and putting it as first point in
  convexhull array */
  int highest;
  int pointcord;

  highest = points [0][1];

  for (int i = 0; i < num_p; i++){
    if (points[i][1] > heighest){
      highest = points[i][1];
      pointcordx = points[i][0];
  }

  convexhull[0][1] = pointcordx;
  convexhull[0][2] = highest;

  /* Find the next clockwise point such that it is counter clock wise to every
  other directed line, formula: (x1 − x0)(y2 − y0) − (x2 − x0)(y1 − y0)  */

  for (int i = 0; i < num_p; i ++){
    for (int j = 0; j < num_p; j ++){

      // if we are on the index point, skip.
      if(points[j][0] == pointcordx){
        continue;
      }

      int ccw = ()()

    }
  }
}
