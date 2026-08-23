#include <stdio.h>

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    
    // This does not affect the original variables
    // because a and b are copies, not addresses.
}


int main(){
    int a = 2;
    int b = 7;

    printf("Before swap: x = %d, b = %d\n", a, b);
    swap(&a, &b);
    printf("After swap: x = %d, b = %d\n", a, b);

    int x = 10;
    int y = 20;

    printf("\nBefore broken_swap: x = %d, y = %d\n", x, y);
    broken_swap(x, y);
    printf("After broken_swap: x = %d, y = %d\n", x, y);

    return 0;
}