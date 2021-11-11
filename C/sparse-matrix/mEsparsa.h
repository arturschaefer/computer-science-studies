#ifndef MESPARSA_H_INCLUDED
#define MESPARSA_H_INCLUDED

///CONSTANTES
#define MAX_BUFFER 1024 //BUFFER DO ARQUIVO DE ENTRADA
#define TAM 50

///ESTRUTURAS
typedef struct celula{
    int linha, coluna;
    float valor;
    struct celula *direita, *abaixo;
}TCel;

typedef struct mEsparsa{
    int m,n;
    TCel *inicio, *fimLinha, *fimColuna;
}TMatriz;

///FUNÇÕES

/*CABEÇALHOS*/
TMatriz *lerMatriz(char *nomeArquivo, TMatriz *M);
TMatriz *criaMatriz(int m, int n);
int tamanho_Arquivo(FILE *fp);
void inicia_Cabeca(TMatriz *M);
void insere_Cabeca_Coluna(TMatriz *M);
void insere_Cabeca_Linha(TMatriz *M);
int insereElemento(TMatriz *M, int linha, int coluna, float valor);
int imprimeMatriz(TMatriz *M);
TMatriz* freeMatriz(TMatriz *M);


/*CRIA MATRIZ*/
TMatriz *criaMatriz(int m, int n){
    TMatriz *M = (TMatriz*)malloc(sizeof(TMatriz));
    M->inicio = NULL;
    M->fimLinha = NULL;
    M->fimColuna = NULL;
    M->m = m;
    M->n = n;

    inicia_Cabeca(M);
    return M;
}

/*INICIA CABEÇA*/
void inicia_Cabeca(TMatriz *M){
    int i=0;
    TCel *head = (TCel*)malloc(sizeof(TCel));
    if (!head)
        exit(-4);
    head->coluna = -1;
    head->linha = -1;
    head->valor = 0;

    M->inicio = head;
    M->fimLinha = head;
    M->fimColuna = head;

    for (i = 1; i <= M->n; i++)
        insere_Cabeca_Coluna(M);
    for (i = 1; i <= M->m; i++)
        insere_Cabeca_Linha(M);
}

/*INICIA CABEÇA COLUNA*/
void insere_Cabeca_Coluna(TMatriz *M){
    TCel *head = (TCel*)malloc(sizeof(TCel));
    if (!head)
        exit(-4);

    head->coluna = -1;
    head->linha = 0;
    head->valor = 0;

    M->fimColuna->direita = head;
    M->fimColuna = head;

    head->direita = M->inicio;
    head->abaixo = head;
}

/*INICIA CABEÇA LINHA*/
void insere_Cabeca_Linha(TMatriz *M){
    TCel *head = (TCel*)malloc(sizeof(TCel));
    if (!head)
        exit(-4);

    head->coluna = 0;
    head->linha = -1;

    M->fimLinha->abaixo = head;
    M->fimLinha = head;

    head->abaixo = M->inicio;
    head->direita = head;
}

/*RETORNA TOTAL DE LINHAS DO ARQUIVO*/
int tamanho_Arquivo(FILE *fp){
    if(fp==NULL)
        return -1;
    int i=0;
    char linha[MAX_BUFFER];
    while (!feof(fp))
        if(fgets(linha,MAX_BUFFER, fp)!=NULL)//PEGA UM LINHA DO TAMANHO MÁXIMO DO BUFFER DECLARADO
            i++;
    rewind(fp);
    return i;
}

/*LEITURA DA MATRIZ POR ARQUIVO*/
TMatriz *lerMatriz(char *nomeArquivo, TMatriz *M){
    char *linha, *record;
    char *buffer[MAX_BUFFER];
    FILE *fpMatriz;

    int m=0, n=0;
    int l=0, c=0;
    float valor=0.0;

    fpMatriz = fopen(nomeArquivo,"r");
    if (!fpMatriz){
        fprintf(fpMatriz,"ERRO AO ABRIR ARQUIVO\n");
        exit(-1);
    }
    printf("\nTAMANHO DO ARQUIVO: %d\n",tamanho_Arquivo(fpMatriz)-1);
    linha=(fgets(buffer, sizeof(buffer),fpMatriz));
    m = atoi(record = strtok(linha,";"));
    n = atoi(record = strtok(NULL,"\n"));
    printf("\nLINHAS: %d \nCOLUNAS: %d\n", m, n);

    if (m<=0 || n<=0){
        printf("\nERRO: NUMERO DE LINHAS E/OU COLUNAS IGUAL OU MENORES QUE ZERO\n");
        exit(-2);
    }

    M = criaMatriz(m, n);
    printf("\nLINHA\tCOLUNA\tVALOR\n");
    while((linha=(fgets(buffer, sizeof(buffer),fpMatriz)))!=NULL){
        l = atoi (record = strtok(linha,";"));
        c = atoi(record = strtok(NULL,";"));
        valor = atof(record = strtok(NULL,"\0"));
        printf("%d\t%d\t%.2lf",l,c,valor);
        if (valor)
            insereElemento(M, l, c, valor);
        else
            printf("\t->VALOR IGUAL A ZERO, POR ISSO NÃO É INSERIDO");
        printf("\n");
    }
    fclose(fpMatriz);
    return M;
}

