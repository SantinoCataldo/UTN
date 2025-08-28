#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define DIMENSION 30

typedef struct {
int legajo;
char nombreYapellido [30];
int edad;
int anio;
} stAlumno;

stAlumno cargarAlumno ();
void cargarAlumnos (char *archivoAlumnos);
int contarAlumnos(char *archivoAlumnos);
void copiarArchivoAArreglo(char *archivoAlumnos, stAlumno *arreglo, int cantidad);
int copiarArchivoAArregloConMalloc(char *archivoAlumnos, stAlumno **arreglo);
void mostrarAlumno(stAlumno alumno);
void mostrarArregloAlumnos(stAlumno *arreglo, int cantidad);

int main()
{
    char *archivo = "alumnos.bin";

    int cantAlumnos = contarAlumnos(archivo);
    printf("Cantidad de alumnos en el archivo: %d\n", cantAlumnos);

    if (cantAlumnos <= 0) {
        printf("No hay alumnos en el archivo. Cargando alumnos...\n");
        cargarAlumnos(archivo);
        cantAlumnos = contarAlumnos(archivo);
        printf("Nueva cantidad de alumnos: %d\n", cantAlumnos);
    }

    printf("\n=== METODO 1: MALLOC EN MAIN ===\n");
    stAlumno *arregloAlumnos1 = (stAlumno *)malloc(cantAlumnos * sizeof(stAlumno));

    if (arregloAlumnos1 == NULL) {
        printf("Error: No se pudo asignar memoria para el arreglo\n");
        return -1;
    }

    copiarArchivoAArreglo(archivo, arregloAlumnos1, cantAlumnos);

    mostrarArregloAlumnos(arregloAlumnos1, cantAlumnos);

    arregloAlumnos1 = NULL;

    printf("Memoria del primer arreglo liberada correctamente.\n");

    printf("\n=== METODO 2: MALLOC DENTRO DE LA FUNCION (PUNTERO DOBLE) ===\n");
    stAlumno *arregloAlumnos2 = NULL;
    int cantidadCopiada = copiarArchivoAArregloConMalloc(archivo, &arregloAlumnos2);

    if (cantidadCopiada > 0 && arregloAlumnos2 != NULL) {
        mostrarArregloAlumnos(arregloAlumnos2, cantidadCopiada);

        arregloAlumnos2 = NULL;

        printf("Memoria del segundo arreglo liberada correctamente.\n");
    } else {
        printf("No se pudieron copiar los alumnos con el segundo método.\n");
    }

    return 0;
}

void cargarAlumnos (char *archivoAlumnos){
    stAlumno aux;
    FILE *archivo = fopen (archivoAlumnos, "rb");
    if (archivo == NULL){
        archivo = fopen (archivoAlumnos, "wb");
        printf ("El archivo fue creado \n");
    } else{
        fclose(archivo);
        archivo = fopen (archivoAlumnos, "ab");
        printf("Archivo existente encontrado\n");
    }
    for (int i = 0 ; i<5 ; i++){
        printf ("CARGANDO ALUMNO N %d...\n", i +1);
        aux = cargarAlumno();
        fwrite(&aux, sizeof(stAlumno), 1, archivo);
    }
    fclose(archivo);
}

stAlumno cargarAlumno(){
    stAlumno alumno;
    printf ("ingrese el legajo: ");
    scanf ("%d", &alumno.legajo);
    printf ("ingrese el nombre y apellido: ");
    fflush (stdin);
    gets(alumno.nombreYapellido);
    printf("ingrese el edad: ");
    scanf("%d", &alumno.edad);
    printf("ingrese el anio: ");
    scanf("%d", &alumno.anio);
    system("cls");

    return alumno;
}

int contarAlumnos(char *archivoAlumnos){
    stAlumno aux;
    FILE *archivo = fopen (archivoAlumnos, "rb");

    if(archivo == NULL){
        printf("No se encontro el archivo\n");
        return -1;
    }

    fseek(archivo, 0, SEEK_END);
    int tamArchivo = ftell(archivo);

    fclose(archivo);

    int cantidad = tamArchivo / sizeof(stAlumno);

    return cantidad;
}

void copiarArchivoAArreglo(char *archivoAlumnos, stAlumno *arreglo, int cantidad) {
    FILE *archivo = fopen(archivoAlumnos, "rb");

    if (archivo == NULL) {
        printf("Error: No se pudo abrir el archivo\n");
        return;
    }

    fread(arreglo, sizeof(stAlumno), cantidad, archivo);

    fclose(archivo);
    printf("Se copiaron %d alumnos del archivo al arreglo\n", cantidad);
}

int copiarArchivoAArregloConMalloc(char *archivoAlumnos, stAlumno **arreglo) {
    FILE *archivo = fopen(archivoAlumnos, "rb");

    if (archivo == NULL) {
        printf("Error: No se pudo abrir el archivo\n");
        return -1;
    }

    fseek(archivo, 0, SEEK_END);
    int tamArchivo = ftell(archivo);
    fseek(archivo, 0, SEEK_SET);

    int cantidad = tamArchivo / sizeof(stAlumno);

    if (cantidad <= 0) {
        printf("No hay alumnos en el archivo\n");
        fclose(archivo);
        return 0;
    }

    *arreglo = (stAlumno *)malloc(cantidad * sizeof(stAlumno));

    if (*arreglo == NULL) {
        printf("Error: No se pudo asignar memoria para el arreglo\n");
        fclose(archivo);
        return -1;
    }

    int leidos = fread(*arreglo, sizeof(stAlumno), cantidad, archivo);

    fclose(archivo);

    if (leidos != cantidad) {
        printf("Advertencia: Se esperaban %d registros, pero se leyeron %d\n", cantidad, leidos);
    }

    printf("Se copiaron %d alumnos del archivo al arreglo usando malloc\n", leidos);
    return leidos;
}

void mostrarAlumno(stAlumno alumno) {
    printf("Legajo: %d\n", alumno.legajo);
    printf("Nombre y Apellido: %s\n", alumno.nombreYapellido);
    printf("Edad: %d\n", alumno.edad);
    printf("anio que cursa: %d\n", alumno.anio);
    printf("------------------------\n");
}

void mostrarArregloAlumnos(stAlumno *arreglo, int cantidad) {
    printf("\n=== ALUMNOS EN EL ARREGLO ===\n");
    for (int i = 0; i < cantidad; i++) {
        printf("Alumno %d:\n", i + 1);
        mostrarAlumno(arreglo[i]);
    }
}
