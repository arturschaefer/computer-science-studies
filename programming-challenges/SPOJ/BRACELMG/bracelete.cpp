#include <iostream>
#include <string>
#include <string.h>
#include <algorithm>
 
using namespace std;
 
/*	http://br.spoj.com/problems/BRACELMG/	*/
bool resolve (string proibida, string bracelete);
 
int main(void){
	int t;
	string bracelete, proibida;
	cin >> t;
	for (int i = 0; i < t; ++i) {
		cin >> proibida >> bracelete;
		
		bracelete += bracelete;
	
		size_t found = bracelete.find(proibida);
		if (found!=string::npos) cout << "S" << endl;
		else {
			reverse(bracelete.begin(), bracelete.end());
			found = bracelete.find(proibida);
			if (found!=string::npos) cout << "S" << endl;
			else cout << "N" << endl;
		}
		
		/*bool existe = resolve(proibida, bracelete);
		cout << (existe? 'S' : 'N') << '\n';
		* */
	}
 
	return 0;
}
 
bool resolve (string proibida, string bracelete){
	bracelete += bracelete;
	
	size_t found = bracelete.find(proibida);
	if (found!=string::npos) return true;
	
	reverse(bracelete.begin(), bracelete.end());
	found = bracelete.find(proibida);
	if (found!=string::npos) return true;
	
	return false;
}
