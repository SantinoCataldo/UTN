#include <stdio.h>
#include <stdlib.h>

///Hacer una función tipo int que sume el contenido total de una matriz de números enteros

int sumarMatriz(int matriz[2][3], int filas, int columnas) {
    int suma = 0;
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            suma += matriz[i][j];
        }
    }
    return suma;
}

int main() {
    int filas = 2;
    int columnas = 3;
    int matriz[2][3] = {{1,2,3},{4,6,2}};

    int suma = sumarMatriz(matriz, filas, columnas);

    printf("La suma es de: %d", suma);

    return 0;
}
