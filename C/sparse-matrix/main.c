#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <time.h>

/** DESCRIÇÃO:  MATRIZ ESPARSA DE LISTAS CIRCULARES
    AUTOR:      ARTUR SCHAEFER, PAULO HENRIQUE "GANSO"
    DATA, HORA: 06/07/2015, 08:01
*/

//TAD
#include "mEsparsa.h"

int main(){
    setlocale(LC_ALL, "Portuguese");
    char nome_Arquivo[TAM];
    TMatriz *M;

    strcpy(nome_Arquivo, "matriz01.txt");

    M = lerMatriz(nome_Arquivo,M);
    imprimeMatriz(M);
    M = freeMatriz(M);
    if(M==NULL)
        printf("\n\n->MATRIZ APAGADA COM SUCESSO\n\n");
    return 0;
}

///----------|  LEGENDA DE ERROS    |------------------------
/** -1  ABERTURA DO ARQUIVO
    -2  LINHAS E/OU COLUNAS INVÁLIDAS [MENOR OU IGUAL A ZERO]
    -3  LINHA PARA INSERÇÃO INVÁLIDA
    -4  ERRO DE CRIAR CABEÇA
*/

