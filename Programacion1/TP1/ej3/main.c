#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1, sumaTotal;
    printf("Diseñe una función que reciba un número entero N y realice la suma de los números enteros positivos menores que N y lo retorne. N es un  dato ingresado por el usuario en el main\n\n");
    printf ("Ingrese un numero:");
    scanf("%d", &num1);
    sumaTotal = suma(num1);
    printf("La suma de los numeros da: %d", sumaTotal);

    return 0;
}

int suma(int num){
    int suma = 0;
    for (int i = 0; i < num; i++){
        suma += i;
    }

    return suma;
}
