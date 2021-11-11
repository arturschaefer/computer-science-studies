#include <iostream>
using namespace std;

/*	http://br.spoj.com/problems/SOMA/	*/
int main ( ) {
    int N, sum = 0, aux;
    cin >> N;
 
    while ( N !=0 ){
        cin >> aux;
        sum += aux;
        N--;
    }
    cout << sum << endl;
    return 0;
}
