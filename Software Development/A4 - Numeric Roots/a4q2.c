#include <stdio.h>
int main (void){
int x,y;

/* getting the number to find numeric root of*/
scanf("%d", &x);

if (x < 0){
printf("Error: Index out of bounds.");
return 0;
}

/* if x is already below 10, just use that value for an output */
if (x < 10){
  y = x;
  printf("%d",y);
  return 0;
}

  while (x > 0){
    y = y + (x % 10);
    x = x/10;
}
int z;
while (y > 10){
z =  y % 10;
y = y/10;
y = y + z;
}

printf("%d",y);
return 0;
}
