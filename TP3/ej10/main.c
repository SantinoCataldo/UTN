#include <stdio.h>
#include <stdlib.h>
///Realizar una función que invierta los elementos de un arreglo.(sin utilizar un arreglo auxiliar)

void cargarAleatorio(int *enteros, int maxValores){
    int num = 0;
    for (int i = 0; i < maxValores; i++){
        num = rand() % 11 + 1;
        enteros[i] = num;
    }
}

void invertir(int *enteros, int maxValores){
    for(int i = 0; i < 2; i++){
        enteros[maxValores - 1 - i] = enteros[i];
    }
}

int main()
{
    srand(time(NULL));
    int maxValores = 4;
    int enteros[maxValores];

    cargarAleatorio(enteros, maxValores);

    for(int i = 0; i < maxValores; i++){
        printf("%d, ", enteros[i]);
    }

    invertir(enteros, maxValores);
    printf("\n\n");

    for(int i = 0; i < maxValores; i++){
        printf("%d, ", enteros[i]);
    }

    return 0;
}
