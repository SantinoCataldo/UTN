#include <stdio.h>
#include <stdlib.h>
#define TOTAL(x)  (sizeof(x) / sizeof((x)[0]))

int pasarEnteros(int *enteros, int totalElementos){
    char control = 's';
    int i = 0;
    while(control == 's' && i < totalElementos){
        printf("Ingese el numero %i: ", i);
        scanf ("%d", &enteros[i]);
        printf("desea continuar? s/n: ");
        fflush(stdin);
        scanf ("%c", &control);
        i++;
    }

    return i;
}

int main ( )
{
    int totalElementos = 5;
    int totalIngresados = 0;
    int enteros[totalElementos];
    totalIngresados = pasarEnteros(enteros, totalElementos);
    printf ( "\nEl total de valores es: %d\n", totalIngresados);
    return 0;
}
