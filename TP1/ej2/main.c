#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Disenie una funcion que reciba 3 números enteros y muestre el mayor y el menor");
    Ordenado(3,2,7);
    Ordenado(21,5,4);
    return 0;
}

void Ordenado (int num1, int num2, int num3){
    if(num1>num2 && num1 > num3){
    if (num2 > num3){
        printf("\nEl orden de los numeros es: \nn1: %d\nn2: %d\nn3: %d", num1, num2, num3);
    }else {
        printf("\nEl orden de los numeros es: \nn1: %d\nn2: %d\nn3: %d", num1, num3, num2);
    }
    }else if (num2>num1 &&num2 > num3){
        if(num1 > num3){
            printf("\nEl orden de los numeros es: \nn1: %d\nn2: %d\nn3: %d", num2, num1, num3);
        }else{
            printf("\nEl orden de los numeros es: \nn1: %d\nn2: %d\nn3°: %d", num2, num3, num1);
        }
    }else {
           if(num1 > num2){
            printf("\nEl orden de los numeros es: \nn1: %d\nn2: %d\nn3: %d", num3, num1, num2);
        }else{
            printf("\nEl orden de los numeros es: \nn1: %d\nn2: %d\nn3: %d", num3, num2, num1);
        }
    }
}
