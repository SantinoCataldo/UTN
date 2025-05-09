#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void mostrarElementos(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "r");

    if(archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    char elemento[30];
    while(fgets(elemento, sizeof(elemento), archivo) != NULL){
        printf("%s", elemento);
    }
    fclose(archivo);
}

void ingresarElementos(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "a");

    if(archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    char elemento[30];
    char control = 's';

    while(control == 's'){
        printf("Ingrese un elemento(string): ");
        fflush(stdin);
        gets(elemento);
        fprintf(archivo, "%s\n", elemento);
        printf("Desea ingresar otro nombre? (s/n): ");
        fflush(stdin);
        scanf("%c", &control);
    }

    fclose(archivo);
}

void cantidadElementos(char nombreArchivo[30]){
    FILE *archivo = fopen(nombreArchivo, "r");

    if(archivo == NULL){
        printf("Error al abrir el archivo\n");
        return;
    }

    char elemento[30];
    int contador = 0;
    while(fgets(elemento, sizeof(elemento), archivo) != NULL){
        contador++;
    }
    fclose(archivo);
    printf("Cantidad de registros: %d\n", contador);
}

int main()
{
    char *archivo = "elementos.bin";
    int opcion;
    do {
        printf("\t\t\t.::Menu::.\n");
        printf("1. Ingresar elementos\n");
        printf("2. Mostrar elementos\n");
        printf("3. Cantidad de elementos\n");
        printf("4. Salir\n");
        printf("Ingrese una opcion: ");
        scanf("%d", &opcion);

        switch(opcion){
            case 1:
                ingresarElementos(archivo);
                system("cls");
                break;
            case 2:
                mostrarElementos(archivo);
                system("pause");
                system("cls");
                break;
            case 3:
                cantidadElementos(archivo);
                system("pause");
                system("cls");
                break;
            case 4:
                printf("Saliendo...\n");
                break;
            default:
                printf("Opcion invalida\n");
        }
    } while (opcion != 4);
    return 0;
}
