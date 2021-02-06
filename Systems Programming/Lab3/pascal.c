/* Stephen Terrio B00755443 */
#include <stdio.h>
#include <math.h>
#include "pascal.h"

void pascal(int n){
  // storing values or row in arr
  int arr[n];
  // looping through all terms in the row, calculating Kth terms
  for(int k = 0; k <= n; k++){
    int indexVal = fact(n)/(fact(k)*fact(n-k));
    printf("%d ", indexVal);
    printf("\n");
  }
}
