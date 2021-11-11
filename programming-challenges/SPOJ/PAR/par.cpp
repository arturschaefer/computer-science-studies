#include <iostream>
#include <string>
/*	http://br.spoj.com/problems/PAR/	*/
using namespace std;
 
int main(void){
    int n, jogada1, jogada2, conta = 0;
    string nome1, nome2;
 
    cin >> n;
    if (n > 1000 || n < 0) return 0;
    while (n != 0){
        cin >> nome1 >> nome2;
 
        if(nome1.size() <= 10 && nome2.size() <= 10 && nome1.size() >= 1 && nome2.size() >= 1){
            conta++;
            cout << "Teste " << conta;
            for (int i = 0; i < n; i++){
                cin >> jogada1 >> jogada2;
 
                //RESTRICOES
                if(jogada1 > 5 || jogada1 < 0 || jogada2 > 5 || jogada2 < 0) continue;
 
                //TESTE DE PAR/IMPAR
                if((jogada1 + jogada2) % 2 == 0) cout << "\n" << nome1;
                else cout << "\n" <<nome2;
            }
            cin >> n;
            if (n > 1000 || n < 0) return 0;
            if (n == 0) return 0;
            cout << "\n\n";
        }
    }
    return 0;
}
