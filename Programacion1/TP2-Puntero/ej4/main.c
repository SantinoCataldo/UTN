#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

void menorPila(Pila *A, int *menor){
    Pila aux;
    inicpila(&aux);
    *menor = tope(A);

    while(!pilavacia(A)){
        apilar(&aux, desapilar(A));
        if (tope(A)< *menor){
            *menor = tope(A);
        }
    }

    while(!pilavacia(&aux)){
        if(*menor == tope(&aux)){
            desapilar(&aux);
        }
        else {
            apilar(A, desapilar(&aux));
        }
    }
}

int main()
{
    printf("Hacer una función que encuentre el menor elemento de una pila y lo retorna. La misma debe eliminar ese dato de la pila\n\n");
    Pila pila1;
    inicpila(&pila1);
    int menor;

    apilar(&pila1, 5);
    apilar(&pila1, 1);
    apilar(&pila1, 3);
    apilar(&pila1, 2);

    printf("Pila 1 antes:");
    mostrar(&pila1);

    menorPila(&pila1, &menor);

    printf("Pila 1 despues:");
    mostrar(&pila1);
    printf("El menor es: %d\n", menor);

    return 0;
}
