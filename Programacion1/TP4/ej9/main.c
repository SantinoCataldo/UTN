#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LONGITUD 10
#define PALABRAS 4

///Hacer una funci�n que determine si un string se encuentra dentro de un arreglo de strings.
///La funci�n recibe el arreglo, la cantidad de palabras que contiene y la palabra a buscar.
///devuelve el �ndice de la fila en que se encuentra, de lo contrario retorna -1

int buscarPalabra(char palabras[][LONGITUD], int cantidad, char *buscada) {
    for (int i = 0; i < cantidad; i++) {
        if (strcmp(palabras[i], buscada) == 0) {
            return i;
        }
    }
    return -1;
}

void mostrarPalabras(char palabras[][LONGITUD]) {
    printf("Palabras cargadas:\n");
    for (int i = 0; i < PALABRAS; i++) {
        printf("%s\n", palabras[i]);
    }
}

int main()
{
    char palabras[PALABRAS][LONGITUD]={"ser","milanesa","sanguche", "papa"};
    char palabraBuscada[LONGITUD];
    int cantidad = PALABRAS;

    printf("Ingrese la palabra a buscar: ");
    scanf("%s", palabraBuscada);

    int indice = buscarPalabra(palabras, cantidad, palabraBuscada);
    mostrarPalabras(palabras);

    if(indice == -1){
        printf("\nLa palabra no se encuentra\n");
    } else {
        printf("\nLa palabra esta en el indice %d\n", indice);
    }

    return 0;
}
