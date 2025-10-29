package Ej4;

public class Main {
    public static void main(String[] args) {
        Conjunto<Integer> conjuntoDeEnteros = new Conjunto<>();
        conjuntoDeEnteros.agregar(1);
        conjuntoDeEnteros.agregar(2);
        conjuntoDeEnteros.agregar(3);
        conjuntoDeEnteros.agregar(1); // No se agregará, ya que es un duplicado

        System.out.println("Conjunto de enteros: " + conjuntoDeEnteros);
        System.out.println("¿El conjunto contiene el 2? " + conjuntoDeEnteros.contiene(2));
        System.out.println("¿El conjunto contiene el 4? " + conjuntoDeEnteros.contiene(4));

        conjuntoDeEnteros.eliminar(2);
        System.out.println("Conjunto de enteros después de eliminar el 2: " + conjuntoDeEnteros);

        Conjunto<String> conjuntoDeCadenas = new Conjunto<>();
        conjuntoDeCadenas.agregar("Hola");
        conjuntoDeCadenas.agregar("Mundo");
        conjuntoDeCadenas.agregar("Hola"); // No se agregará

        System.out.println("\nConjunto de cadenas: " + conjuntoDeCadenas);
        System.out.println("¿El conjunto contiene \"Hola\"? " + conjuntoDeCadenas.contiene("Hola"));
        System.out.println("¿El conjunto contiene \"Adiós\"? " + conjuntoDeCadenas.contiene("Adiós"));
    }
}
