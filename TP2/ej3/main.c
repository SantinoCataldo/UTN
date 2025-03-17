#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

Pila moverPila (Pila origen, Pila destino){
    Pila aux;
    inicpila(&aux);

    while(!pilavacia(&origen)){
        apilar(&aux, desapilar(&origen));
    }

    while(!pilavacia(&aux)){
        apilar(&destino, desapilar(&aux));
    }

    return destino;
}

int main()
{
    printf("Hacer una función que pase todos los elementos de una pila a otra\n\n");
    Pila pila1, pila2;
    inicpila(&pila1);
    inicpila(&pila2);


    apilar(&pila1, 1);
    apilar(&pila1, 2);
    apilar(&pila1, 3);
    apilar(&pila1, 4);

    printf("Pila 1 antes del cambio:");
    mostrar(&pila1);

    pila2 = moverPila(pila1, pila2);
    printf("Pila 2 despues del cambio:");
    mostrar(&pila2);

    return 0;
}
