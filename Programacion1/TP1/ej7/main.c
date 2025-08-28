#include <stdio.h>
#include <stdlib.h>

int num1, num2;

int main() {
    printf("Realizar una funci�n que reciba dos n�meros enteros por par�metro por referencia y cargue sus valores el usuario dentro de la funci�n\n\n");
    cargarNumeros();
    printf("Los numeros ingresados son: %d y %d\n", num1, num2);

    return 0;
}

void cargarNumeros() {
    printf("Ingrese el primer numero: ");
    scanf("%d", &num1);
    printf("Ingrese el segundo numero: ");
    scanf("%d", &num2);
}
