#include <stdio.h>
#include <stdlib.h>

///Dados dos arreglos ordenados alfab�ticamente,
///crear un tercer arreglo con los elementos de los dos primeros intercalados,
//de manera que quede un arreglo tambi�n ordenado alfab�ticamente.

void ordenarArrays(char *array1, char *array2, char *array3, int tam1, int tam2) {
    int i = 0, j = 0, k = 0;

    while (i < tam1 && j < tam2) {
        if (array1[i] < array2[j]) {
            array3[k++] = array1[i++];
        } else {
            array3[k++] = array2[j++];
        }
    }

    while (i < tam1) {
        array3[k++] = array1[i++];
    }

    while (j < tam2) {
        array3[k++] = array2[j++];
    }
}


void mostrarArray(char *array, int tam) {
    for (int i = 0; i < tam; i++) {
        printf("(%c) ", array[i]);
    }
    printf("\n");
}

int main()
{
    char array1[] = {'a','b','d','g','j'};
    char array2[] = {'c','e','f','i','n'};
    int tam1 = sizeof(array1);
    int tam2 = sizeof(array2);
    int tam3 = tam1 + tam2;
    char array3[tam3];

    ordenarArrays(array1, array2, array3, tam1, tam2);

    printf("Array combinado:\n\n");
    mostrarArray(array3, tam3);

    return 0;
}