/*INSERE ELEMENTO NA MATRIZ*/
int insereElemento(TMatriz *M, int linha, int coluna, float valor){
    int i;
    if (!M || M->m <= 0 || M->n <= 0 || !valor)
        exit(-2);

    if (linha>M->m || coluna>M->n || !valor || linha < 1 || coluna < 1)
        exit(-3);

    TCel *pCelula, *pCelulaColuna, *pCelulaLinha;

    pCelula = (TCel*)malloc(sizeof(TCel));
    pCelula->linha = linha;
    pCelula->coluna = coluna;
    pCelula->valor = valor;
    pCelula->abaixo = NULL;
    pCelula->direita = NULL;

    pCelulaLinha = M->inicio->abaixo;
    pCelulaColuna = M->inicio->direita;

    /*PERCORRE LINHA E COLUNA*/
    for (i = 0; i < linha - 1; i++)
        pCelulaLinha = pCelulaLinha->abaixo;
    for (i = 0; i < coluna - 1; i++)
        pCelulaColuna = pCelulaColuna->direita;

    i=0;

    /*REALIZA LIGAÇÃO DE LINHAS*/
    while(i<coluna && pCelulaLinha->direita->linha != -1){
        if (pCelulaLinha->direita->coluna > pCelula->coluna){//INSERE A CELULA NO MEIO DA LINHA
            pCelula->direita = pCelulaLinha->direita;
            pCelulaLinha->direita = pCelula;
        }
        else if(pCelulaLinha->direita->coluna == pCelula->coluna && pCelulaLinha->direita->valor !=0)//ALTERA O VALOR DE UMA CÉLULA JÁ CRIADA
            pCelulaLinha->direita->valor = pCelula->valor;
        else
            pCelulaLinha = pCelulaLinha->direita;//FAZ PERCORRER A LISTA
        i++;
    }

    //REALIZA A LIGAÇÃO COM A CABEÇA DA LISTA
    if (pCelulaLinha->direita->linha == -1){
        pCelula->direita = pCelulaLinha->direita;
        pCelulaLinha->direita = pCelula;
    }

    i=0;
    /*REALIZA LIGAÇÃO NAS COLUNAS*/
    while (i<linha && pCelulaColuna->abaixo->coluna != -1){
        if (pCelulaColuna->abaixo->linha > pCelula->linha){//INSERE NO MEIO DA COLUNA
            pCelula->abaixo = pCelulaColuna->abaixo;
            pCelulaColuna->abaixo = pCelula;
        }
        else if(pCelulaColuna->abaixo->linha == pCelula->linha &&pCelulaColuna->abaixo->valor !=0)//ALTERA O VALOR DE UMA CÉLULA JÁ CRIADA
            pCelulaColuna->abaixo->valor = pCelula->valor;
        else
            pCelulaColuna = pCelulaColuna->abaixo;//FAZ PERCORRER A LISTA
        i++;
    }

    //REALIZA A LIGAÇÃO COM A CABEÇA DA LISTA
    if (pCelulaColuna->abaixo->coluna == -1){
        pCelula->abaixo = pCelulaColuna->abaixo;
        pCelulaColuna->abaixo = pCelula;
    }
    return 1;
}
/*FIM INSERE NA MATRIZ*/

/*IMPRIME MATRIZ*/
int imprimeMatriz(TMatriz *M){
    int i, j;
    TCel *pCelula;

    if (!M || !M->m || !M->n){
        printf("\nMATRIZ VAZIA");
        return 0;
    }

    pCelula = M->inicio->abaixo;

    printf("\n");
    for (i = 1; i <= M->m; i++){
        for (j = 1; j <= M->n; j++){
            if (pCelula->direita->linha == i && pCelula->direita->coluna == j){
                pCelula = pCelula->direita;
                printf("  \t%0.2f   ", pCelula->valor);
            }
            else
                printf("  \t%0.2f   ", 0.0F);
        }
        printf("\n");
        pCelula = pCelula->direita->abaixo;
    }
    system("pause");
    return 1;
}
/*FIM IMPRIME MATRIZ*/

/*APAGA MATRIZ*/
TMatriz *freeMatriz(TMatriz *M){
    int i = 1, j = 1;
    TCel *pCelula, *aux;

    pCelula = M->inicio->abaixo;
    pCelula = pCelula->direita;

    for (i = 1; i <= M->m; i++){
        for (j = 1; j <= M->n; j++){
            if (pCelula->linha == i && pCelula->coluna == j){
                aux = pCelula;
                pCelula = pCelula->direita;
                free(aux);
            }
        }
        pCelula = pCelula->abaixo->direita;
    }

    pCelula = M->inicio->direita;

    for (i = 0; i < M->n; i++){
        aux = pCelula;
        pCelula = pCelula->direita;
        free(aux);
    }

    pCelula = M->inicio->abaixo;
    for (i = 0; i < M->m; i++){
        aux = pCelula;
        pCelula = pCelula->abaixo;
        free(aux);
    }

    pCelula = M->inicio;
    free(pCelula);

    M->fimColuna = NULL;
    M->fimLinha = NULL;
    M->inicio = NULL;
    M->m = 0;
    M->n = 0;
    M = NULL;
    return M;
}
/*FIM APAGA MATRIZ*/
#endif // MESPARSA_H_INCLUDED
