#include <stdio.h>
#include <stdlib.h>

///Hacer una función que reciba como parámetro una matriz de números enteros
///y la muestre por pantalla (en formato matricial).

void mostrarMatriz(int matriz[3][3], int filas, int columnas) {
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
    int filas = 3;
    int columnas = 3;
    int matriz[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    mostrarMatriz(matriz, filas, columnas);
    return 0;
}
