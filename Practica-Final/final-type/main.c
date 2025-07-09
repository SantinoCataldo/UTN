#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int codigo;
    char titulo[50];
    char autor[40];
    char categoria[20];
    int disponible;
    int anio;
} Libro;

void cargarLibros(char *nombreArchivo);
void mostrarArchivo(char *nombreArchivo);
char *elegirCategoria();
Libro* filtrarPorCategoria(char *nombreArchivo, int *cantidadFiltrados, char *categoria);
void mostrarArreglo(Libro *arreglo, int cantidadFiltrados);
Libro buscarMasAntiguo(Libro *arreglo, int cantidadFiltrados);
int contarDisponibles(Libro *filtrados, int pos, int cantidadFiltrados);

/*
 * 8. Hacer una funci�n main que ejecute todas las funciones anteriores y demuestre
 *    su correcto funcionamiento. Crear las variables que sean necesarias e invocar
 *    a las funciones como corresponde en cada caso.
 *    (Mostrar por pantalla todos los resultados, el archivo y el arreglo)
 */

int main()
{
    char *nombreArchivo= "archivo.bin";
    Libro *filtrados;
    int cantidadFiltrados;

    // 1. Carga de libros al archivo binario
    cargarLibros(nombreArchivo);

    // 2. Mostrar todos los libros cargados en el archivo
    mostrarArchivo(nombreArchivo);

    // 3. Solicitar al usuario una categor�a para filtrar libros
    char *categoria = elegirCategoria();

    // 3. Filtrar los libros de esa categor�a desde el archivo al arreglo din�mico
    filtrados = filtrarPorCategoria(nombreArchivo,  &cantidadFiltrados, categoria);

    // 3. Verificar si se encontraron libros de esa categor�a
   if (filtrados == NULL || cantidadFiltrados == 0) {
        printf("No se encontraron libros en la categor�a '%s'.\n", categoria);
    } else {
        printf("\nSe encontraron %d libros en la categor�a '%s':\n", cantidadFiltrados, categoria);
        // 4. Mostrar los libros filtrados
        mostrarArreglo(filtrados, cantidadFiltrados);
    }

    // 5. Buscar el libro m�s antiguo entre los filtrados
    Libro antiguo = buscarMasAntiguo(filtrados, cantidadFiltrados);
    printf("\n=== Libro m�s antiguo ===\n");
    printf("Titulo: %s | Anio: %d\n", antiguo.titulo, antiguo.anio);

    // 6. Contar cu�ntos libros filtrados est�n disponibles (usando recursividad)
    int disponibles = contarDisponibles(filtrados, 0, cantidadFiltrados);
    printf("\nLibros disponibles para pr�stamo: %d\n", disponibles);

    // 7. Solicitar al usuario un c�digo de libro para buscar
    int codigoBuscado;
    printf("\nIngrese c�digo de libro a buscar: ");
    scanf("%d", &codigoBuscado);

    // 7. Buscar el c�digo en el arreglo (usando recursividad)
    int pos = buscarPorCodigo(filtrados, 0, cantidadFiltrados, codigoBuscado);
    if (pos == -1) {
        printf("No se encontr� un libro con el c�digo %d.\n", codigoBuscado);
    } else {
        printf("Libro encontrado en la posici�n %d: %s\n", pos, filtrados[pos].titulo);
    }

    free(filtrados);

    return 0;
}

/*
1. Hacer la o las funciones que sean necesarias para que el usuario del sistema
   pueda cargar en un ARCHIVO BINARIO todos los libros que desee.
*/

void cargarLibros(char *nombreArchivo){
    FILE *archivo = fopen(nombreArchivo, "ab");

    if(!archivo) {
        printf("No se pudo abrir el archivo");
        return;
    }

    Libro libro;
    char continuar;
    int i = 1;

    do{
        printf("---CARGA %der LIBRO---\n\n", i);
        printf("Ingrese codigo: ");
        scanf("%d", &libro.codigo);
        getchar();

        printf("Ingrese titulo: ");
        fgets(libro.titulo, 50, stdin);

        printf("Ingrese autor: ");
        fgets(libro.autor, 40, stdin);

        int opcionCat = 0;

        do {
            printf("Ingrese categoria (ficcion(1), ciencia(2), historia(3), arte(4)): ");
            scanf("%d", &opcionCat);
        }while(opcionCat < 1 || opcionCat > 4);

        switch(opcionCat) {
            case 1:
                strcpy(libro.categoria, "ficcion");
                break;
            case 2:
                strcpy(libro.categoria, "ciencia");
                break;
            case 3:
                strcpy(libro.categoria, "historia");
                break;
            case 4:
                strcpy(libro.categoria, "arte");
                break;
        }

        printf("�Est� disponible? (1 = s�, 0 = no): ");
        scanf("%d", &libro.disponible);

        printf("Ingrese anio de publicaci�n: ");
        scanf("%d", &libro.anio);
        i++;

        fwrite(&libro, sizeof(Libro), 1, archivo);

        printf("�Desea cargar otro libro? (s/n): ");
        getchar();
        scanf("%c", &continuar);
        system("cls");

    } while (continuar == 's');

    fclose(archivo);
}

