package Ej3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
    private int numRandom;
    private static int numIntentos = 0;

    public Juego (){
        this.numRandom = (int) (Math.random() * 500) + 1;
    }

    Scanner sc = new Scanner(System.in);
    public boolean ingresarNum(){
        try {
            System.out.println("Ingrese el numero:");
            int numero = sc.nextInt();

            if (numero > numRandom){
                System.out.println("El numero ingresado es mayor que el buscado");
                numIntentos++;
                return false;
            } else if (numero < numRandom){
                System.out.println("El numero ingresado es menor que el buscado");
                numIntentos++;
                return false;
            } else {
                System.out.println("El numero ingresado es el indicado yeeea \nNumero de intentos: " + numIntentos);
                return true;
            }
        } catch (InputMismatchException e){
            System.out.println("Esta todo mal te sumo un intento por gil");
            numIntentos++;
            sc.next();
            return false;
        }
    }

    public void adivinarNum(){
        ingresarNum();
        while (!ingresarNum()){
            ingresarNum();
        }
    }

    public int getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(int numRandom) {
        this.numRandom = numRandom;
    }

    public static int getNumIntentos() {
        return numIntentos;
    }

    public static void setNumIntentos(int numIntentos) {
        Juego.numIntentos = numIntentos;
    }
}
