#include <stdio.h>
#include <stdlib.h>
///Hacer una función que reciba como parámetro un arreglo y la cantidad de elementos (válidos) cargados en él y calcule
///la suma de sus elementos.

int cantCarga (array);
int main()
{
    printf("CREANDO ARRAY EN MAIN\n");
    printf("---------------------\n");
    int i, array [10]={};

    i=cantCarga(array);
    printf ("La suma total es: %d", i);
    return 0;
}

int cantCarga (int array[] )
{
   char opcion='s';
    int suma=0,i=0;
    while (opcion=='s' && i < 10)
    {
        printf ("cargar un valor al arreglo...\n");
        scanf ("%d", &array[i]);
        suma+=array[i];
        printf ("desea seguir ingresando datos? ... s/n \n");
        fflush (stdin);
        scanf ("%c",&opcion);
        i++;
    }
    return suma;
}
