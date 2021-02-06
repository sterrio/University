/* Stephen Terrio B00755443 */
#include <stdio.h>
#include <math.h>
#include "primes.h"

// prime factorization code :
void primes(long n){
  int i = 2;
  // while there number can still be factorized
  while(n != 1){
    // if the number can be divided completely by our factor i
    while(n % i == 0){
      // print as factor, & divide
      printf("%d ", i);
      n = n/i;
    }
    // if there still must be factorization but i cannot divide, increment i
    i++;
  }
  printf("\n");
}
