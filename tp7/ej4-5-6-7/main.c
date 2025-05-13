#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pila.h"

typedef struct
{
    int legajo;
    char nombreYapellido[30];
    int edad;
    int anio;
} stAlumno;

///?) Funcion para poder cargar el ultimo arcchivo

int legajoExiste(FILE *archivo, int legajo){
    stAlumno alumno;
    long posicionActual = ftell(archivo);

    rewind(archivo);

    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.legajo == legajo){
            fseek(archivo, posicionActual, SEEK_SET);
            return 1;
        }
    }

    fseek(archivo, posicionActual, SEEK_SET);
    return 0;
}

///4) Función que cargue un archivo de alumnos, verifica si el archivo ya está creado previamente

void cargarAlumnos(char nombreArchivo[30]){
    FILE *archivo;

    archivo = fopen(nombreArchivo, "rb");

    if (archivo == NULL){
        archivo = fopen(nombreArchivo, "wb");
        printf("Se creo el archivo\n\n");
    }
    else{
        fclose(archivo);
        archivo = fopen(nombreArchivo, "rb+");
        printf("Archivo ya creado\n\n");
    }

    stAlumno alumno;

    for (int i = 0; i < 5; i++){
        int legajo = i + 1;
        while (legajoExiste(archivo, legajo)){
            legajo++;
        }

        alumno.legajo = legajo;
        sprintf(alumno.nombreYapellido, "Alumno %d", legajo);
        alumno.edad = 20 + i;
        alumno.anio = 1 + i % 5;

        fseek(archivo, 0, SEEK_END);
        fwrite(&alumno, sizeof(stAlumno), 1, archivo);
    }

    fclose(archivo);
}

///5)Función que muestre todos los alumnos del archivo

void mostrarAlumnos(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    stAlumno alumno;
    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        printf("-------------------------\n");
        printf("Legajo: %d\n", alumno.legajo);
        printf("Nombre Completo: %s\n", alumno.nombreYapellido);
        printf("Edad: %d\n", alumno.edad);
        printf("Anio: %d\n", alumno.anio);
    }
    printf("\n");
    fclose(archivo);
}

///6) Función que permite agregar un elemento al final del archivo

void agregarAlumno(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "ab");

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    stAlumno alumno;

    printf("Ingrese el legajo del alumno: ");
    scanf("%d", &alumno.legajo);
    printf("Ingrese el nombre y apellido del alumno: ");
    fflush(stdin);
    gets(alumno.nombreYapellido);
    printf("Ingrese la edad del alumno: ");
    scanf("%d", &alumno.edad);
    printf("Ingrese el anio del alumno: ");
    scanf("%d", &alumno.anio);

    fwrite(&alumno, sizeof(stAlumno), 1, archivo);

    fclose(archivo);
    printf("Alumno agregado exitosamente.\n");
}

///7) Función que pasa a una pila los números de legajo de los alumnos mayores de edad

void legajosMayoresEdadPila(char nombreArchivo[30], Pila* pila){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    stAlumno alumno;
    inicpila(pila);

    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.edad >= 18){
            apilar(pila, alumno.legajo);
        }
    }

    fclose(archivo);
}

int cantidadMayoresEdad(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "rb");
    int mayores = 0;

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    stAlumno alumno;

    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.edad >= 18){
            mayores++;
        }
    }

    fclose(archivo);

    return mayores;
}

int main()
{
    char *archivo = "alumnos.bin";
    Pila pila;
    inicpila(&pila);
    int opcion = 0, mayores = 0;

    while (opcion != 5){
        printf("--- MENU DE ALUMNOS ---\n");
        printf("1. Cargar alumnos\n");
        printf("2. Mostrar alumnos\n");
        printf("3. Agregar alumno\n");
        printf("4. Legajo de alumnos mayores de edad (Pila)\n");
        printf("5. Salir\n");
        printf("Seleccione una opcion: ");
        scanf("%d", &opcion);

        switch (opcion){
        case 1:
            cargarAlumnos(archivo);
            system("pause");
            system("cls");
            break;
        case 2:
            mostrarAlumnos(archivo);
            system("pause");
            system("cls");
            break;
        case 3:
            agregarAlumno(archivo);
            system("pause");
            system("cls");
            break;
        case 4:
            legajosMayoresEdadPila(archivo, &pila);
            mostrar(&pila);
            system("pause");
            system("cls");
            break;
        case 5:
            mayores = cantidadMayoresEdad(archivo);
            if(mayores = 0){
                printf("No hay alumnos mayores de edad");
            } else {
                printf("Cantidad de alumnos mayores de edad: %d", mayores);
            }
            system("pause");
            system("cls");
            break;
        case 6:
            printf("Programa finalizado\n");
            break;
        default:
            printf("Opcion no valida. Intente nuevamente.\n");
        }
    }

    return 0;
}
