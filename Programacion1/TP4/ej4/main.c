#include <stdio.h>
#include <stdlib.h>

///Hacer una funci�n tipo int que sume el contenido total de una matriz de n�meros enteros

int sumarMatriz(int filas, int columnas, int matriz[filas][columnas]) {
    int suma = 0;
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            suma += matriz[i][j];
        }
    }
    return suma;
}

void mostrarMatriz(int filas, int columnas, int matriz[filas][columnas]) {
    printf("Matriz ingresada:\n");
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
    int matriz[2][3] = {{1,2,3},{4,6,2}};

    int suma = sumarMatriz(filas, columnas, matriz);
    mostrarMatriz(filas, columnas, matriz);

    printf("\nLa suma es de: %d\n", suma);

    return 0;
}
