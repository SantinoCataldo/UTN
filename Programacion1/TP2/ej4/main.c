#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

int menorPila(Pila A){
    Pila aux;
    inicpila(&aux);
    int menor = tope(&A);

    while(!pilavacia(&A)){
        apilar(&aux, desapilar(&A));
        if (tope(&A)< menor){
            menor = tope(&A);
        }
    }
    return menor;
}

int main()
{
    printf("Hacer una función que encuentre el menor elemento de una pila y lo retorna. La misma debe eliminar ese dato de la pila\n\n");
    Pila pila1;
    inicpila(&pila1);

    apilar(&pila1, 4);
    apilar(&pila1, 1);
    apilar(&pila1, 3);
    apilar(&pila1, 4);

    printf("Pila 1:");
    mostrar(&pila1);

    int menor = menorPila(pila1);
    printf("El menor es:\n %d", menor);

    return 0;
}
