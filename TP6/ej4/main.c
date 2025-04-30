#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define DIMENSION 3

///Hacer una función que ordene el arreglo de alumnos por medio del método de selección. El criterio de ordenación es el número de matrícula.

typedef struct {
    int matricula;
    char nombre[30];
    char genero; //m, f, o
} stAlumno;

int cargarAlumno(stAlumno* alumnos){
    int i = 0;
    char continuar = 's';

    for (i = 0; i < DIMENSION; i++) {
        alumnos[i].matricula = rand()%11;
        strcpy(alumnos[i].nombre, "nombre");
        alumnos[i].genero = 'm';
    }

    return i;
}

void ordenarMatriculaAlumnos(stAlumno *alumnos, int cantidad){
    for(int i = 0; i < cantidad; i++){
       int min = i;
       for(int j = i + 1; j < cantidad; j++){
            if(alumnos[j].matricula < alumnos[i].matricula){
                min = j;
            }
       }

       if(min != i){
            stAlumno aux = alumnos[i];
            alumnos[i] = alumnos[min];
            alumnos[min] = alumnos[i];
       }
    }
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
    srand(time(NULL));
    stAlumno alumnos[DIMENSION];

    int cantidad = cargarAlumno(alumnos);
    ordenarMatriculaAlumnos(alumnos, cantidad);
    mostrarAlumno(alumnos, cantidad);

    return 0;
}
