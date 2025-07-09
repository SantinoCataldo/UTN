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
 * 8. Hacer una función main que ejecute todas las funciones anteriores y demuestre
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

    // 3. Solicitar al usuario una categoría para filtrar libros
    char *categoria = elegirCategoria();

    // 3. Filtrar los libros de esa categoría desde el archivo al arreglo dinámico
    filtrados = filtrarPorCategoria(nombreArchivo,  &cantidadFiltrados, categoria);

    // 3. Verificar si se encontraron libros de esa categoría
   if (filtrados == NULL || cantidadFiltrados == 0) {
        printf("No se encontraron libros en la categoría '%s'.\n", categoria);
    } else {
        printf("\nSe encontraron %d libros en la categoría '%s':\n", cantidadFiltrados, categoria);
        // 4. Mostrar los libros filtrados
        mostrarArreglo(filtrados, cantidadFiltrados);
    }

    // 5. Buscar el libro más antiguo entre los filtrados
    Libro antiguo = buscarMasAntiguo(filtrados, cantidadFiltrados);
    printf("\n=== Libro más antiguo ===\n");
    printf("Titulo: %s | Anio: %d\n", antiguo.titulo, antiguo.anio);

    // 6. Contar cuántos libros filtrados están disponibles (usando recursividad)
    int disponibles = contarDisponibles(filtrados, 0, cantidadFiltrados);
    printf("\nLibros disponibles para préstamo: %d\n", disponibles);

    // 7. Solicitar al usuario un código de libro para buscar
    int codigoBuscado;
    printf("\nIngrese código de libro a buscar: ");
    scanf("%d", &codigoBuscado);

    // 7. Buscar el código en el arreglo (usando recursividad)
    int pos = buscarPorCodigo(filtrados, 0, cantidadFiltrados, codigoBuscado);
    if (pos == -1) {
        printf("No se encontró un libro con el código %d.\n", codigoBuscado);
    } else {
        printf("Libro encontrado en la posición %d: %s\n", pos, filtrados[pos].titulo);
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

        printf("¿Está disponible? (1 = sí, 0 = no): ");
        scanf("%d", &libro.disponible);

        printf("Ingrese anio de publicación: ");
        scanf("%d", &libro.anio);
        i++;

        fwrite(&libro, sizeof(Libro), 1, archivo);

        printf("¿Desea cargar otro libro? (s/n): ");
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
3. Hacer una función que copie del archivo a un ARREGLO DINAMICO del tamaño justo
   únicamente los libros que pertenezcan a la categoría elegida por el usuario
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
5. Hacer una función que busque en el arreglo del ejercicio 3 el libro
   con el año de publicación más antiguo.
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
6. Hacer una función RECURSIVA que cuente cuántos libros del arreglo del ejercicio 3
   están disponibles para préstamo (campo disponible = 1).
   La función debe recorrer el arreglo de forma recursiva.
*/

int contarDisponibles(Libro *filtrados, int pos, int cantidadFiltrados) {
    if (pos == cantidadFiltrados) return 0;
    int suma = filtrados[pos].disponible == 1 ? 1 : 0;
    return suma + contarDisponibles(filtrados, pos + 1, cantidadFiltrados);
}

/*
7. Hacer una función RECURSIVA que busque en el arreglo del ejercicio 3 si existe
   un libro con un código específico ingresado por el usuario.
   La función debe retornar la posición del libro si lo encuentra, o -1 si no existe.
   Debe usar recursividad para recorrer el arreglo.
*/

int buscarPorCodigo(Libro *filtrados, int pos, int cantidadFiltrados, int codigoBuscado) {
    if (pos == n) return -1;
    if (filtrados[pos].codigo == codigoBuscado) return pos;
    return buscarPorCodigo(filtrados, pos + 1, cantidadFiltrados, codigoBuscado);
}
