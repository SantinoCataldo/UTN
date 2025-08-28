#include <stdio.h>
#include <stdlib.h>
#include <time.h>

///Realizar una funci�n que sume los elementos de un arreglo de n�meros reales (float) de dimensi�n 100.
///(se recomienda hacer una funci�n para cargar y otra para mostrar para este tipo de dato asociado al arreglo)

void cargarAleatorio(float *enteros, int maxValores){
    float num = 0.00;
    for (int i = 0; i < maxValores; i++){
        num = (float)rand()/(float)(RAND_MAX / maxValores);
        enteros[i] = num;
    }
}

void mostrarAleatorio(float *enteros, int maxValores, float *suma){
    for (int i = 0; i < maxValores; i++){
        printf("n%d: %f\n", i+1,  enteros[i]);
        *suma += enteros[i];
    }
}

int main()
{
    srand(time(NULL));
    int maxValores = 100;
    float suma = 0.0;
    float enteros[maxValores];
    cargarAleatorio(enteros, maxValores);
    mostrarAleatorio(enteros, maxValores, &suma);
    printf("La suma %f", suma);

    return 0;
}
