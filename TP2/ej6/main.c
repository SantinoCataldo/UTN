#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

Pila pilaOrdenada(Pila ordenada){
    Pila aux, aux2;
    inicpila(&aux);
    inicpila(&aux2);

    printf("Ingrese numero para ordenar:\n");
    leer(&aux);

    while(!pilavacia(&aux)){
        if (tope(&ordenada) <= tope(&aux)){
            apilar(&ordenada, desapilar(&aux));
        }
        else if (tope(&ordenada) > tope(&aux)){
            apilar(&aux2, desapilar(&ordenada));
        }
    }

    while(!pilavacia(&aux2)){
        apilar(&ordenada, desapilar(&aux2));
    }

    return ordenada;
}

int main()
{
    printf("Hacer una funci�n que pase los elementos de una pila a otra, de manera que se genere una nueva pila ordenada. Usar la funci�n del ejercicio 4. (Ordenamiento por selecci�n)\n\n");
    Pila ordenada;
    inicpila(&ordenada);

    apilar(&ordenada, 1);
    apilar(&ordenada, 3);
    apilar(&ordenada, 4);
    apilar(&ordenada, 7);

    printf("Pila Odrdenada :");
    mostrar(&ordenada);

    ordenada = pilaOrdenada(ordenada);
    printf("La pila ordenada quedo asi: ");
    mostrar(&ordenada);

    return 0;
}
