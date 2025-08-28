#include <stdio.h>
#include <stdlib.h>

///Dado el vector {1,5,6,7,8} escribir un programa que genere otro vector con la suma del contenido de todo
//los elementos anteriores al índice actual: {1,6,12,19,27}

void sumarArray(int *array1, int *arraySuma, int tam){
    for(int i = 0; i < tam; i++){
        int valor = i;
        for(int j = 0; j <= valor; j++){
            arraySuma[i] += array1[j];
        }
    }
}

void mostrarArray(int *array, int tam) {
    for (int i = 0; i < tam; i++) {
        printf("(%d) ", array[i]);
    }
    printf("\n");
}

int main()
{
    int array1[] = {1,5,6,7,8};
    int tam = sizeof(array1) / sizeof(array1[0]);
    int arraySuma[] = {0,0,0,0,0};

    sumarArray(array1, arraySuma, tam);

    printf("Original:\n");
    mostrarArray(array1, tam);

    printf("\nSumado:\n");
    mostrarArray(arraySuma, tam);

    return 0;
}
