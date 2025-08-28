#include <stdio.h>
#include <stdlib.h>
#include <time.h>

///Hacer una funci�n que reciba como par�metro una matriz de n�meros enteros y que cargue la misma con n�meros aleatorios
///(sin intervenci�n del usuario). La funci�n debe cargar la matriz por completo.

void cargarMatriz(int matriz[10][10], int filas, int columnas){
    for(int i = 0; i < filas; i++){
        for(int j = 0; j < columnas; j++){
            matriz[i][j] = rand() % 2;
        }
    }
}

void mostrarMatriz(int matriz[10][10], int filas, int columnas) {
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
    srand(time(NULL));
    int filas = 10;
    int columnas = 10;
    int matriz[filas][columnas];

    cargarMatriz(matriz, filas, columnas);
    mostrarMatriz(matriz, filas, columnas);
    return 0;
}
