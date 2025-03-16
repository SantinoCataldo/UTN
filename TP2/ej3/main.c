#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

int main()
{
    printf("Hacer una función que pase todos los elementos de una pila a otra\n\n");
    Pila pila1, pila2, aux;
    inicpila(&pila1);
    inicpila(&pila2);
    inicpila(&aux);

    apilar(&pila1, 1);
    apilar(&pila1, 2);
    apilar(&pila1, 3);
    apilar(&pila1, 4);

    moverPila(&pila1, &pila2, &aux);

    printf("Hello world!\n");
    return 0;
}

void moverPila (pila1, pila2, aux){
    printf("Pila 1 antes del cambio:");
    mostrar(pila1);

    while(!pilavacia(pila1)){
        apilar(aux, desapilar(pila1));
    }

    while(!pilavacia(aux)){
        apilar(pila2, desapilar(aux));
    }

    printf("Pila 2 despues del cambio:");
    mostrar(pila2);
}
