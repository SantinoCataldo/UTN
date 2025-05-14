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

    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.edad >= 18){
            apilar(pila, alumno.legajo);
        }
    }

    fclose(archivo);
}
///8) Dado un archivo de alumnos, hacer una función que cuente la cantidad de alumnos mayores a edad específica que se envía por parámetro

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

///9) Dado un archivo de alumnos, mostrar por pantalla el nombre de todos los alumnos entre un rango de edades específico (por ejemplo, entre 17 y 25 años). Dicho rango debe recibirse por parámetro. Modularizar

void mostrarRangoEdad(char nombreArchivo[30], int edadMinima, int edadMaxima){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    printf("Ingrese el Rango de edad del alumno\n\nIngresar edad minima: ");
    scanf("%d", &edadMinima);
    printf("Ingresar edad maxima: ");
    scanf("%d", &edadMaxima);

    stAlumno alumno;

    printf("----------------------------\n");
    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.edad >= edadMinima && alumno.edad <= edadMaxima){
            printf("[%s]", alumno.nombreYapellido);
        }
    }
    printf("\n----------------------------\n");

    fclose(archivo);
}

///10) Dado un archivo de alumnos, mostrar los datos del alumno de mayor edad. Modularizar

void mostrarDatosAlumnosMayores(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    stAlumno alumno;

    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.edad >= 18){
            printf("-------------------------\n");
            printf("Legajo: %d\n", alumno.legajo);
            printf("Nombre Completo: %s\n", alumno.nombreYapellido);
            printf("Edad: %d\n", alumno.edad);
            printf("Anio: %d\n", alumno.anio);
        }
    }

    fclose(archivo);
}

///11) Crear una función que retorne la cantidad de alumnos que cursan un determinado año. El año buscado se pasa por parámetro.

void mostrarAlumnosPorAnio(char nombreArchivo[30], int cursada){
    FILE *archivo = fopen(nombreArchivo, "rb");

    printf("Ingresar anio de cursada: ");
    scanf("%d", &cursada);

    if (archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

     stAlumno alumno;

    while (fread(&alumno, sizeof(stAlumno), 1, archivo) == 1){
        if (alumno.anio == cursada){
            printf("-------------------------\n");
            printf("Legajo: %d\n", alumno.legajo);
            printf("Nombre Completo: %s\n", alumno.nombreYapellido);
            printf("Edad: %d\n", alumno.edad);
            printf("Anio: %d\n", alumno.anio);
        }
    }

    fclose(archivo);
}

int main()
{
    char *archivo = "alumnos.bin";
    Pila pila;
    inicpila(&pila);
    int opcion = 0, mayores = 0, edadMinima, edadMaxima, cursada;

    while (opcion != 5){
        printf("--- MENU DE ALUMNOS ---\n");
        printf("1. Cargar alumnos\n");
        printf("2. Mostrar alumnos\n");
        printf("3. Agregar alumno\n");
        printf("4. Legajo de alumnos mayores de edad (Pila)\n");
        printf("5. Mostar cantidad de alumnos mayores de 18\n");
        printf("6. Mostrar alumnos entre un rango de edad\n");
        printf("7. Mostar datos de alumnos mayores de edad\n");
        printf("8. Mostar alumnos de un año especifico\n");
        printf("9. Salir\n");
        printf("Seleccione una opcion: ");
        scanf("%d", &opcion);

        switch (opcion){
        case 1:
            system("cls");
            cargarAlumnos(archivo);
            system("pause");
            system("cls");
            break;
        case 2:
            system("cls");
            mostrarAlumnos(archivo);
            system("pause");
            system("cls");
            break;
        case 3:
            system("cls");
            agregarAlumno(archivo);
            system("pause");
            system("cls");
            break;
        case 4:
            system("cls");
            legajosMayoresEdadPila(archivo, &pila);
            mostrar(&pila);
            system("pause");
            system("cls");
            break;
        case 5:
            system("cls");
            mayores = cantidadMayoresEdad(archivo);
            if(mayores == 0){
                printf("No hay alumnos mayores de edad");
            } else {
                printf("Cantidad de alumnos mayores de edad: %d\n", mayores);
            }
            system("pause");
            system("cls");
            break;
        case 6:
            system("cls");
            mostrarRangoEdad(archivo, edadMinima, edadMaxima);
            system("pause");
            system("cls");
            break;
        case 7:
            system("cls");
            mostrarDatosAlumnosMayores(archivo);
            system("pause");
            system("cls");
            break;
        case 8:
            system("cls");
            mostrarAlumnosPorAnio(archivo, cursada);
            system("pause");
            system("cls");
            break;
         case 9:
            printf("Programa finalizado\n");
            break;
        default:
            printf("Opcion no valida. Intente nuevamente.\n");
        }
    }

    return 0;
}
