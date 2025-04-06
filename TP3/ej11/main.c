#include <stdio.h>
#include <stdlib.h>

///Ordenar un array seg�n los siguientes m�todos:
///Selecci�n
///Inserci�n


void ordenarPorSeleccion(int *array, int tam) {
    for (int i = 0; i < tam - 1; i++) {
        int min = i;
        for (int j = i + 1; j < tam; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }
        if (min != i) {
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}

void ordenarPorInsercion(int *array, int tam) {
    for (int i = 1; i < tam; i++) {
        int actual = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > actual) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = actual;
    }
}

void mostrarArray(int array[], int tam) {
    for (int i = 0; i < tam; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

int main() {
    int array1[] = {5, 3, 8, 2, 1};
    int array2[] = {5, 3, 8, 2, 1};
    int tam = sizeof(array1) / sizeof(array1[0]);

    printf("Original:\n");
    mostrararray(array1, tam);

    ordenarPorSeleccion(array1, tam);
    printf("Ordenado por seleccion:\n");
    mostrarArray(array1, tam);

    ordenarPorInsercion(array2, tam);
    printf("Ordenado por insercion:\n");
    mostrarArray(array2, tam);

    return 0;
}
