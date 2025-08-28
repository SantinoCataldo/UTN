#include <stdio.h>
#include <stdlib.h>
///Hacer una funci�n que reciba como par�metro un arreglo y la cantidad de elementos (v�lidos) cargados en �l y calcule
///la suma de sus elementos.

int cantCarga (int *enteros, int maxElementos ) {
   char control='s';
    int suma = 0, i = 0;

    while (control=='s' && i < maxElementos)
    {
        printf ("Ingrese un numero %d: ", i + 1);
        fflush (stdin);
        scanf ("%d", &enteros[i]);

        printf ("Quiere continuar? (s/n): ");
        fflush (stdin);
        scanf (" %c", &control);

        suma+=enteros[i];
        i++;
    }
    return suma;
}


int main()
{
    int maxElementos = 10;
    int enteros[maxElementos];

    int suma = cantCarga(enteros, maxElementos);
    printf ("\nLa suma total es: %d", suma);
    return 0;
}
