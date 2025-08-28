#include <stdio.h>
#include <stdlib.h>

///Hacer una función que determine si un elemento se encuentra dentro de una matriz de números enteros.
///La función recibe la matriz y el dato a buscar

void ingresarElemento(int *elemento){
    printf("Eliga el elemento a buscar: ");
    scanf("%d", elemento);
}

int buscarElemento(int filas, int columnas, int matriz[filas][columnas], int elemento){
    int flag = 0;
    for(int i = 0; i < filas; i++){
        for(int j = 0; j < columnas; j++){
            if(elemento==matriz[i][j]){
                flag = 1;
                break;
            }
        }
    }
    return flag;
}

void mostrarMatriz(int filas, int columnas, int matriz[filas][columnas]) {
    printf("\nMatriz ingresada:\n");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
}

int main()
{
    int filas = 2, columnas = 3, elemento;

    int matriz[2][3]={{6,7,3},{1,2,5}};

    ingresarElemento(&elemento);
    int flag = buscarElemento(filas, columnas, matriz, elemento);

    mostrarMatriz(filas, columnas, matriz);

    if(flag == 1){
        printf("\nEl elemento %d se encuentra en la matriz\n", elemento);
    } else {
        printf("\nEl elemento %d NO se encuentra en la matriz\n", elemento);
    }

    return 0;
}
