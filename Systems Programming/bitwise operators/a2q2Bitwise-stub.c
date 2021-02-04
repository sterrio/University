#include <stdio.h>


int bitXor(int x, int y){
  return ((x&~y) | (~x&y));}

int bitAnd(int x, int y){
  // legal ops: Legal ops: ~|*/
  return ~(~x|~y);}

int minusOne(void){
  // valid operators -> &j+<<>>*/
  return ~0x00;}

int isPositive(int x){
  //   Legal ops:  !~&|+<<>>*/
  int negativeRight= !(x>>31);
  // returning the sign results in an output of either 1 / 0 depending on the value
  int sign = ((negativeRight)&!!x);
  return sign;}

int twoCmax(void){
  // no rightshifting, therefore unsigned
  unsigned int x = ~0u;
  x >>= 1;
  return x;
  }

int main(void){

  int x = 0x5;
  int y = 0x7;
  int z = -9;

  printf("%x\n", bitXor(x,y)); /* example */
  printf("%x\n", bitAnd(x,y));
  printf("%d\n", minusOne());
  printf("%d\n", isPositive(x));
  printf("%d\n", isPositive(z));
  printf("%d\n", twoCmax());
  printf("%x\n", twoCmax());

  return 0;}
