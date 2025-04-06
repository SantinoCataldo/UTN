#include <stdio.h>
#include <stdlib.h>

/// Realizar una función que inserte un carácter en un arreglo ordenado alfabéticamente, conservando el orden.
void insertarValor(char *letra) {
    printf("Ingrese la letra a ordenar: ");
    scanf(" %c", letra);
}

void cargarValor(char *array, int *tamano, char letra) {
    int i = 0;

    while (i < *tamano && array[i] < letra) {
        i++;
    }

    for (int j = *tamano; j > i; j--) {
        array[j] = array[j - 1];
    }

    array[i] = letra;
    (*tamano)++;
}

int main() {
    char letra;
    char array[] = {'a', 'b', 'c', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 's', 'u', 'y', 'z'};
    int tamano = sizeof(array);

    insertarValor(&letra);
    cargarValor(array, &tamano, letra);

    printf("\nArreglo actualizado:\n");
    for (int i = 0; i < tamano; i++) {
        printf("n%d: %c\n", i + 1, array[i]);
    }

    return 0;
}
