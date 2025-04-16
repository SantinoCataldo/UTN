#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LONGITUD 10
#define PALABRAS 4

///Hacer una función (o varias) que ordene un arreglo de palabras por orden alfabético. (Por selección o inserción, el que más te guste)

void ordenarPalabras(char palabras[][LONGITUD], int cantidad){
    for (int i = 0; i < cantidad - 1; i++) {
        int min = i;
        for (int j = i + 1; j < cantidad; j++) {
            if (strcmp(palabras[j], palabras[min]) < 0) {
                min = j;
            }
        }

        if (min != i) {
            char temp[LONGITUD];
            strcpy(temp, palabras[i]);
            strcpy(palabras[i], palabras[min]);
            strcpy(palabras[min], temp);
        }
    }
}

void mostrarPalabras(char palabras[][LONGITUD]) {
    for (int i = 0; i < PALABRAS; i++) {
        printf("%s\n", palabras[i]);
    }
}

int main()
{
    char palabras[PALABRAS][LONGITUD]={"manzana", "cebolla", "pera", "caramelo"};
    int cantidad = PALABRAS;

    printf("\n------DESORDENADAS-------\n\n");
    mostrarPalabras(palabras);

    ordenarPalabras(palabras, cantidad);
    printf("\n------ORDENADAS-------\n\n");
    mostrarPalabras(palabras);
    return 0;
}
