/* Stephen Terrio, B00755443 */
#include <stdio.h>
#include "coins.h"

void calculatecoins(int pennies){

  /* Delcaring all variables for change types */
  int dollars, quarters, dimes, nickels;

  /* Calculating amount, folllwed by saving the remaining change */
  dollars = pennies/100;
  pennies %= 100;

  /* quarters */
  quarters = pennies/25;
  pennies%=25;

  /* dimes */
  dimes = pennies/10;
  pennies %= 10;

  /* nickels */
  nickels = pennies/5;
  pennies %= 5;

  /* what's left is now stored in pennies and should be between 0 - 4 */

  /* printing output */
  printf("%d dollars, %d quarters, %d dimes, %d nickels, %d pennies\n", dollars, quarters, dimes, nickels, pennies);
}
