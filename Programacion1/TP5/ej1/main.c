#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CANT_USUARIOS 20
#define LONGITUD 30

///Crear una función que los cargue, hasta que el usuario lo decida

void cargaUsuarios(int *legajo, char nombres[][LONGITUD], int *anios){
    char seguir = 's';
    int i = 0;

    while (seguir == 's' && i < CANT_USUARIOS) {
        printf("ALUMNO %d\n", i+1);

        printf("Ingrese el nombre del alumno: ");
        fflush(stdin);
        gets(nombres[i]);

        printf("Ingrese el legajo: ");
        scanf("%d", &legajo[i]);

        printf("Ingrese los anios que tiene: ");
        scanf("%d", anios[i]);

        i++;

        if (i < CANT_USUARIOS) {
            printf("Desea ingresar otra palabra? (s/n): ");
            fflush(stdin);
            scanf(" %c", &seguir);
        }
    }
}

int main()
{
    int legajos[CANT_USUARIOS];
    char nombres[CANT_USUARIOS][LONGITUD];
    int anios[CANT_USUARIOS];

    cargaUsuarios(legajos, nombres, anios);
    return 0;
}
