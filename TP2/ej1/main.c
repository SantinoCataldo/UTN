#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

int main()
{
    printf("Hacer una función que permita ingresar varios elementos a una pila, tanto como quiera el usuario. \n\n");
    Pila pilaA;
    inicpila(&pilaA);

    agregarPila(&pilaA);
    return 0;
}

void agregarPila(pila){

    printf("Ingrese elementos para la pila (terminar con 0): \n");

    do {
        leer(pila);
    }while(tope(pila) != 0);

    desapilar(pila);

    mostrar(pila);
}
