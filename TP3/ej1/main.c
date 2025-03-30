#include <stdio.h>
#include <stdlib.h>
#define TOTAL_ELEMENTOS 10

int contarElementos(int *arr, int capacidadMaxima) {
    int contador = 0;
    for (int i = 0; i < capacidadMaxima; i++) {
        if (arr[i] != 0) {
            contador++;
        } else {
            break;
        }
    }
    return contador;
}

void pasarEnteros(int *enteros, int *totalElementos, int capacidadMaxima) {
    char control = 's';
    int i = *totalElementos;

    while (control == 's' && i < capacidadMaxima) {
        printf("Ingrese un numero %d: ", i + 1);
        scanf("%d", &enteros[i]);

        printf("¿Quiere continuar? (s/n): ");
        fflush(stdin);
        scanf(" %c", &control);

        i++;
    }

    *totalElementos = i;
}

int main() {
    int enteros[TOTAL_ELEMENTOS] = {1, 2, 3};
    int totalElementos = contarElementos(enteros, TOTAL_ELEMENTOS);

    printf("Valores iniciales en el array: ");
    for (int i = 0; i < totalElementos; i++) {
        printf("%d ", enteros[i]);
    }
    printf("\n");

    pasarEnteros(enteros, &totalElementos, TOTAL_ELEMENTOS);

    printf("\nValores finales en el array: ");
    for (int i = 0; i < totalElementos; i++) {
        printf("%d ", enteros[i]);
    }
    printf("\nEl total de valores ingresados es: %d\n", totalElementos);

    return 0;
}
