#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIMENSION 3

///Hacer una función que muestre un arreglo de alumnos por pantalla. Modularizar.

typedef struct {
    int matricula;
    char nombre[30];
    char genero; //m, f, o
} stAlumno;

int cargarAlumno(stAlumno* alumnos){
    int i = 0;
    char continuar = 's';

    for (i = 0; i < DIMENSION; i++) {
        alumnos[i].matricula = i;
        strcpy(alumnos[i].nombre, "nombre");
        alumnos[i].genero = 'm';
    }

    return i;
}

void mostrarAlumno(stAlumno* alumnos, int cantidad){
    printf("\n--- Lista de alumnos cargados ---\n");
    for (int i = 0; i < cantidad; i++) {
        printf("Alumno %d:\n", i + 1);
        printf("Matricula: %d\n", alumnos[i].matricula);
        printf("Nombre: %s\n", alumnos[i].nombre);
        printf("Genero: %c\n\n", alumnos[i].genero);
    }
}

int main()
{
    stAlumno alumnos[DIMENSION];

    int cantidad = cargarAlumno(alumnos);
    mostrarAlumno(alumnos, cantidad);

    return 0;
}
