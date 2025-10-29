package Ej3;

public class Main {
    public static void main(String[] args) {
        OperacionMatematica<Integer> opEnteros = new OperacionMatematica<>();
        opEnteros.setNum1(10);
        opEnteros.setNum2(5);

        System.out.println("Suma de enteros: " + opEnteros.sumar());
        System.out.println("Resta de enteros: " + opEnteros.restar());
        System.out.println("Multiplicación de enteros: " + opEnteros.multiplicar());
        System.out.println("División de enteros: " + opEnteros.dividir());

        OperacionMatematica<Double> opDobles = new OperacionMatematica<>();
        opDobles.setNum1(10.5);
        opDobles.setNum2(2.5);

        System.out.println("\nSuma de dobles: " + opDobles.sumar());
        System.out.println("Resta de dobles: " + opDobles.restar());
        System.out.println("Multiplicación de dobles: " + opDobles.multiplicar());
        System.out.println("División de dobles: " + opDobles.dividir());
    }
}
