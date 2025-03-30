#include <stdio.h>
#include <stdlib.h>
///Hacer una funci�n que reciba como par�metro un arreglo y la cantidad de elementos (v�lidos) cargados en �l y
///los muestre por pantalla.

int cantCarga (int *enteros, int maxElementos){
    char control='s';
    int i = 0;
    while (control=='s' && i < maxElementos)
    {
        printf("Ingrese un numero %d: ", i + 1);
        scanf("%d", &enteros[i]);

        printf("�Quiere continuar? (s/n): ");
        fflush(stdin);
        scanf(" %c", &control);

        i++;
    }
    return i;
}

int main()
{
    int maxElementos = 10;
    int enteros[maxElementos];

    int total = cantCarga(enteros, maxElementos);
    printf("\nEl total de valores ingresados es: %d\n", total);
    return 0;
}

