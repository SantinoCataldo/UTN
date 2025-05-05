#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LONGITUD 10
#define PALABRAS 4

///Hacer una funci�n (o varias) que ordene un arreglo de palabras por orden alfab�tico. (Por selecci�n o inserci�n, el que m�s te guste)

 

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
