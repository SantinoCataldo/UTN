package Ej5;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Prueba con enteros en orden ascendente
        ListaOrdenada<Integer> listaAscendente = new ListaOrdenada<Integer>(Comparator.naturalOrder());
        listaAscendente.agregar(5);
        listaAscendente.agregar(2);
        listaAscendente.agregar(8);
        System.out.println("Lista ascendente de enteros: " + listaAscendente);
        System.out.println("Elemento en la posición 1: " + listaAscendente.obtener(1));

        // Prueba con enteros en orden descendente
        ListaOrdenada<Integer> listaDescendente = new ListaOrdenada<Integer>(Comparator.reverseOrder());
        listaDescendente.agregar(5);
        listaDescendente.agregar(2);
        listaDescendente.agregar(8);
        System.out.println("\nLista descendente de enteros: " + listaDescendente);
        System.out.println("Elemento en la posición 0: " + listaDescendente.obtener(0));

        // Prueba con cadenas en orden alfabético
        ListaOrdenada<String> listaCadenas = new ListaOrdenada<String>(Comparator.naturalOrder());
        listaCadenas.agregar("Mundo");
        listaCadenas.agregar("Hola");
        listaCadenas.agregar("Java");
        System.out.println("\nLista de cadenas en orden alfabético: " + listaCadenas);
        listaCadenas.eliminar("Hola");
        System.out.println("Lista de cadenas después de eliminar \"Hola\": "  + listaCadenas);
    }
}
