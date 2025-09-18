package Ej1;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 20.5, 1967);
        Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 15.0, 1605);
        Libro libro3 = new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", 18.0, 2001);
        Libro libro4 = new Libro("El Amor en los Tiempos del Cólera", "Gabriel García Márquez", 22.0, 1985);

        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);

        libros.remove(0);

        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Precio: $" + libro.getPrecio());
            System.out.println("Año de Publicación: " + libro.getAnioPublicacion());
            System.out.println("---------------------------");
        }

        String elementoBuscado = "Don Quijote de la Mancha";
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(elementoBuscado)) {
                System.out.println("Elemento encontrado");
                break;
            }
        }

        libros.set(2, new Libro("1984", "George Orwell", 17.0, 1949));

        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Precio: $" + libro.getPrecio());
            System.out.println("Año de Publicación: " + libro.getAnioPublicacion());
            System.out.println("---------------------------");
        }

        double precioTotal = 0;

        for (Libro libro : libros) {
            precioTotal += libro.getPrecio();
        }
        System.out.println("Precio total de todos los libros: $" + precioTotal);

        System.out.println("Total de libros: " + libros.size());

        Libro libroMasCaro = libros.get(0);
        Libro libroMasBarato = libros.get(0);

        for (Libro libro : libros) {
            if (libro.getPrecio() > libroMasCaro.getPrecio()) {
                libroMasCaro = libro;
            }
            if (libro.getPrecio() < libroMasBarato.getPrecio()) {
                libroMasBarato = libro;
            }
        }

        System.out.println("Ej1.Libro más caro: " + libroMasCaro.getTitulo() + " ($" + libroMasCaro.getPrecio() + ")");
        System.out.println("Ej1.Libro más barato: " + libroMasBarato.getTitulo() + " ($" + libroMasBarato.getPrecio() + ")");
    }
}