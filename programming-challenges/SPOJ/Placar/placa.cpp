 #include <map>
 #include <algorithm>
 #include <iostream>
 #include <string>
 #include <utility>
 #include <limits>

 using namespace std;

 int main(void){
    string nome, nomeReprovado;
    int instancia = 0, alunos, nota, menor_nota = 999;
    while ( cin >> alunos ){
        for ( int i = 0; i < alunos; i++){
            cin >> nome;
            cin >> nota;
            if(menor_nota > nota){
                menor_nota = nota;
                nomeReprovado = nome;
            }else if(menor_nota == nota){
                if ( nome > nomeReprovado) nomeReprovado = nome;
            }
        }
        cout << "Instancia " << ++instancia << endl;
        cout << nomeReprovado << endl;
        menor_nota = 999;
        nomeReprovado.clear();
        nome.clear();
    }
    return 0;
 }
