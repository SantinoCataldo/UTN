#include <stdio.h>
#include <stdlib.h>
///Hacer una funci�n que reciba como par�metro un arreglo y la cantidad de elementos (v�lidos) cargados en �l y
///los muestre por pantalla.

int cantCarga (array);
int main()
{
    printf("CREANDO ARRAY EN MAIN\n");
    printf("---------------------\n");
    int i, array [10]={};

    i=cantCarga(array);
    printf ("%d valores cargados", i);
    return 0;
}

int cantCarga (int array[] )
{
    char opcion='s';
    int i;
    i=0;
    while (opcion=='s' && i < 10)
    {
        printf ("cargar un valor al arreglo...\n");
        scanf ("%d", &array[i]);
        i++;
        printf ("desea seguir ingresando datos? ... s/n \n");
        fflush (stdin);
        scanf ("%c",&opcion);
    }
    return i;
}
