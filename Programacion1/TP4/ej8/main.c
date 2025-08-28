#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LONGITUD 10
#define PALABRAS 3

///Hacer una función que muestre un arreglo de palabras.

void mostrarPalabras(char palabras[][LONGITUD]) {
    printf("Palabras cargadas:\n");
    for (int i = 0; i < PALABRAS; i++) {
        printf("%s\n", palabras[i]);
    }
}

int main() {
    char palabras[PALABRAS][LONGITUD]={"ser","milanesa","sanguche"};

    mostrarPalabras(palabras);

    return 0;
}
