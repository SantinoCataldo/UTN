#include <stdio.h>
#include <stdlib.h>
#include "pila.h"
///Hacer una función que reciba como parámetro un arreglo, la cantidad de elementos (válidos) cargados en él y una Pila.
/// La función debe copiar los elementos del arreglo en la pila.

int cantCarga (array, cant);
int main()
{
    printf("CREANDO ARRAY EN MAIN\n");
    printf("---------------------\n");
    Pila pilaCopia;
    inicpila(&pilaCopia);
    int cant = 5;
    int i, array [cant];

    i=cantCarga(array, cant);
    copiarPila (array,i,&pilaCopia);
    mostrar (&pilaCopia);
    return 0;
}

int cantCarga (int array[], int cant )
{
   char opcion='s';
    int i=0;
    while (opcion=='s' && i < cant)
    {
        printf ("cargar un valor al arreglo...\n");
        scanf ("%d", &array[i]);

        printf ("desea seguir ingresando datos? ... s/n \n");
        fflush (stdin);
        scanf ("%c",&opcion);
        i++;
    }
    return i;
}

void copiarPila (int array[], int i, Pila *pilaCopia)
{
    for (int e=0 ; e < i; e++)
    {
        apilar(pilaCopia, array[e]);
    }
}

