#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

void pilaOrdenada(Pila *A, Pila *ordenada){
    Pila aux;
    inicpila(&aux);

    while (!pilavacia(A)){
        int menor = desapilar(A);
        while(!pilavacia(A)){
            if (tope(A)< menor){
                apilar(&aux, menor);
                menor = desapilar(A);
            }
            else {
             apilar(&aux, desapilar(A));
            }
        }
        apilar(ordenada, menor);
        while(!pilavacia(&aux)){
            apilar(A, desapilar(&aux));
        }
    }
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

    pilaOrdenada(&pila1, &ordenada);

    printf("La pila ordenada quedo asi: ");
    mostrar(&ordenada);

    return 0;
}
