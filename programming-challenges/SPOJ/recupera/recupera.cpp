#include <iostream>
 
using namespace std;
/*	http://br.spoj.com/problems/RECUPERA/	*/
int main(void){
    int n, soma = 0, k, conta = 0, flag = 0;
    while (cin >> n){
        if (n >= 1 && n <=100){
            conta++;
            flag = 0;
            soma = 0;
            int vet[n];
            for (int i = 0; i < n; i++)
                cin >> vet[i];
 
            cout << "Instancia " << conta << endl;
            for (int i = 0; i < n; i++){
                if (soma == vet[i]){
                    cout << soma << endl;
                    flag = 1;
                    break;
                }else soma += vet[i];
            }
            if (flag == 0) cout << "nao achei" << endl;
        }else break;
    }
    return 0;
}
 
 
/* leia n
  soma = 0
  para i = 0 até n
  	leia k
  	se soma = k e está é a primeira vez que soma = k entao
  		imprima k
*/
