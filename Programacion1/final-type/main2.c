int calcularFactorial(int numero) {
    if (numero <= 1)
        return 1;
    return numero * calcularFactorial(numero - 1);
}

int calcularPotencia(int base, int exponente) {
    if (exponente == 0)
        return 1;
    return base * calcularPotencia(base, exponente - 1);
}

void mostrarArreglo(int arreglo[], int cantidadElementos, int posicionActual) {
    if (posicionActual >= cantidadElementos)
        return;
    printf("%d ", arreglo[posicionActual]);
    mostrarArreglo(arreglo, cantidadElementos, posicionActual + 1);
}

void mostrarArregloInverso(int arreglo[], int cantidadElementos, int posicionActual) {
    if (posicionActual >= cantidadElementos)
        return;
    mostrarArregloInverso(arreglo, cantidadElementos, posicionActual + 1);
    printf("%d ", arreglo[posicionActual]);
}


int esArregloCapicua(int arreglo[], int inicio, int fin) {
    if (inicio >= fin)
        return 1;
    if (arreglo[inicio] != arreglo[fin])
        return 0;
    return esArregloCapicua(arreglo, inicio + 1, fin - 1);
}

int sumarElementosArreglo(int arreglo[], int cantidadElementos) {
    if (cantidadElementos == 0)
        return 0;
    return arreglo[cantidadElementos - 1] + sumarElementosArreglo(arreglo, cantidadElementos - 1);
}

int buscarMenorEnArreglo(int arreglo[], int cantidadElementos) {
    if (cantidadElementos == 1)
        return arreglo[0];
    int menorHastaAhora = buscarMenorEnArreglo(arreglo, cantidadElementos - 1);
    if (arreglo[cantidadElementos - 1] < menorHastaAhora)
        return arreglo[cantidadElementos - 1];
    return menorHastaAhora;
}


#include <limits.h>

int buscarMenorEnArchivo(char *archivo) {
    int numeroActual;
    if (fread(&numeroActual, sizeof(int), 1, archivo) != 1)
        return INT_MAX;
    int menorDelResto = buscarMenorEnArchivo(archivo);
    return (numeroActual < menorDelResto) ? numeroActual : menorDelResto;
}

void invertirArregloRecursivamente(int arreglo[], int izquierda, int derecha) {
    if (izquierda >= derecha)
        return;
    int auxiliar = arreglo[izquierda];
    arreglo[izquierda] = arreglo[derecha];
    arreglo[derecha] = auxiliar;
    invertirArregloRecursivamente(arreglo, izquierda + 1, derecha - 1);
}

int contieneElemento(int arreglo[], int cantidadElementos, int numeroBuscado) {
    if (cantidadElementos == 0)
        return 0;
    if (arreglo[cantidadElementos - 1] == numeroBuscado)
        return 1;
    return contieneElemento(arreglo, cantidadElementos - 1, numeroBuscado);
}

int contieneElementoEnOrdenado(int arreglo[], int posicionInicial, int posicionFinal, int numeroBuscado) {
    if (posicionInicial > posicionFinal)
        return 0;
    int posicionMedia = (posicionInicial + posicionFinal) / 2;
    if (arreglo[posicionMedia] == numeroBuscado)
        return 1;
    if (numeroBuscado < arreglo[posicionMedia])
        return contieneElementoEnOrdenado(arreglo, posicionInicial, posicionMedia - 1, numeroBuscado);
    else
        return contieneElementoEnOrdenado(arreglo, posicionMedia + 1, posicionFinal, numeroBuscado);
}

fseek(archivo, 0, SEEK_END);

// Obtener la posición actual (es decir, el tamaño en bytes del archivo)
long tamanio = ftell(f);

// Calcular cuántos enteros hay
int cantidad = tamanio / sizeof(int);

printf("El archivo contiene %d números enteros.\n", cantidad);

fclose(archivo);