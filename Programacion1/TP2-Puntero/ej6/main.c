#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

void pilaOrdenada(Pila *ordenada){
    Pila aux, aux2;
    inicpila(&aux);
    inicpila(&aux2);

    printf("Ingrese numero para ordenar:\n");
    leer(&aux);

    while(!pilavacia(&aux)){
        if (tope(ordenada) <= tope(&aux)){
            apilar(ordenada, desapilar(&aux));
        }
        else if (tope(ordenada) > tope(&aux)){
            apilar(&aux2, desapilar(ordenada));
        }
    }

    while(!pilavacia(&aux2)){
        apilar(ordenada, desapilar(&aux2));
    }
}

int main()
{
    printf("Hacer una función que inserta en una pila ordenada un nuevo elemento, conservando el orden de ésta.\n\n");
    Pila ordenada;
    inicpila(&ordenada);

    apilar(&ordenada, 1);
    apilar(&ordenada, 3);
    apilar(&ordenada, 4);
    apilar(&ordenada, 7);

    printf("Pila Odrdenada :");
    mostrar(&ordenada);

    pilaOrdenada(&ordenada);

    printf("La pila ordenada quedo asi: ");
    mostrar(&ordenada);

    return 0;
}
