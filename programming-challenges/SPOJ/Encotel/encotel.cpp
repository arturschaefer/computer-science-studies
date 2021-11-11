#include <iostream>
#include <string>
#include <string.h>
#include <map>
#include <utility>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

/*  TROCAR NOME POR TELEFONE

*/
void preencer_map ( map<string, int> &mp);
char valor (char str);
char *cria_string ( int tam );
void libera_string (char *str);

int main(){
    string completo;
    char *saida;
    char c;
    while ( cin >> completo ){
        saida = cria_string(completo.size());
        for (int i = 0; i < completo.size(); i++){
            saida[i] = valor ( completo[i] );
            if( i == completo.size()-1){
                saida[i+1] = '\0';
            }
        }

        cout << saida << endl;
        //free(saida);
        saida = NULL;
        completo.clear();
        // cout << saida << endl;
    }
    free(saida);
    completo.erase();
    return 0;
}

char valor (char str){
    if (str == 'A' || str == 'B' || str == 'C') return  '2';
    else if (str == 'F' || str == 'E' || str == 'D') return  '3';
    else if (str == 'G' || str == 'H' || str == 'I') return  '4';
    else if (str == 'J' || str == 'K' || str == 'L') return  '5';
    else if (str == 'O' || str == 'N' || str == 'M') return  '6';
    else if (str == 'R' || str == 'Q' || str == 'P' || str == 'S') return  '7';
    else if (str == 'T' || str == 'U' || str == 'V') return  '8';
    else if (str == 'W' || str == 'X' || str == 'Y' || str == 'Z') return  '9';
    else return str;
}

char *cria_string ( int tam ){
    char *str = ( char* ) malloc( tam * sizeof(char));
    return str;
}

void libera_string (char *str){
    free(str);
    str = NULL;
}

void preencer_map ( map<string, int> &mp){
    mp.insert(pair<string, int>("A", 2));
    mp.insert(pair<string, int>("B", 2));
    mp.insert(pair<string, int>("C", 2));
    mp.insert(pair<string, int>("D", 3));
    mp.insert(pair<string, int>("E", 3));
    mp.insert(pair<string, int>("F", 3));
    mp.insert(pair<string, int>("G", 4));
    mp.insert(pair<string, int>("H", 4));
    mp.insert(pair<string, int>("I", 4));
    mp.insert(pair<string, int>("J", 5));
    mp.insert(pair<string, int>("K", 5));
    mp.insert(pair<string, int>("L", 5));
    mp.insert(pair<string, int>("M", 6));
    mp.insert(pair<string, int>("N", 6));
    mp.insert(pair<string, int>("O", 6));
    mp.insert(pair<string, int>("P", 7));
    mp.insert(pair<string, int>("Q", 7));
    mp.insert(pair<string, int>("S", 7));
    mp.insert(pair<string, int>("T", 8));
    mp.insert(pair<string, int>("U", 8));
    mp.insert(pair<string, int>("V", 8));
    mp.insert(pair<string, int>("W", 9));
    mp.insert(pair<string, int>("X", 9));
    mp.insert(pair<string, int>("Y", 9));
    mp.insert(pair<string, int>("Z", 9));
}
