#include <stdio.h>

int main(){
    int binary,input;
    int in = scanf("%d", &input);
    int arr[20];

    int index;
    for (int i = 0; input > 0; i++){
        int bin = input % 2;
        arr[i] = bin;
        input = input/2;
        index = i;
    }

    while (index >= 0){
        printf("%d",arr[index]);
        index--;
    }
    printf("\n");
    return 0;
}