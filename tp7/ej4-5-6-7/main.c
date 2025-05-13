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

void legajosMayoresEdad(char nombreArchivo[30], Pila* pila){
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

    if (pilavacia(pila)){
        printf("No se encontraron alumnos mayores de edad.\n");
    } else {
        printf("Legajos de alumnos mayores de edad apilados correctamente.\n");
    }
}

int main()
{
    char *archivo = "alumnos.bin";
    int opcion = 0;

    while (opcion != 5){
        printf("--- MENU DE ALUMNOS ---\n");
        printf("1. Cargar alumnos\n");
        printf("2. Mostrar alumnos\n");
        printf("3. Legajo de alumnos mayores de edad\n");
        printf("4. Modificar alumno\n");
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
            Pila pila;
            inicpila(&pila);
            legajosMayoresEdad(archivo, &pila);
            mostrar(&pila);
            system("pause");
            system("cls");
            break;
        case 5:
            printf("Saliendo del programa. Hasta luego!\n");
            break;
        default:
            printf("Opción no válida. Intente nuevamente.\n");
        }
    }

    return 0;
}
