#include <iostream>
 
using namespace std;
/*	http://br.spoj.com/problems/OVERF09/ */
void compara (int mem, int lido);
 
int main(void){
    int n, p, q;
    char c;
    cin >> n >> p >> c >> q;
 
    if (n >= 1 && n <= 500000 && p >= 0 && p <= 1000 && q >= 0 && q <= 1000){
        switch(c){
            case '+':
                compara (n, (p + q));
                break;
            case '*':
                compara (n, (p * q));
                break;
            default:
                break;
        }
    }
 
    return 0;
}
 
 
void compara (int mem, int lido){
    if (lido > mem) cout << "OVERFLOW" << endl;
    else cout << "OK" << endl;
}
