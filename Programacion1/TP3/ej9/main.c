#include <stdio.h>
#include <stdlib.h>
///Realizar una función que determine si un arreglo es capicúa

void cargarAleatorio(int *enteros, int maxValores){
    int num = 0;
    for (int i = 0; i < maxValores; i++){
        num = rand() % 2;
        enteros[i] = num;
    }
}

int esCapicua(int *capicua, int *enteros, int maxValores){
    int flag = 1;

    for(int i = 0; i < maxValores; i++){
        capicua[maxValores - 1 - i] = enteros[i];
    }

    for(int i = 0; i < maxValores; i++){
        if(enteros[i] != capicua[i]){
        flag = 0;
        break;
    }
    }

    return flag;
}

int main()
{
    srand(time(NULL));
    int maxValores = 4;
    int enteros[maxValores];
    int capicua[maxValores];

    cargarAleatorio(enteros, maxValores);
    int flag = esCapicua(capicua, enteros, maxValores);

    for(int i = 0; i < maxValores; i++){
        printf("%d, ", enteros[i]);
    }

    printf("\n\n");

    for(int i = 0; i < maxValores; i++){
        printf("%d, ", capicua[i]);
    }

    if(flag){
        printf("\nEs Capicua");
    }else{
        printf("\nNo es Capicua");
    }

    return 0;
}
