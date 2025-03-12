#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1;
    printf("Diseñe una función que reciba un número entero N y realice la suma de los números enteros positivos menores que N y lo retorne. N es un  dato ingresado por el usuario en el main\n\n");
    printf ("Ingrese un numero:");
    scanf("%d", &num1);
    suma(num1);

    return 0;
}

void suma(int num){
    int suma;
    for (int i = 0; i < num; i++){
        suma += i;
    }

    printf("La suma de los numeros da: %d", suma);
}
