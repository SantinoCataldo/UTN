#include <stdio.h>
#include <stdlib.h>

///Hacer una función tipo float que calcule el promedio de una matriz de números enteros

float promedioMatriz(int filas, int columnas, int matriz[filas][columnas]){
    float prom = 0;
    float suma = 0;

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            suma += matriz[i][j];
        }
    }

    prom = suma / (columnas * filas);

    return prom;
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

int main()
{
    int filas = 2, columnas = 3;
    int matriz[2][3]={{1,2,4},{2,3,4}};

    float prom = promedioMatriz(filas, columnas,matriz);
    mostrarMatriz(filas, columnas, matriz);

    printf("\nEl promedio es de: %f\n", prom);

    return 0;
}
