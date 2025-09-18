package ej3;

import java.util.LinkedList;
import java.util.Scanner;

public class ListaPremium implements Reproduccion {
    private String nombre;
    private LinkedList<Cancion> miLista = new LinkedList<>();

    public ListaPremium(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void reproducir() {
        if (miLista.isEmpty()) {
            System.out.println("No hay canciones en la lista.");
            return;
        }

        System.out.println("Selecciona una canción para reproducir:");
        for (int i = 0; i < miLista.size(); i++) {
            Cancion c = miLista.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " - " + c.getAlbum().getArtista().getNombre());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de la canción: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= miLista.size()) {
            Cancion cancion = miLista.get(opcion - 1);
            System.out.println("---------------------------");
            System.out.println("Reproduciendo: " + cancion.getNombre());
            System.out.println("Álbum: " + cancion.getAlbum().getTitulo());
            System.out.println("Género: " + cancion.getGenero());
            System.out.println("Artista: " + cancion.getAlbum().getArtista().getNombre());
            if (cancion.getArtistaInvitado() != null) {
                System.out.println("Artista invitado: " + cancion.getArtistaInvitado().getNombre());
            }
            System.out.println("Presiona 'p' para pausar y volver al menú principal.");
            System.out.println("---------------------------");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    @Override
    public void añadirCancion(Cancion cancion) {
        miLista.add(cancion);
        System.out.println("Canción añadida: " + cancion.getNombre());
    }

    @Override
    public void eliminarCancion() {
        if (miLista.isEmpty()) {
            System.out.println("No hay canciones en la lista.");
            return;
        }

        System.out.println("Selecciona una canción para eliminar:");
        for (int i = 0; i < miLista.size(); i++) {
            Cancion c = miLista.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " - " + c.getAlbum().getArtista().getNombre());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de la canción a eliminar: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= miLista.size()) {
            Cancion cancionEliminada = miLista.remove(opcion - 1);
            System.out.println("Canción eliminada: " + cancionEliminada.getNombre());
        } else {
            System.out.println("Opción inválida.");
        }
    }

    @Override
    public void verMiLista() {
        if (miLista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Lista de reproducción Premium (" + nombre + "):");
        for (int i = 0; i < miLista.size(); i++) {
            Cancion c = miLista.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " - " + c.getAlbum().getArtista().getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }
}
