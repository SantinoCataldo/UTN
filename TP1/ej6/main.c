#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1, negativo;
    printf("Realizar una funcion que reciba un numero positivo entero por parametro por referencia, y cambie su signo a negativo\n\n");
    printf ("Ingrese un numero:");
    scanf("%d", &num1);
    negativo = numNegativo(num1);
    printf("El numero en negativo es: %d", negativo);

    return 0;
}

int numNegativo(int num){
    int cuenta = num * (-1);

    return cuenta;
}
