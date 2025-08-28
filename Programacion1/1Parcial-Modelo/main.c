#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

#define DIAS 3

int mayorTramo(Pila pila1) {
    int mayor = 0;

    while(!pilavacia(&pila1)){
        if (tope(&pila1) > mayor){
            mayor = tope(&pila1);
        }
        desapilar(&pila1);
    }

    return mayor;
}

void mostrarPila(Pila pila1){
    int i = 3;
    printf("\n\n-----3)PILA-----");
    while(!pilavacia(&pila1)){
        if(tope(&pila1)== -1){
            printf("\n[Dia %d]", i);
            i--;
        }
        else {
            printf("[%d]", tope(&pila1));
        }
        desapilar(&pila1);

    }
}

void cantidadKm(Pila pila1, int *array){
    int i = 0;
    Pila aux;
    inicpila(&aux);

    while(!pilavacia(&pila1)){
        apilar(&aux, desapilar(&pila1));
    }

    while(!pilavacia(&aux)){
        if(tope(&aux) == -1){
            i++;
        }else{
            array[i] += tope(&aux);
        }
        desapilar(&aux);
    }
}

void cantidadTramos(Pila pila1, int *array){
    int i = 0;

    Pila aux;
    inicpila(&aux);

    while(!pilavacia(&pila1)){
        apilar(&aux, desapilar(&pila1));
    }

     while(!pilavacia(&aux)){

        if(tope(&aux) == -1){
            i++;
        }else{
            array[i] += 1;
        }
        desapilar(&aux);
    }
}

void mostrarTodo(int *array1, int *array2){
    printf("\n\n-----6)DATOS DE CADA DIA-----");
    for(int i = 0; i< DIAS; i++){
        printf("\n[DIA %d]:[CANT KM: %d] [CANT TRAMOS: %d]", i+1, array1[i], array2[i]);
    }
    printf("\n\n");
}

int main()
{
    Pila pila1;
    inicpila(&pila1);
    int array1[DIAS];
    int array2[DIAS];

    apilar(&pila1, 5);
    apilar(&pila1, 4);
    apilar(&pila1, 2);
    apilar(&pila1, -1);
    apilar(&pila1, 6);
    apilar(&pila1, 2);
    apilar(&pila1, -1);
    apilar(&pila1, 8);
    apilar(&pila1, 5);
    apilar(&pila1, -1);

    for (int i = 0; i < DIAS; i++) {
        array1[i] = 0;
        array2[i] = 0;
    }

    printf("---Modelo de Examen---");

    printf("\n\n-----1)SE CREA LA PILA-----");

    mostrarPila(pila1);

    int mayor = mayorTramo(pila1);
    printf("\n\n-----2)MAYOR TRAMO SIN FRENAR: [%d]-----", mayor);



    printf("\n\n-----4)ARRAY CANTIDAD DE KILOMETROS POR DIA-----");
    cantidadKm(pila1, &array1);

    for(int i = 0; i< DIAS; i++){
        printf("\n[DIA %d]:[%d]", i+1, array1[i]);
    }

    printf("\n\n-----5)ARRAY CANTIDAD DE TRAMOS POR DIA-----");
    cantidadTramos(pila1, &array2);

    for(int i = 0; i< DIAS; i++){
        printf("\n[DIA %d]:[%d]", i+1, array2[i]);
    }

    mostrarTodo(array1, array2);

    return 0;
}
