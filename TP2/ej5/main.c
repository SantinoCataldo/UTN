#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

Pila pilaOrdenada(Pila A){
    Pila aux, ordenada;
    inicpila(&aux);
    inicpila(&ordenada);

    while (!pilavacia(&A)){
        int menor = tope(&A);

        while(!pilavacia(&A)){
            apilar(&aux, desapilar(&A));
            if (tope(&A)< menor){
                menor = tope(&A);
            }
            apilar(&ordenada, menor);
        }

        while(!pilavacia(&aux)){
            apilar(&A, desapilar(&aux));
        }
    }

    return ordenada;
}

int main()
{
    printf("Hacer una función que pase los elementos de una pila a otra, de manera que se genere una nueva pila ordenada. Usar la función del ejercicio 4. (Ordenamiento por selección)\n\n");
    Pila pila1, ordenada;
    inicpila(&pila1);
    inicpila(&ordenada);

    apilar(&pila1, 6);
    apilar(&pila1, 1);
    apilar(&pila1, 3);
    apilar(&pila1, 4);

    printf("Pila 1:");
    mostrar(&pila1);

    ordenada = pilaOrdenada(pila1);
    printf("La pila ordenada quedo asi: ");
    mostrar(&ordenada);

    return 0;
}
