#include <stdio.h>

int main(){
  // to store the inputs, and resulting value.
  int int1, int2, result;
  char op;
  int in = scanf("%d %c %d", &int1, &op, &int2);

  if (op == '+'){
    result = int1 + int2;
    printf("%d %c %d = %d\n",int1,op,int2,result);
  }else if(op == '-'){
    result = int1 - int2;
    printf("%d %c %d = %d\n",int1,op,int2,result);
  }else if(op == '*'){
    result = int1 * int2;
    printf("%d %c %d = %d\n",int1,op,int2,result);
  }else if(op == '/'){
    result = int1 / int2;
    printf("%d %c %d = %d\n",int1,op,int2,result);
  }else if(op == '%'){
    result = int1 % int2;
    printf("%d %c %d = %d\n",int1,op,int2,result);
  }else{
    printf("Incorrect input. Terminating\n");
    return 0;
  }

  return 0;
}
