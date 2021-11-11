#include <stdio.h>

/*	http://br.spoj.com/problems/FATORIA2/	*/
int main(){
	int n, i, fat = 1 ;
	scanf("%d",&n);
	if( n < 0 || n > 12){
		return 0;
	}
	if(n == 0){
		printf("%d\n",1);
		return 0;
	}
		
	for ( i = 1; i <= n; i++){
		fat *= i;
	}
	printf("%d\n",fat);
	return 0;
}
