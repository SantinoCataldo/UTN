#include <stdio.h>
#include <stdlib.h>
///Hacer una funci�n que reciba como par�metro una matriz de n�meros enteros y permita
///que el usuario ingrese valores al mismo por teclado.
///La funci�n debe cargar la matriz por completo.

void cargarMatriz(int matriz[2][3], int filas, int columnas) {
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("Introduce el valor para la posicion [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }
}

void mostrarMatriz(int matriz[2][3], int filas, int columnas) {
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

    cargarMatriz(matriz, filas, columnas);
    mostrarMatriz(matriz, filas, columnas);

    return 0;
}
