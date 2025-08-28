#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

void cargarPila(Pila *A){
    printf("Ingrese elementos para la pila (terminar con 0): \n");

    do {
        leer(A);
    }while(tope(A) != 0);

    desapilar(A);
}

int main()
{
    printf("Hacer una función que permita ingresar varios elementos a una pila, tanto como quiera el usuario. \n\n");
    Pila pilaA;
    inicpila(&pilaA);

    printf("Pila:");
    cargarPila(&pilaA);
    mostrar(&pilaA);

    return 0;
}
