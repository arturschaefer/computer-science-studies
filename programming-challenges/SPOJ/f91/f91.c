#include <stdio.h>
#include <stdlib.h>

int f91(int num);
int main(void){
    int N, num_f91;
    do{
        scanf("%d", &N);
        if(N == 0)  break;
        num_f91 = f91(N);
        printf("f91(%d) = %d\n", N, num_f91);
    }while ( N != 0);
    return 0;
}

int f91(int num){
    if(num > 100) return num - 10;
    else return f91( f91 (num + 11));
}
