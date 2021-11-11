#include <stdio.h>
#include <stdlib.h>
 /*	http://br.spoj.com/problems/QUADRAD2/	*/
int main(){
    int n;
    scanf( "%d", &n );
    if ( n <= 10000 ){
        printf ( "%d" , n*n );
    }
    return 0;
}
