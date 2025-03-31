#include <stdio.h>
#include <stdlib.h>

///Realizar una función que indique si un elemento
///dado se encuentra en un arreglo de caracteres.


void cargarAleatorio(int *enteros, int maxValores){
    int num = 0;
    for (int i = 0; i < maxValores; i++){
        num = rand() % 9 + 1;
        enteros[i] = num;
    }
}

int buscarAleatorio(int *enteros, int maxValores, int buscador){
    int flag = 0;
    for (int i = 0; i < maxValores; i++){
        printf("n%d: %d\n", i+1,  enteros[i]);
    }
    for (int i = 0; i < maxValores; i++){
        if (buscador == enteros[i]){
            flag = 1;
            break;
        }
    }
    return flag;
}

int main()
{
    srand(time(NULL));
    int maxValores = 10;
    int enteros[maxValores];
    int buscador;

    printf("Ingrese el valor a buscar en el array: ");
    scanf("%d", &buscador);

    cargarAleatorio(enteros, maxValores);
    int flag = buscarAleatorio(enteros, maxValores, buscador);

    if (flag == 1) printf("\nValor encontrado\n");
    else printf("\nValor no encontrado\n");

    return 0;
}
