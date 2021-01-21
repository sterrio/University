/* Stephen Terrio, B00755443 */
#include <stdio.h>
#include "power.h"

void powerRule1(int x, int y){
  printf("%d\n", x);
}
void powerRule2(int x, int y, int z){
  int newx;
  newx = x * 2;
  printf("%dx + %d\n", newx,y);
}

void powerRule3(int x, int y, int z, int p){
  int newx;
  newx = x * 3;
  int newy;
  newy = y * 2;
  printf("%dx^2 + %dx + %d\n", newx, newy, z);
}

void powerRule4(int x, int y, int z, int p, int f){
  int newx;
  newx = x * 4;
  int newy;
  newy = y * 3;
  int newz;
  newz = z * 2;
  printf("%dx^3 + %dx^2 + %dx + %d\n", newx, newy, newz, p);

}
