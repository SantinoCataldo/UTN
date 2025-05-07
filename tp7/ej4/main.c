#include <stdio.h>
#include <stdlib.h>
#include <string.h>

///Crear una función que cargue un archivo de alumnos.
///Abrirlo de manera tal de verificar si el archivo ya está creado previamente.
///Cargar el archivo con 5 datos. Cerrarlo dentro de la función

const char* archivo = "alumnos.bin";

typedef struct {
     int legajo;
     char nombreYapellido [30];
     int edad;
     int anio;
} stAlumno;

void mostrarElementos(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if(archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    stAlumno alumno;
    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1) {
        printf("Legajo: %d\n", alumno.legajo);
        printf("Nombre Completo: %s\n", alumno.nombreYapellido);
        printf("Edad: %d\n", alumno.edad);
        printf("Anio: %d\n", alumno.anio);
        printf("-------------------------\n");
    }
    fclose(archivo);
}

void cargarElementos(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "ab");

    if(archivo == NULL){
        printf("No hay archivo\n");
    }

    stAlumno alumno;
    for (int i = 0; i < 5; i++) {
        alumno.legajo = i + 1;
        strcpy(alumno.nombreYapellido, "Nombre");
        alumno.anio = 1;
        alumno.edad = 20 + i;
        fwrite(&alumno, sizeof(stAlumno), 1, archivo);
    }
    fclose(archivo);
}

int main()
{
    cargarElementos(archivo);
    mostrarElementos(archivo);

    return 0;
}
