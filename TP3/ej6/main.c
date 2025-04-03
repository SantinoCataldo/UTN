#include <stdio.h>
#include <stdlib.h>

///Realizar una función que indique si un elemento
///dado se encuentra en un arreglo de caracteres.

int buscarAleatorio(char *enteros, char buscador){
    int flag = 0;
    for (int i = 0; i < 5; i++){
        printf("n%d: %c\n", i+1,  enteros[i]);
    }
    for (int i = 0; i < 5; i++){
        if (buscador == enteros[i]){
            flag = 1;
            break;
        }
    }
    return flag;
}

int main()
{
    char caracteres[5]={'a','r','b','c','e','k'};
    char buscador;

    printf("Ingrese el valor a buscar en el array: ");
    scanf("%c", &buscador);

    int flag = buscarAleatorio(caracteres, buscador);

    if (flag == 1) printf("\nValor encontrado\n");
    else printf("\nValor no encontrado\n");

    return 0;
}
