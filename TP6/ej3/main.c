#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIMENSION 3

///Hacer una función que muestre por pantalla los datos de un alumno, conociendo su matrícula. Modularizar

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

void bucarMatriculaAlumno(stAlumno* alumnos, int cantidad){
    int matriculaBuscar, flag;

    printf("Ingrese la matricula del alumno a buscar: ");
    scanf("%d", &matriculaBuscar);

    for (int i = 0; i < cantidad; i++) {
        if(matriculaBuscar == alumnos[i].matricula){
            printf("\nAlumno %d:\n", i + 1);
            printf("Matricula: %d\n", alumnos[i].matricula);
            printf("Nombre: %s\n", alumnos[i].nombre);
            printf("Genero: %c\n\n", alumnos[i].genero);
            flag = 1;
            break;
        }
        else {
            flag = 0;
        }
    }

    if (flag == 0){
        printf("\nNo se encontro el usuario\n\n");
    }
}

int main()
{
    stAlumno alumnos[DIMENSION];

    int cantidad = cargarAlumno(alumnos);
    bucarMatriculaAlumno(alumnos, cantidad);

    return 0;
}
