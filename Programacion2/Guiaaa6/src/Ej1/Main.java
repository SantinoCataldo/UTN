package Ej1;

public class Main {
    public static void main(String[] args) {
        // --- Prueba con Strings ---
        System.out.println("### PRUEBAS CON STRINGS ###");
        Almacenamiento<String> almacenDeStrings = new Almacenamiento<>();
        almacenDeStrings.agregar("Hola");
        almacenDeStrings.agregar("Mundo");
        almacenDeStrings.agregar("Java");
        almacenDeStrings.imprimirItems();

        System.out.println("Buscando 'Mundo': " + (almacenDeStrings.buscar("Mundo") != null ? "Encontrado" : "No encontrado"));
        System.out.println("Buscando 'Adios': " + (almacenDeStrings.buscar("Adios") != null ? "Encontrado" : "No encontrado"));

        System.out.println("Eliminando 'Mundo'...");
        boolean eliminado = almacenDeStrings.eliminar("Mundo");
        System.out.println("¿Fue eliminado? " + eliminado);
        almacenDeStrings.imprimirItems();

        // --- Prueba con Integers ---
        System.out.println("\n### PRUEBAS CON INTEGERS ###");
        Almacenamiento<Integer> almacenDeEnteros = new Almacenamiento<>();
        almacenDeEnteros.agregar(10);
        almacenDeEnteros.agregar(25);
        almacenDeEnteros.agregar(42);
        almacenDeEnteros.imprimirItems();

        System.out.println("Buscando 42: " + (almacenDeEnteros.buscar(42) != null ? "Encontrado" : "No encontrado"));
        System.out.println("Eliminando 100 (no existe)...");
        boolean eliminadoEntero = almacenDeEnteros.eliminar(100);
        System.out.println("¿Fue eliminado? " + eliminadoEntero);
        almacenDeEnteros.imprimirItems();

        // --- Prueba con Objetos Personalizados (ej1.Ej2.Producto) ---
        System.out.println("\n### PRUEBAS CON OBJETOS PRODUCTO ###");
        Almacenamiento<Producto> almacenDeProductos = new Almacenamiento<>();
        Producto p1 = new Producto(1, "Laptop");
        Producto p2 = new Producto(2, "Mouse");
        Producto p3 = new Producto(3, "Teclado");

        almacenDeProductos.agregar(p1);
        almacenDeProductos.agregar(p2);
        almacenDeProductos.agregar(p3);
        almacenDeProductos.imprimirItems();

        // Creamos un objeto "igual" para buscar y eliminar, para demostrar que funciona gracias a equals()
        Producto productoABuscar = new Producto(2, "Mouse");
        System.out.println("Buscando producto con id=2: " + (almacenDeProductos.buscar(productoABuscar) != null ? "Encontrado" : "No encontrado"));

        Producto productoAEliminar = new Producto(3, "Teclado");
        System.out.println("Eliminando producto con id=3...");
        boolean eliminadoProducto = almacenDeProductos.eliminar(productoAEliminar);
        System.out.println("¿Fue eliminado? " + eliminadoProducto);
        almacenDeProductos.imprimirItems();
    }
}