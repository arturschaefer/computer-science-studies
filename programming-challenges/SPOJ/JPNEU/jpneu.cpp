#include <iostream>
 
using namespace std;

/*	http://br.spoj.com/problems/JPNEU/	*/
int main(void){
    int n, m;
    cin >> n >> m;
    if (n >= 1 && n <=40 && m >= 1 && m <=40)
        cout << (n - m) << endl;
    return 0;
}
