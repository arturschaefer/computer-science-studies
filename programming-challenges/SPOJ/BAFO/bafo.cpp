#include <stdio.h>
#include <iostream>
#include <string>
/*	http://br.spoj.com/problems/BAFO/ */
 
using namespace std;
 
int main(void){
		int r, i = 0, a, b, suma, sumb;
		string nome1 = "Aldo";
		string nome2 = "Beto";
		cin >> r;
		
		if( r > 1000 || r < 0) return 0;
		
		while (r != 0){
				suma = 0;
				sumb = 0;
				for( int j = 0; j < r; j++){
					
					cin >> a >> b;
					//cout << a << " " << b << endl;
					
					if(a < 0 || a > 100 || b < 0 || b > 100)
						continue;
					
					suma += a;
					sumb += b;
					
				}
				i++;
				cout << "Teste " << i << endl;
				if(suma >= sumb)
					cout << nome1 << endl;
				else
					cout << nome2 << endl;
				
				cout << endl; 
				cin >> r;
		}
				
		return 0;
}
