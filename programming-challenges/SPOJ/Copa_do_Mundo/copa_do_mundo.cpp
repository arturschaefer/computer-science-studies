#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <math.h>
 
using namespace std;
 
/*  CONTAR A QUANTIDADE DE EMPATES ENTRE OS "T" TIMES PARTICIPANDO, NAS
    N  PARTIDAS OCORRIDAS. FINALIZA A ENTRADA QUANDO T = 0
*/
int main(){
    int t, n, maxPontos, pontoAux, pontoLido;
    vector<string> times;
    string timeEntrada;
    cin >> t >> n;
    while (t != 0){
		pontoLido = 0;
		maxPontos = 3 * n;
		for (int i = 0; i < t; i++){
			cin >> timeEntrada;
			times.push_back(timeEntrada);
			cin >> pontoAux;
			pontoLido += pontoAux;
		}
		
		cout << (maxPontos - pontoLido) << endl;
		cin >> t >> n;
	}
    return 0;
}
 
