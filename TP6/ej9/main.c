#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIMENSION 10

typedef struct {
    int matricula;
    char nombre[30];
    char genero; // m, f, o
} stAlumno;

// 1. Cargar alumnos
int cargarAlumno(stAlumno* alumnos) {
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

// 2. Mostrar todos los alumnos
void mostrarAlumno(stAlumno* alumnos, int cantidad) {
    printf("\n--- Lista de alumnos cargados ---\n");
    for (int i = 0; i < cantidad; i++) {
        printf("Alumno %d:\n", i + 1);
        printf("Matricula: %d\n", alumnos[i].matricula);
        printf("Nombre: %s\n", alumnos[i].nombre);
        printf("Genero: %c\n\n", alumnos[i].genero);
    }
}

// 3. Buscar un alumno por matrícula
void buscarMatriculaAlumno(stAlumno* alumnos, int cantidad) {
    int matriculaBuscar, flag = 0;

    printf("Ingrese la matricula del alumno a buscar: ");
    scanf("%d", &matriculaBuscar);

    for (int i = 0; i < cantidad; i++) {
        if (matriculaBuscar == alumnos[i].matricula) {
            printf("\nAlumno encontrado:\n");
            printf("Matricula: %d\n", alumnos[i].matricula);
            printf("Nombre: %s\n", alumnos[i].nombre);
            printf("Genero: %c\n\n", alumnos[i].genero);
            flag = 1;
            break;
        }
    }

    if (flag == 0) {
        printf("\nNo se encontro el alumno\n\n");
    }
}

// 4. Ordenar alumnos por matrícula (método de selección)
void ordenarMatriculaAlumnos(stAlumno *alumnos, int cantidad) {
    for (int i = 0; i < cantidad - 1; i++) {
        int min = i;
        for (int j = i + 1; j < cantidad; j++) {
            if (alumnos[j].matricula < alumnos[min].matricula) {
                min = j;
            }
        }

        if (min != i) {
            stAlumno aux = alumnos[i];
            alumnos[i] = alumnos[min];
            alumnos[min] = aux;
        }
    }
}

// 5. Mostrar alumnos por género
void buscarGenero(stAlumno* alumnos, int cantidad, char generoBuscar) {
    int flag = 0;

    for (int i = 0; i < cantidad; i++) {
        if (generoBuscar == alumnos[i].genero) {
            printf("\nAlumno encontrado:\n");
            printf("Matricula: %d\n", alumnos[i].matricula);
            printf("Nombre: %s\n", alumnos[i].nombre);
            printf("Genero: %c\n\n", alumnos[i].genero);
            flag = 1;
        }
    }

    if (flag == 0) {
        printf("\nNo se encontraron alumnos de ese género\n\n");
    }
}

// 6. Insertar un nuevo alumno en un arreglo ordenado por matrícula
void insertarOrdenadoPorMatricula(stAlumno *alumnos, int *cantidad, stAlumno nuevo) {
    int i = *cantidad - 1;
    while (i >= 0 && alumnos[i].matricula > nuevo.matricula) {
        alumnos[i + 1] = alumnos[i];
        i--;
    }

    alumnos[i + 1] = nuevo;
    (*cantidad)++;
}

// 7. Ordenar por nombre (método de inserción)
void ordenarPorNombreInsercion(stAlumno *alumnos, int cantidad) {
    for (int i = 1; i < cantidad; i++) {
        stAlumno actual = alumnos[i];
        int j = i - 1;

        while (j >= 0 && strcmp(actual.nombre, alumnos[j].nombre) < 0) {
            alumnos[j + 1] = alumnos[j];
            j--;
        }
        alumnos[j + 1] = actual;
    }
}

// 8. Contar la cantidad de alumnos de un género determinado
int contarPorGenero(stAlumno* alumnos, int cantidad, char generoBuscado) {
    int contador = 0;

    if(generoBuscado != 'f' && generoBuscado != 'm' && generoBuscado != 'o'){
        contador = -1;
    } else {
        for (int i = 0; i < DIMENSION; i++) {
            if(generoBuscado == alumnos[i].genero){
                contador++;
            }
        }
    }

    return contador;
}

int main() {
    stAlumno alumnos[DIMENSION];
    int cantidad = 0;
    int opcion;

    do {
        printf("--- TP6 ---\n");
        printf("1) Cargar alumnos\n");
        printf("2) Mostrar alumnos\n");
        printf("3) Buscar alumno por matricula\n");
        printf("4) Ordenar alumnos por matricula\n");
        printf("5) Buscar alumnos por genero\n");
        printf("6) Insertar un nuevo alumno\n");
        printf("7) Ordenar alumnos por nombre\n");
        printf("8) Contar alumnos por genero\n");
        printf("9) Salir\n");
        printf("\nSeleccione una opcion: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                cantidad = cargarAlumno(alumnos);

                system("pause");
                break;

            case 2:
                mostrarAlumno(alumnos, cantidad);

                system("pause");
                break;

            case 3:
                buscarMatriculaAlumno(alumnos, cantidad);

                system("pause");
                break;

            case 4:
                ordenarMatriculaAlumnos(alumnos, cantidad);
                mostrarAlumno(alumnos, cantidad);

                system("pause");
                break;

            case 5: {
                char generoBuscar;
                printf("Ingrese el genero a buscar (m/f/o): ");
                scanf(" %c", &generoBuscar);
                buscarGenero(alumnos, cantidad, generoBuscar);

                system("pause");
                break;
            }

            case 6: {
                stAlumno nuevo;
                printf("Ingrese matricula: ");
                scanf("%d", &nuevo.matricula);
                getchar();
                printf("Ingrese nombre: ");
                gets(nuevo.nombre);
                printf("Ingrese genero (m/f/o): ");
                scanf(" %c", &nuevo.genero);
                insertarOrdenadoPorMatricula(alumnos, &cantidad, nuevo);

                system("pause");
                break;
            }

            case 7:
                ordenarPorNombreInsercion(alumnos, cantidad);
                mostrarAlumno(alumnos, cantidad);

                system("pause");
                break;

            case 8: {
                char generoBuscado;
                printf("Ingrese el genero (m/f/o) para contar: ");
                scanf(" %c", &generoBuscado);
                int contador = contarPorGenero(alumnos, cantidad, generoBuscado);
                if(contador == 0){
                    printf("\n\nNo se encontraron alumnos de ese genero\n\n");
                }else if (contador == -1) {
                    printf("\n\nEse genero es inexistente\n\n");
                }else {
                    printf("\nGenero: %c \nCantidad: %d\n\n", generoBuscado, contador);
                }

                system("pause");
                break;
            }

            case 9:
                break;
            default:
                printf("Opcion invalida, por favor seleccione una opcion valida\n");
                system("pause");
        }
    } while (opcion != 9);

    return 0;
}
