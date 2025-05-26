#include <stdio.h>
#include <stdlib.h>

// Función para contar la cantidad de numeros pares en un array
int contarPares(int arr[], int tam) {
    int contador = 0;
    for (int i = 0; i < tam; i++) {
        if (arr[i] % 2 == 0) {
            contador++;
        }
    }
    return contador;
}

// a) Funcion que copia los elementos pares de un array a otro (array destino ya creado)
void copiarPares(int arrOrigen[], int tam, int arrDestino[]) {
    int j = 0;
    for (int i = 0; i < tam; i++) {
        if (arrOrigen[i] % 2 == 0) {
            arrDestino[j++] = arrOrigen[i];
        }
    }
}

// b) Funcion que crea y retorna un array con elementos pares
int* crearYCopiarPares(int arrOrigen[], int tam, int* tamPares) {
    *tamPares = contarPares(arrOrigen, tam);
    int* arrPares = (int*)malloc((*tamPares) * sizeof(int));

    if (arrPares == NULL) {
        printf("Error: No se pudo asignar memoria.\n");
        exit(1);
    }

    int j = 0;
    for (int i = 0; i < tam; i++) {
        if (arrOrigen[i] % 2 == 0) {
            arrPares[j++] = arrOrigen[i];
        }
    }

    return arrPares;
}

// c) Funcion que crea y asigna un array con elementos pares usando puntero doble
void CopiarParesPunteroDoble(int arrOrigen[], int tam, int** arrDestino, int* tamPares) {
    *tamPares = contarPares(arrOrigen, tam);
    *arrDestino = (int*)malloc((*tamPares) * sizeof(int));

    int j = 0;
    for (int i = 0; i < tam; i++) {
        if (arrOrigen[i] % 2 == 0) {
            (*arrDestino)[j++] = arrOrigen[i];
        }
    }
}

int main()
{
    int numeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int tam = sizeof(numeros) / sizeof(numeros[0]);

    printf("Array original:\n");
    for (int i = 0; i < tam; i++) {
        printf("%d ", numeros[i]);
    }
    printf("\n\n");

    /// a) Crear array de pares con malloc en el main
    int cantPares = contarPares(numeros, tam);
    int* arrPares1 = (int*)malloc(cantPares * sizeof(int));

    if (arrPares1 == NULL) {
        printf("No se pudo asignar memoria.\n");
        return 1;
    }

    copiarPares(numeros, tam, arrPares1);

    printf("a)Array de pares (malloc en main):\n");
    for (int i = 0; i < cantPares; i++) {
        printf("%d ", arrPares1[i]);
    }
    printf("\n\n");

    /// b) Crear array de pares con malloc dentro de función y retornando el array
    int tamPares2;
    int* arrPares2 = crearYCopiarPares(numeros, tam, &tamPares2);

    printf("b)Array de pares (malloc en funcion, retorna array):\n");
    for (int i = 0; i < tamPares2; i++) {
        printf("%d ", arrPares2[i]);
    }
    printf("\n\n");

    /// c) Crear array de pares con malloc dentro de función usando puntero doble
    int tamPares3;
    int* arrPares3;
    CopiarParesPunteroDoble(numeros, tam, &arrPares3, &tamPares3);

    printf("c)Array de pares (malloc en funcion, puntero doble):\n");
    for (int i = 0; i < tamPares3; i++) {
        printf("%d ", arrPares3[i]);
    }
    printf("\n");

    return 0;
}
