#include <stdio.h>

int main(){
    int value = 1;

    while (value < 1000000000){
        if (
        value % 1 == 0 &&
        value % 2 == 0 &&
        value % 3 == 0 &&
        value % 4 == 0 &&
        value % 5 == 0 &&
        value % 6 == 0 &&
        value % 7 == 0 &&
        value % 8 == 0 &&
        value % 9 == 0 &&
        value % 10 == 0 &&
        value % 11 == 0 &&
        value % 12 == 0 &&
        value % 13 == 0 &&
        value % 14 == 0 &&
        value % 15 == 0 &&
        value % 16 == 0 &&
        value % 17 == 0 &&
        value % 18 == 0 &&
        value % 19 == 0 &&
        value % 20 == 0){
            break;
        }else{
            value ++;
        }
    }
    printf("%d is the smallest integer evenly divisable by all numbers up to 20\n", value);

}