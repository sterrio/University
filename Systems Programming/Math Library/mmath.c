/* Stephen Terrio B00755443 */

#include <stdio.h>
#include <math.h>
#include "mmath.h"

/* factorial using recursion */
long fact(int n){
  if (n > 1){
    return n * fact(n-1);
  } else {
    return n;
  }
}
/* NchooseK formula, using previously defined fact function */
long nchoosek(int n, int k){
  if (n == k) {return 1;} else{
    long choose = fact(n)/(fact(k)*fact(n-k));
    return choose;
  }
}
/* prime determination using loop */
int prime(long x){
  if (x == 1) return 0; // primes start at 2
  for (int i=2; i*i<=x; i++) {
      if (x % i == 0) return 0;
  }
  return 1;
}
/* gcd using loop */
int gcd(int x, int y){
  int gcd;
  for(int i = 1; i <= x && i <= y; i++){
    if(x%i == 0 && y%i == 0){gcd = i;}
  }
  return gcd;
}
/* Using gcd to find lcm, */
int lcm(int x, int y){
  if (x == 0||y == 0){return 0;}
  if (x == y){return x;}
  int lcm = (x/gcd(x,y))*y;
  return lcm;
}

/* Getting the binary conversion of a char and reversing it */
char bitrevc(char a){
  // Using these variables to store values as bits progress further into byte
  int reversedValue = 0;
  char outChr;
  // since a char is 1 byte, loop 8 times (8 bits)
  for (int i = 0; i < 8; i++){
    // Taking the bitwise OR to add together values correctly
    reversedValue = (reversedValue << 1) | (a & 1);
    a = a >> 1;
    }
    // Returning the reversed Binary value
  outChr = reversedValue;
  return outChr;
}
