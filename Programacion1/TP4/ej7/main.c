#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_PALABRAS 10
#define MAX_LONGITUD 50

///Hacer una función que cargue un arreglo de palabras (strings).
///La función debe retornar cuantas palabras se cargaron.
///(puede ser a través del parámetro como puntero).


int cargarPalabras(char palabras[][MAX_LONGITUD]) {
    char seguir = 's';
    int i = 0;

    while (seguir == 's' && i < MAX_PALABRAS) {
        printf("Ingrese una palabra: ");
        scanf("%s", palabras[i]);

        i++;

        if (i < MAX_PALABRAS) {
            printf("Desea ingresar otra palabra? (s/n): ");
            fflush(stdin);
            scanf(" %c", &seguir);
        }
    }

    return i;
}

int main() {
    char palabras[MAX_PALABRAS][MAX_LONGITUD];
    int cantidad = cargarPalabras(palabras);

    printf("\nTotal de palabras cargadas: %d\n", cantidad);

    return 0;
}
