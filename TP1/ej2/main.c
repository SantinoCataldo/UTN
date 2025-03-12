#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Disenie una funcion que reciba 3 números enteros y muestre el mayor y el menor\n\n");
    mayorMenor(3,2,7);
    mayorMenor(21,5,4);
    return 0;
}

void mayorMenor (int num1, int num2, int num3){
    int mayor = num1, menor = num1;

    if (num2 > mayor) mayor = num2;
    if (num3 > mayor) mayor = num3;

    if (num2 < menor) menor = num2;
    if (num3 < menor) menor = num3;

    printf("\nEl mayor es: %d\nEl menor es: %d\n", mayor, menor);
}
