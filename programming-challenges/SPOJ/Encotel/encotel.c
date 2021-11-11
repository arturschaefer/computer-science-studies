#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define NUM 20

/*  TROCAR NOME POR TELEFONE
    AO ENTRAR COM O PARAMETRO SEM O "<" COMO PARAMETRO, O CODIGO FUNCIONA
*/
char valor (char *str, int i);
char *cria_string ();
void libera_string (char *str);

int main(int argc, char *argv[]){
    char *leitura, *saida, ch;
    int i =0 , j = 0, tot_lin = 0, tot_entrada = 0;
    //printf("%d \n", argc);
    if ( argc <  1){
        return 1;
    }else{
        FILE *file = fopen( argv[1], "r" );
        if ( file == 0 ){
            return 1;
        }
        else{
            do{
                ch = fgetc(file);
                if(ch == '\n') tot_lin++;
            } while (ch != EOF);
            rewind(file);
            do{
                leitura = cria_string();
                saida = cria_string();
                fscanf(file, "%s", leitura);
                tot_entrada = strlen(leitura);
                for (j = 0; j < tot_entrada; j ++){
                    saida[j] = valor(leitura, j);
                }
                printf("%s\n", saida);
                i++;
                libera_string(saida);
                libera_string(leitura);
            }while(i < tot_lin);
        }
    }
    return 0;
}

char valor (char *str, int i){
    if (str[i] == 'A' || str[i] == 'B' || str[i] == 'C') return  '2';
    else if (str[i] == 'F' || str[i] == 'E' || str[i] == 'D') return  '3';
    else if (str[i] == 'G' || str[i] == 'H' || str[i] == 'I') return  '4';
    else if (str[i] == 'J' || str[i] == 'K' || str[i] == 'L') return  '5';
    else if (str[i] == 'O' || str[i] == 'N' || str[i] == 'M') return  '6';
    else if (str[i] == 'R' || str[i] == 'Q' || str[i] == 'P' || str[i] == 'S') return  '7';
    else if (str[i] == 'T' || str[i] == 'U' || str[i] == 'V') return  '8';
    else if (str[i] == 'W' || str[i] == 'X' || str[i] == 'Y' || str[i] == 'Z') return  '9';
    else return str[i];
}

char *cria_string (){
    char *str = (char*) malloc(NUM * sizeof(char));
    return str;
}

void libera_string (char *str){
    free(str);
    str = NULL;
}
