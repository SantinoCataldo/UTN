#include <stdio.h>
#include <stdlib.h>
///Hacer una función que reciba como parámetro una matriz de números enteros y permita
///que el usuario ingrese valores al mismo por teclado.
///La función debe cargar la matriz por completo.

void cargarMatriz(int filas, int columnas, int matriz[filas][columnas]) {
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("Introduce el valor para la posicion [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }
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

int main() {
    int filas = 2;
    int columnas = 3;
    int matriz[filas][columnas];

    cargarMatriz(filas, columnas, matriz);
    mostrarMatriz(filas, columnas, matriz);

    return 0;
}