/*
2. Hacer la o las funciones que sean necesarias para mostrar por pantalla
   el contenido del archivo de libros.
*/

void mostrarArchivo(char *nombreArchivo){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if(!archivo) {
        printf("No se pudo abrir el archivo");
        return;
    }

    Libro libro;

    printf("\n=== Libros en archivo ===\n");
    while (fread(&libro, sizeof(Libro), 1, archivo)) {
        printf("Codigo: %d | Titulo: %s | Autor: %s | Categoria: %s | %s | Anio: %d\n",
               libro.codigo, libro.titulo, libro.autor, libro.categoria,
               libro.disponible ? "Disponible" : "Prestado", libro.anio);
    }

    fclose(archivo);
}

/*
3. Hacer una funci�n que copie del archivo a un ARREGLO DINAMICO del tama�o justo
   �nicamente los libros que pertenezcan a la categor�a elegida por el usuario
   del sistema (usar el campo "categoria": ficcion, ciencia, historia, arte)
*/

char* elegirCategoria() {
    int opcionCat = 0;

    do {
        printf("Ingrese categoria (ficcion(1), ciencia(2), historia(3), arte(4)): ");
        scanf("%d", &opcionCat);
    } while(opcionCat < 1 || opcionCat > 4);

    switch(opcionCat) {
        case 1:
            return "ficcion";
        case 2:
            return "ciencia";
        case 3:
            return "historia";
        case 4:
            return "arte";
    }
}


Libro* filtrarPorCategoria(char *nombreArchivo, int *cantidadFiltrados, char *categoria){
    FILE *archivo = fopen(nombreArchivo, "rb");

    if(!archivo) {
        printf("No se pudo abrir el archivo");
        return NULL;
    }

    Libro libro;
    int contador = 0;
    int i = 0;

    while (fread(&libro, sizeof(Libro), 1, archivo)) {
        if (strcmp(libro.categoria, categoria) == 0) {
            contador++;
        }
    }

    rewind(archivo);
    Libro *lista = (Libro *)malloc(sizeof(Libro) * contador);
    if (lista == NULL) return NULL;

    while (fread(&libro, sizeof(Libro), 1, archivo)) {
        if (strcmp(libro.categoria, categoria) == 0) {
            lista[i++] = libro;
        }
    }

    fclose(archivo);
    *cantidadFiltrados = contador;
    return lista;
}

/*
4. Hacer la o las funciones que sean necesarias para mostrar por pantalla
   el contenido del arreglo del ejercicio 3
*/


void mostrarArreglo(Libro *arreglo, int cantidadFiltrados) {
    printf("\n=== Libros filtrados ===\n");
    for (int i = 0; i < cantidadFiltrados; i++) {
        printf("Codigo: %d | Titulo: %s | Autor: %s | Categoria: %s | %s | Anio: %d\n",
               arreglo[i].codigo, arreglo[i].titulo, arreglo[i].autor, arreglo[i].categoria,
               arreglo[i].disponible ? "Disponible" : "Prestado", arreglo[i].anio);
    }
}

/*
5. Hacer una funci�n que busque en el arreglo del ejercicio 3 el libro
   con el a�o de publicaci�n m�s antiguo.
*/

Libro buscarMasAntiguo(Libro *arreglo, int cantidadFiltrados) {
    Libro masAntiguo = arreglo[0];
    for (int i = 1; i < cantidadFiltrados; i++) {
        if (arreglo[i].anio < masAntiguo.anio) {
            masAntiguo = arreglo[i];
        }
    }
    return masAntiguo;
}

/*
6. Hacer una funci�n RECURSIVA que cuente cu�ntos libros del arreglo del ejercicio 3
   est�n disponibles para pr�stamo (campo disponible = 1).
   La funci�n debe recorrer el arreglo de forma recursiva.
*/

int contarDisponibles(Libro *filtrados, int pos, int cantidadFiltrados) {
    if (pos == cantidadFiltrados) return 0;
    int suma = filtrados[pos].disponible == 1 ? 1 : 0;
    return suma + contarDisponibles(filtrados, pos + 1, cantidadFiltrados);
}

/*
7. Hacer una funci�n RECURSIVA que busque en el arreglo del ejercicio 3 si existe
   un libro con un c�digo espec�fico ingresado por el usuario.
   La funci�n debe retornar la posici�n del libro si lo encuentra, o -1 si no existe.
   Debe usar recursividad para recorrer el arreglo.
*/

int buscarPorCodigo(Libro *filtrados, int pos, int cantidadFiltrados, int codigoBuscado) {
    if (pos == cantidadFiltrados) return -1;
    if (filtrados[pos].codigo == codigoBuscado) return pos;
    return buscarPorCodigo(filtrados, pos + 1, cantidadFiltrados, codigoBuscado);
}
