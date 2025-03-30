#include <stdio.h>
#include <stdlib.h>
#include "pila.h"
///Hacer una funci�n que reciba como par�metro un arreglo, la cantidad de elementos (v�lidos) cargados en �l y una Pila.
/// La funci�n debe copiar los elementos del arreglo en la pila.

int cantCarga (int *array, int maxElementos )
{
   char control='s';
    int i = 0;
    while (control=='s' && i < maxElementos)
    {
        printf ("cargar un valor al arreglo...\n");
        scanf ("%d", &array[i]);

        printf ("desea seguir ingresando datos? ... s/n \n");
        fflush (stdin);
        scanf ("%c",&control);
        i++;
    }
    return i;
}

void copiarPila (int *array, int numArray, Pila *pilaCopia)
{
    for (int i = 0 ; i < numArray; i++)
    {
        apilar(pilaCopia, array[i]);
    }
}

int main()
{
    int maxElementos = 5, carga = 0, array[maxElementos];
    Pila pilaCopia;
    inicpila(&pilaCopia);

    carga=cantCarga(array, maxElementos);
    copiarPila(array, carga, &pilaCopia);
    mostrar(&pilaCopia);
    return 0;
}
