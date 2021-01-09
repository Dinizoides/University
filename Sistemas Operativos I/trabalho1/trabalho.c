#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "queue.c"

#define Quantum 3
#define SIZE 1000
#define nomeficheiro "input1.txt"

struct Processo{
    int sequencia[SIZE];
    int quantidadesequencia;
    int pid;
    int inicio;
};


// função que conta linhas do ficheiro:

int contalinhas(char nome[SIZE]){
    FILE *f;
    int linhas=1;
    char a;
    if((f=fopen(nome,"r")) == NULL)
        exit(1);
    for (a=getc(f); a!=EOF; a=getc(f)){
        if (a == '\r')
            linhas+=1;
    }
    fclose(f);
    return linhas;
}


// função que le o input e coloca tudo na struct:

void lerinput(int linhas, struct Processo array[linhas], FILE *f){
    char line[SIZE], cut[SIZE];
    int linha=0;
    while ( fgets(line, sizeof(line), f) != NULL ){
        int inicio=0, nnumeros=0, s=0;
        for(int i=0; i<strlen(line); i++){
            if(!(line[i]==' ' && line[i+1]==' ')){
                if(line[i]==' ' || (line[i]=='\n' && line[i-2]!=' ')){
                    memset(cut, '\0', sizeof(cut));
                    if(nnumeros<=1){
                        if(nnumeros<1){
                            strncpy(cut, line, i);
                            array[linha].pid = atoi(cut);
                        }else{
                            strncpy(cut, line+inicio, i);
                            array[linha].inicio = atoi(cut);
                        }
                    }else{
                        strncpy(cut, line+inicio, i);
                        array[linha].sequencia[s] = atoi(cut);
                        s+=1;
                    }
                    inicio = i;
                    nnumeros+=1;
                }
            }
        }
        array[linha].quantidadesequencia = s;
        linha+=1;
    }
} 


// função que abre ficheiro e depende de lerinput:

void openfileteste(int linhas, struct Processo array[linhas], char nome[SIZE]){
    FILE *f;
    if((f = fopen(nome,"r")) == NULL)
        exit(1);
    lerinput(linhas, array, f);
}


// função que retira o primeiro elemento de um array:

void retirarprimeiro(int array[], int *arraysize){
    for(int i=0; i<*arraysize-1; i++)
        array[i]=array[i+1];
    *arraysize-=1;
}

// função que coloca na fila ready se o instante for igual ao inicio do processo:

void inicio_ready(int linhas, struct Processo array[linhas], int instante, struct Queue* ready, int *times){
    if(*times>0){
        for(int i=0; i<linhas; i++){
            if(array[i].inicio == instante){
                enQueue(ready,i);
                *times-=1;
            }
        }
    }
}

//função que retira da fila blocked e coloca na fila ready se o tempo no blocked acabar:

void blocked_ready(int linhas, struct Processo array[linhas], struct Queue* ready, struct Queue* blocked){
    int j = SizeQueue(blocked); // pois o size pode alterar a meio do processo;
    for(int i=0; i<j; i++){
        int x = deQueue(blocked);
        array[x].sequencia[0]--;
        if(array[x].sequencia[0] == 0){
            retirarprimeiro(array[x].sequencia, &array[x].quantidadesequencia);
            enQueue(ready, x);
        }else
            enQueue(blocked, x);
    }
}


//função que executa os prints do programa:

void prints(int linhas, struct Processo array[linhas], int instante, struct Queue* ready, struct Queue* run, struct Queue* blocked){
    printf("%d | READY ", instante);
    for(int i=0; i<SizeQueue(ready); i++){
        int x = deQueue(ready);
        printf("%d ", array[x].pid);
        enQueue(ready, x);
    }
    printf("| RUN ");
    if(SizeQueue(run)>0)
        printf("%d ", array[inicio(run)].pid);
    printf("| BLOCKED ");
    for(int i=0; i<SizeQueue(blocked); i++){
        int y = deQueue(blocked);
        printf("%d ", array[y].pid);
        enQueue(blocked, y);
    }
    printf("\n");
}



// função que executa (vezes) ciclos de escalonamento:

void ciclo(int linhas, struct Processo array[linhas], struct Queue* ready, struct Queue* run, struct Queue* blocked, int *instante, int *readytimes, int vezes){
    for(int i=0; i<vezes; i++){
        prints(linhas, array, *instante, ready, run, blocked);
        *instante+=1;
        inicio_ready(linhas, array, *instante, ready, readytimes);
        blocked_ready(linhas, array, ready, blocked);
    }
}



//função que executa o processo global do programa em relação ao algoritmo de  FCFS e Round Robin e depende de muitas funçoes chamadas antes desta: 

void execucao(int linhas, struct Processo array[linhas]){
    int instante=0, readytimes=linhas;

    struct Queue* ready = createQueue(linhas);
    struct Queue* run = createQueue(1);
    struct Queue* blocked = createQueue(linhas);

    inicio_ready(linhas, array, instante, ready, &readytimes);

    while(SizeQueue(ready)==0){
        instante++;
        inicio_ready(linhas, array, instante, ready, &readytimes);
    }

    while(SizeQueue(ready)>0 || SizeQueue(run)>0 || SizeQueue(blocked)>0){
        if(SizeQueue(ready)>0){
            enQueue(run, deQueue(ready));
            if(array[inicio(run)].sequencia[0]>Quantum && Quantum>0){
                ciclo(linhas, array, ready, run, blocked, &instante, &readytimes, Quantum);
                array[inicio(run)].sequencia[0]-=Quantum;
                enQueue(ready, deQueue(run));
            }else if(array[inicio(run)].quantidadesequencia != 1){
                ciclo(linhas, array, ready, run, blocked, &instante, &readytimes, array[inicio(run)].sequencia[0]);
                retirarprimeiro(array[inicio(run)].sequencia, &array[inicio(run)].quantidadesequencia);
                enQueue(blocked, deQueue(run));
            }else{
                ciclo(linhas, array, ready, run, blocked, &instante, &readytimes, array[inicio(run)].sequencia[0]);
                retirarprimeiro(array[inicio(run)].sequencia, &array[inicio(run)].quantidadesequencia);
                deQueue(run);
            }
        }else
            ciclo(linhas, array, ready, run, blocked, &instante, &readytimes, 1);
    }
}


//main:

int main(){

    int linhas = contalinhas(nomeficheiro);
    struct Processo array[linhas];
    openfileteste(linhas, array, nomeficheiro);
    
    /*
    //Caso haja a necessidade de confirmar os valores que são recebidos:

    for(int i=0; i<linhas; i++){
        printf("%d %d", array[i].pid, array[i].inicio);
        for(int j=0; j<array[i].quantidadesequencia; j++)
            printf(" %d", array[i].sequencia[j]);
        printf("\n");
    }
    */

    execucao(linhas, array);
    
    return 0;
}