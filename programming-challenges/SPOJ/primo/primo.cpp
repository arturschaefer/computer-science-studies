#include <iostream>
#include <math.h>

/*	http://br.spoj.com/problems/PRIMO/	*/
using namespace std;
 
bool is_prime(int n);
 
int main(void){
    int n;
    cin >> n;
    if (n < 0) n = n * -1;
    if (is_prime(n) == true) cout << "sim" << endl;
    else cout << "nao" << endl;
    return 0;
}
 
bool is_prime(int n){
 
    if (n < 0) return is_prime(-n);
    if (n < 5 || n % 2 == 0 || n % 3 == 0) return (n == 2 || n == 3);
    int maxP = sqrt(n) + 2;
    for (int p = 5; p < maxP; p +=6)
        if (n % p == 0 || n % (p + 2) == 0 ) return false;
    return true;
}
