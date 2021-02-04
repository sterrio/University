#include <stdio.h>

int main(void)
{
  int inChar, outChr; //note that getchar and putchar use the int type

  while (( inChar = getchar()) != EOF)
    {
      // Your bitwie code appers here ...

      /* Store the first three bits,
      circular shift the last 5 bits
      add on original 3 digits again*/

      // storing
      int tempChar;
      // Store the first three bits
      tempChar = inChar & 0b00011111;
      // circular shift the last 5 bits
      int tempChar2L = tempChar<<2;
      int tempChar3R = tempChar>>3;
      int tempCharShifted = tempChar2L | tempChar3R;
      // add on original 3 digits again
      int tempCharFirst3 = inChar & 0b11100000;
      outChr = tempCharShifted & 0b00011111;
      outChr = outChr | tempCharFirst3;

      //uncomment the following to return the input character as the output
      //outChr = inChar;

      //last instruction in while loop
      putchar(outChr);
    }

  return 0;
}
