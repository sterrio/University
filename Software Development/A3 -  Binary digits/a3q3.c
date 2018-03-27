#include <stdio.h>
int main (void){
	int dig1,dig2,dig3,dig4,dig5,dig6,dig7,dig8,dig9;
	scanf("%d %d %d %d %d %d %d %d %d%", &dig1, &dig2, &dig3, &dig4, &dig5, 	&dig6, &dig7, &dig8, &dig9);

int number1 = (dig1 * 4) + (dig2 * 2) + (dig3 * 1);
int number2 = (dig4 * 4) + (dig5 * 2) + (dig6 * 1);
int number3 = (dig7 * 4) + (dig8 * 2) + (dig9 * 1);

printf("%d %d %d",number1,number2,number3);
	return 0;
}
