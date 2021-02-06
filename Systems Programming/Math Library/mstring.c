
/* Stephen Terrio B00755443 */

#include <stdio.h>
#include <math.h>
#include "mstring.h"

void strrev(char *c){
  // End out char* strings are identified with \0, loop till we hit that.
  int stringLength = 0;
  while (c[stringLength]!='\0'){
    stringLength++;
  }
  // Found the length of the string, now loop and reverse elements.
  int endpoint = stringLength -1;
  for(int i = 0;i < stringLength; i++){
      char temp = c[i];
      c[i] = c[endpoint];
      c[endpoint] = temp;
      endpoint--;
  }
}
