#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CANT_USUARIOS 20
#define LONGITUD 30

///Crear una función que busque dentro del arreglo de legajos y retorne la posición de un determinado valor.

void mostrarUsuarios(int *legajos, char nombres[][LONGITUD], int *anios, int cantidad){
    printf("-----Alumnos-----");
    for(int i = 0; i < cantidad; i++){
        printf("\n\nUsuario %d: \nNombre: %s \nLegajo: %d \nAnios: %d", i+1, nombres[i], legajos[i], anios[i]);
    }
}

int buscarUsuario(int *legajos, int cantidad) {
    int valorBuscado = 0;
    printf("\n\nIngrese el Legajo a buscar:");
    scanf("%d", &valorBuscado);
    int posicion = -1;

    for(int i = 0; i < cantidad; i++){
        if(valorBuscado == legajos[i]){
            posicion = i;
        }
    }

    return posicion;
}

int main()
{
    int legajos[CANT_USUARIOS]={213,123,231};
    char nombres[CANT_USUARIOS][LONGITUD]={"Raton Perez", "Julian Alvarez", "Daniel San"};
    int anios[CANT_USUARIOS]={131, 24, 17};
    int cantidad = 3;

    mostrarUsuarios(legajos, nombres, anios, cantidad);
    int posicion = buscarUsuario(legajos, cantidad);

    if(posicion == -1){
            printf("\nTe equivocaste perri\n");
    } else {
        printf("\nLa posicion del legajo es: %d\n", posicion);
    }

    return 0;
}
