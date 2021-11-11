#include <iostream>
#include <string>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <map>
#include <utility>
#include <sstream>


#define NUM 21

using namespace std;

char *cria_str( int tam );
void cria_mapa ( map<char, int> &mapa);
bool is_prime(int n);

int main(){
    char *str, *ch;
    int i, j;
    map<char, int> map_val;
    map<char, int>::iterator map_iter;
    ostringstream oss;
    cria_mapa ( map_val );
    str = cria_str(NUM);
    ch = cria_str(2);
    while ( cin >> str){
        j = 0;
        if(strlen(str) >= 1 && strlen(str) <= 20){
            for ( i = 0; i < strlen(str); i++){
                ch[0] = str[i];
                //cout << "char " << ch << endl;
                map_iter = map_val.find(ch[0]);
                j += map_iter->second;
            }
            //cout << j << " ";
            if (is_prime(j))    cout << "It is a prime word." << endl;
            else cout << "It is not a prime word." << endl;
            free(str);
            str = cria_str(NUM);
        }
    }
    free(ch);
    return 0;
}

bool is_prime(int n) {
    if (n < 0) return is_prime(-n);
    if (n == 1) return true;
    if (n < 5 || n % 2 == 0 || n % 3 == 0)
        return (n == 2 || n == 3);
    int maxP = sqrt(n) + 2;
    for (int p = 5; p < maxP; p += 6)
        if (n % p == 0 || n % (p+2) == 0) return false;
    return true;
}

char *cria_str( int tam ){
    char *str = ( char* ) malloc ( tam * sizeof( char ) );
    return str;
}

void cria_mapa ( map<char, int> &mp){
    mp.insert(pair<char, int>('A', 27));
    mp.insert(pair<char, int>('B', 28));
    mp.insert(pair<char, int>('C', 29));
    mp.insert(pair<char, int>('D', 30));
    mp.insert(pair<char, int>('E', 31));
    mp.insert(pair<char, int>('F', 32));
    mp.insert(pair<char, int>('G', 33));
    mp.insert(pair<char, int>('H', 34));
    mp.insert(pair<char, int>('I', 35));
    mp.insert(pair<char, int>('J', 36));
    mp.insert(pair<char, int>('K', 37));
    mp.insert(pair<char, int>('L', 38));
    mp.insert(pair<char, int>('M', 39));
    mp.insert(pair<char, int>('N', 40));
    mp.insert(pair<char, int>('O', 41));
    mp.insert(pair<char, int>('P', 42));
    mp.insert(pair<char, int>('Q', 43));
    mp.insert(pair<char, int>('R', 44));
    mp.insert(pair<char, int>('S', 45));
    mp.insert(pair<char, int>('T', 46));
    mp.insert(pair<char, int>('U', 47));
    mp.insert(pair<char, int>('V', 48));
    mp.insert(pair<char, int>('W', 49));
    mp.insert(pair<char, int>('X', 50));
    mp.insert(pair<char, int>('Y', 51));
    mp.insert(pair<char, int>('Z', 52));
    mp.insert(pair<char, int>('a', 1));
    mp.insert(pair<char, int>('b', 2));
    mp.insert(pair<char, int>('c', 3));
    mp.insert(pair<char, int>('d', 4));
    mp.insert(pair<char, int>('e', 5));
    mp.insert(pair<char, int>('f', 6));
    mp.insert(pair<char, int>('g', 7));
    mp.insert(pair<char, int>('h', 8));
    mp.insert(pair<char, int>('i', 9));
    mp.insert(pair<char, int>('j', 10));
    mp.insert(pair<char, int>('k', 11));
    mp.insert(pair<char, int>('l', 12));
    mp.insert(pair<char, int>('m', 13));
    mp.insert(pair<char, int>('n', 14));
    mp.insert(pair<char, int>('o', 15));
    mp.insert(pair<char, int>('p', 16));
    mp.insert(pair<char, int>('q', 17));
    mp.insert(pair<char, int>('r', 18));
    mp.insert(pair<char, int>('s', 19));
    mp.insert(pair<char, int>('t', 20));
    mp.insert(pair<char, int>('u', 21));
    mp.insert(pair<char, int>('v', 22));
    mp.insert(pair<char, int>('w', 23));
    mp.insert(pair<char, int>('x', 24));
    mp.insert(pair<char, int>('y', 25));
    mp.insert(pair<char, int>('z', 26));
}
