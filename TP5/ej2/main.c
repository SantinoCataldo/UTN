#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CANT_USUARIOS 20
#define LONGITUD 30

///Mostrar por pantalla los 3 arreglos pero de a un “registro” o alumno por vez
///(es decir: muestra el legajo, nombre y años del 1er alumno, luego el legajo, nombre y años del 2do alumno, y así sucesivamente)

void MostrarUsuarios(int *legajos, char nombres[][LONGITUD], int *anios, int cantidad){
    printf("-----Alumnos-----");
    for(int i = 0; i < cantidad; i++){
        printf("\n\nUsuario %d: \nNombre: %s \nLegajo: %d \nAnios: %d", i+1, nombres[i], legajos[i], anios[i]);
    }
}

int main()
{
    int legajos[CANT_USUARIOS]={213,123,231};
    char nombres[CANT_USUARIOS][LONGITUD]={"Raton Perez", "Julian Alvarez", "Daniel San"};
    int anios[CANT_USUARIOS]={131, 24, 17};
    int cantidad = 3;

    MostrarUsuarios(legajos, nombres, anios, cantidad);

    return 0;
}
