#include <stdio.h>
#include <stdlib.h>

int main()
{
    int valor = 10;
    int *pint = &valor;   // Puntero a entero que apunta a 'valor'
    int **ppint = &pint;  // Puntero a puntero a entero que apunta a 'pint'

    printf("===== DIRECCIONES DE MEMORIA =====\n");
    printf("Direccion de 'valor': %d\n", &valor);
    printf("Direccion de 'pint': %d\n", &pint);
    printf("Direccion de 'ppint': %d\n\n", &ppint);

    printf("===== VALORES INICIALES =====\n");
    printf("Valor de 'valor': %d\n", valor);
    printf("Valor de 'pint' (Direccion a la que apunta): %d\n", pint);
    printf("Valor de '*pint' (contenido al que apunta): %d\n", *pint);
    printf("Valor de 'ppint' (Direccion a la que apunta): %d\n", ppint);
    printf("Valor de '*ppint' (contenido al que apunta pint): %d\n", *ppint);
    printf("Valor de '**ppint' (contenido al que apunta *ppint, que es 'valor'): %d\n\n", **ppint);

    valor = 20;
    printf("===== DESPUES DE MODIFICAR 'valor' DIRECTAMENTE =====\n");
    printf("Valor de 'valor': %d\n", valor);
    printf("Valor de '*pint': %d\n", *pint);
    printf("Valor de '**ppint': %d\n\n", **ppint);

    *pint = 30;
    printf("===== DESPUES DE MODIFICAR CON 'pint' =====\n");
    printf("Valor de 'valor': %d\n", valor);
    printf("Valor de '*pint': %d\n", *pint);
    printf("Valor de '**ppint': %d\n\n", **ppint);

    **ppint = 40;
    printf("===== DESPUES DE MODIFICAR CON 'ppint' =====\n");
    printf("Valor de 'valor': %d\n", valor);
    printf("Valor de '*pint': %d\n", *pint);
    printf("Valor de '**ppint': %d\n\n", **ppint);

    int otroValor = 50;
    printf("Creamos otra variable 'otroValor' = %d en la Direccion %d\n", otroValor, &otroValor);

    *ppint = &otroValor;
    printf("===== DESPUES DE HACER QUE 'pint' APUNTE A 'otroValor' USANDO 'ppint' =====\n");
    printf("Valor de 'valor': %d\n", valor);
    printf("Valor de 'otroValor': %d\n", otroValor);
    printf("Valor de '*pint' (ahora apunta a 'otroValor'): %d\n", *pint);
    printf("Valor de '**ppint': %d\n\n", **ppint);

    **ppint = 60;
    printf("===== DESPUES DE MODIFICAR 'otroValor' CON 'ppint' =====\n");
    printf("Valor de 'valor': %d\n", valor);
    printf("Valor de 'otroValor': %d\n", otroValor);
    printf("Valor de '*pint': %d\n", *pint);
    printf("Valor de '**ppint': %d\n", **ppint);

    return 0;
}
