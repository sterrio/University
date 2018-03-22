#include <stdio.h>

int main (void){

int option, left1 ,left2 ,right1 , right2, result1,result2,result3;
scanf("%d %d %d %d %d", &option, &left1,&left2,&right1,&right2);

if (option == 1){
  result1 = 0;
  result2 = left1 + right1;
  result3 = left2 + right2;
  }

if (option == 2){
  result1 = 0;
  result2 = left1 - right1;
  result3 = left2 - right2;
  }

if (option == 3){
  result1 = left1*right1;
  result2 = (left1*right2) + (left2*right1);
  result3 = left2*right2;
  }

printf("%d %d %d",result1,result2,result3);

}
