package Ej2;

public class Main {
    public static void main(String[] args) {
        Pila<Integer> pilaDeEnteros = new Pila<>();
        pilaDeEnteros.agregar(1);
        pilaDeEnteros.agregar(2);
        pilaDeEnteros.agregar(3);

        System.out.println("Tamaño de la pila de enteros: " + pilaDeEnteros.tamanio());
        System.out.println("Elemento quitado: " + pilaDeEnteros.quitar());
        System.out.println("Tamaño de la pila de enteros: " + pilaDeEnteros.tamanio());

        Pila<String> pilaDeCadenas = new Pila<>();
        pilaDeCadenas.agregar("Hola");
        pilaDeCadenas.agregar("Mundo");

        System.out.println("\nTamaño de la pila de cadenas: " + pilaDeCadenas.tamanio());
        System.out.println("¿La pila de cadenas está vacía? " + pilaDeCadenas.estaVacia());
        System.out.println("Elemento quitado: " + pilaDeCadenas.quitar());
        System.out.println("Elemento quitado: " + pilaDeCadenas.quitar());
        System.out.println("¿La pila de cadenas está vacía? " + pilaDeCadenas.estaVacia());
    }
}
