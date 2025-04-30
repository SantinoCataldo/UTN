#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIMENSION 100

///Hacer una función que cargue un arreglo de alumnos, hasta que el usuario lo decida.

typedef struct {
    int matricula;
    char nombre[30];
    char genero; //m, f, o
} stAlumno;

int cargarAlumno(stAlumno* alumnos){
    int cantidad = 0;
    char continuar = 's';

    while ((continuar == 's' || continuar == 'S') && cantidad < DIMENSION) {
        printf("---- Carga de Alumno %d ----\n", cantidad + 1);

        printf("Matricula: ");
        scanf("%d", &alumnos[cantidad].matricula);
        getchar();

        printf("Nombre: ");
        gets(alumnos[cantidad].nombre);

        printf("Genero (m/f/o): ");
        scanf(" %c", &alumnos[cantidad].genero);

        cantidad++;

        printf("\nQuiere ingresar otro alumno? (s/n): ");
        scanf(" %c", &continuar);

        printf("\n");
    }

    return cantidad;
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
