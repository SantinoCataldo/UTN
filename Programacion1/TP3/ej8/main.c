#include <stdio.h>
#include <stdlib.h>

///Realizar una funci�n que obtenga el m�ximo car�cter de un arreglo dado.

char mayorCaracter(char *array){
    char mayor = 'a';

    printf("El valor del array es: ");
    for(int i = 0; i < 5; i++){
        printf("%c, ", array[i]);
        if(mayor < array[i]){
            mayor = array[i];
        }
    }

    return mayor;
}

int main()
{
    char caracteres[6]= {'a','t','c','v','e','e','a'};

    char mayor = mayorCaracter(caracteres);
    printf("\n\nEl mayor es: %c\n\n", mayor);
    return 0;
}
