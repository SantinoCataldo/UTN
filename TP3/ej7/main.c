#include <stdio.h>
#include <stdlib.h>

///Realizar una función que inserte un carácter en un arreglo ordenado alfabéticamente, conservando el orden.

void insertarValor (char *letra){
    printf("Ingrese la letra a ordenar: ");
    scanf("%c", letra);
}

void cargarValor(char *array, char letra){
    int i = 0, j = 0;
    while (array[i] != '\0' && array[i] < letra) i++;

    while (array[j] != '\n') j++;
    while (j >= i) {
        array[j + 1] = array[j];
        j--;
    }

    array[i] = letra;
}

int main()
{
    char letra;
    char array[50]= {'a','b','c','k','l','m','n','o','p','q','s','u','y','z'};

    insertarValor(&letra);


    for (int i = 0; i < 50; i++){
        printf("n%d: %c\n", i+1,  array[i]);
    }

    return 0;
}
