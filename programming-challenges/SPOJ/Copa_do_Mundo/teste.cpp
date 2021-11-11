#include <iostream>
#include <string>
#include <map>

using namespace std;

int main(){
    map<string, int> mapa_teste;
    string s;
    int id = 1, t;

    while(cin >> s){
        t = mapa_teste[s];
        if( t == 0){
            mapa_teste[s] = id;
            id++;
        }else   cout << mapa_teste[s] << endl;
    }
}
