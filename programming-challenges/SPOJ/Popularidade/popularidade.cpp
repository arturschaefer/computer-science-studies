#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

int main(void){
    int n,i,j,**V;
    int maior_votos=0, indice=0 , cont=0;
    do{
        scanf("%d",&n);
        if(n!=0){
            V = (int**)malloc(n*sizeof(int*));
            for(i=0;i<n;i++)
                V[i] = (int*)malloc(n*sizeof(int));
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                    scanf("%d",&V[i][j]);

            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(V[j][i]==1)
                        cont++;
                }
                if(cont>maior_votos)
                    maior_votos = cont;
                cont=0;
            }

            for(i=0;i<n;i++)
                free(V[i]);
            free(V);
            printf("%d\n",maior_votos);
            maior_votos = 0;
        }
    }while(n!=0);
    return 0;
}
