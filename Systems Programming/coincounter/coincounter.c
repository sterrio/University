#include <stdio.h>

int main(){

    int D, Q, M, N, P;
    int value;
    int in = scanf("%d", &value);

    if (value < 0){
        printf("Error: Outside of Range. Ending Program\n");
        return 0;
    }else if(value > 10000){
        printf("Error: Outside of Range. Ending Program\n");
        return 0;
    }
    D = value / 100;
    value = value - (D * 100);

    Q = value / 25;
    value = value - (Q * 25);

    M = value / 10;
    value = value - (M * 10);

    N = value / 5;
    value = value - (N * 5);

    P = value / 1;
    value = value - (N * 1);

    printf("%d dollars, %d quarters, %d dimes, %d nickles, %d pennies\n", D, Q, M, N, P);
    return 0;
}