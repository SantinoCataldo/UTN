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
    public void reproducir(Cancion cancion) {
        if (miLista.isEmpty()) {
            System.out.println("No hay canciones en la lista.");
            return;
        }

        if (!miLista.contains(cancion)) {
            System.out.println("La canción no está en la lista.");
            return;
        }
        System.out.println("---------------------------");
        System.out.println("Reproduciendo: " + cancion.getNombre());
        System.out.println("Álbum: " + cancion.getAlbum().getTitulo());
        System.out.println("Género: " + cancion.getGenero());
        System.out.println("Artista: " + cancion.getAlbum().getArtista().getNombre());
        if (cancion.getArtistaIvitado() != null) {
            System.out.println("Artista invitado: " + cancion.getArtistaIvitado().getNombre());
        }
        System.out.println("---------------------------");
    }

    @Override
    public void añadirCancion(Cancion cancion) {
        miLista.add(cancion);
        System.out.println("Canción añadida: " + cancion.getNombre());
    }

    @Override
    public void eliminarCancion(Cancion cancion) {
        if (miLista.remove(cancion)) {
            System.out.println("Canción eliminada: " + cancion.getNombre());
        } else {
            System.out.println("La canción no está en la lista.");
        }
    }


    @Override
    public void verMiLista() {
        if (miLista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Lista de reproducción (" + nombre + "):");
        for (Cancion c : miLista) {
            System.out.println("- " + c.getNombre());
        }
    }
}
