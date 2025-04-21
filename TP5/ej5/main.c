#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LONGITUD 30
#define CANT_USUARIOS 20

///Hacer una función que reciba como parámetro todos los arreglos y los ordene por nombre. (por el método de selección o inserción).

void mostrarArreglos(int *legajos, char nombres[][LONGITUD], int *anios, int cantidad){
    for(int i = 0; i < cantidad; i++){
        printf("Nombre: %s \nLegajo: %d \nAnios: %d\n\n", nombres[i], legajos[i], anios[i]);
    }
}

void ordenarPorNombre(int legajos[], char nombres[][LONGITUD], int anios[], int cantidad) {
    for (int i = 0; i < cantidad - 1; i++) {
        int min = i;
        for (int j = i + 1; j < cantidad; j++) {
            if (strcmp(nombres[j], nombres[min]) < 0) {
                min = j;
            }
        }

        if (min != i) {
            char tempNombre[LONGITUD];
            strcpy(tempNombre, nombres[i]);
            strcpy(nombres[i], nombres[min]);
            strcpy(nombres[min], tempNombre);

            int tempLegajo = legajos[i];
            legajos[i] = legajos[min];
            legajos[min] = tempLegajo;

            int tempAnio = anios[i];
            anios[i] = anios[min];
            anios[min] = tempAnio;
        }
    }
}


int main()
{
    int legajos[CANT_USUARIOS]={213,123,231};
    char nombres[CANT_USUARIOS][LONGITUD]={"Raton Perez", "Julian Alvarez", "Daniel San"};
    int anios[CANT_USUARIOS]={131, 24, 17};
    int cantidad = 3;


    printf("----ANTES----\n");
    mostrarArreglos(legajos, nombres, anios, cantidad);
    ordenarPorNombre(legajos, nombres, anios, cantidad);

    printf("----DESPUES----\n");
    mostrarArreglos(legajos, nombres, anios, cantidad);

    return 0;
}
