#include <cstdlib>
#include <iostream>
 
using namespace std;

/*	http://br.spoj.com/problems/ODDOREVE/	*/ 
int main() {
	int N, V, joao, maria;
	while ( cin >> N && N) {
		joao  = maria = 0;
		for ( int i = 0; i < N; i++) {
			cin >> V;
			if ( !( V%2 ) )	maria++;
		}
		for ( int i = 0; i < N; i++) {
			cin >> V;
			if ( V%2 ) joao++;
		}
		cout << abs ( joao - maria ) << endl;
	}
 
	return 0;
}
