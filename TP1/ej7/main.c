#include <stdio.h>
#include <stdlib.h>

int num1, num2;

int main() {
    printf("Realizar una función que reciba dos números enteros por parámetro por referencia y cargue sus valores el usuario dentro de la función\n\n");
    cargarNumeros();
    printf("Los números ingresados son: %d y %d\n", num1, num2);

    return 0;
}

void cargarNumeros() {
    printf("Ingrese el primer numero: ");
    scanf("%d", &num1);
    printf("Ingrese el segundo numero: ");
    scanf("%d", &num2);
}
