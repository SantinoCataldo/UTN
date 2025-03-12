#include <stdio.h>
#include <stdlib.h>

int main()
{
    int numA, numB, resultado;
    char control = 's';
    int opcion = 0;
    printf("Realice una pequeña calculadora, utilizando funciones (una función de suma, una de multiplicación, una de resta, una de división\n\n");

    while (control == 's'){
        printf("-----CASSIO-----\n\n");
        printf("1  -  Suma\n");
        printf("2  -  Resta\n");
        printf("3  -  Multiplicacion\n");
        printf("4  -  Division\n");

        printf("Elija la opcion: ");
        fflush(stdin);
        scanf("%d", &opcion);
        system("cls");

        switch(opcion){
            case 1:
                printf ("Ingrese dos numeros:\n\n");
                scanf("%d", &numA);
                scanf("%d", &numB);
                resultado=Suma(numA, numB);
                printf("El resultado de la suma es: %d\n", resultado);
                break;
            case 2:
                printf ("Ingrese dos numeros:\n\n");
                scanf("%d", &numA);
                scanf("%d", &numB);
                resultado=Resta(numA, numB);
                printf("El resultado de la resta es: %d\n", resultado);
                break;
            case 3:
                printf ("Ingrese dos numeros:\n\n");
                scanf("%d", &numA);
                scanf("%d", &numB);
                resultado=Multiplicacion(numA, numB);
                printf("El resultado de la multiplicacion es: %d\n", resultado);
                break;
            case 4:
                printf ("Ingrese dos numeros:\n\n");
                scanf("%d", &numA);
                scanf("%d", &numB);
                resultado=Division(numA, numB);
                printf("El resultado de la division es: %d\n", resultado);
                break;

            default:
                printf("Se equivoco bro\n");
                system("pause");
        }

        printf("\nQueres hacer otra cuenta? (s/n) ");
        fflush(stdin);
        scanf("%c", &control);
        system("cls");
    }

    return 0;
}

int Suma(int num1, int num2){
    int suma = num1+num2;
    return suma;
}

int Resta(int num1, int num2){
    int resta = num1-num2;

    return resta;
}

int Multiplicacion(int num1, int num2){
    int mult = num1*num2;

    return mult;
}

int Division(int num1, int num2){
    int div = num1/num2;

    return div;
}

