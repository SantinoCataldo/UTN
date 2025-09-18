package ej3;

import java.util.Stack;

public class ListaBasica implements Reproduccion {
    private String nombre;
    private Stack<Cancion> miLista = new Stack<>();

    public ListaBasica(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void reproducir(Cancion x) {
        if (miLista.isEmpty()) {
            System.out.println("No hay canciones en la lista.");
            return;
        }
        Cancion cancion = miLista.remove(0);
        System.out.println("---------------------------");
        System.out.println("Reproduciendo: " + cancion.getNombre());
        System.out.println("Álbum: " + cancion.getAlbum().getTitulo());
        System.out.println("Género: " + cancion.getGenero());
        System.out.println("Artista: " + cancion.getAlbum().getArtista().getNombre());
        if (cancion.getArtistaIvitado() != null) {
            System.out.println("Artista invitado: " + cancion.getArtistaIvitado().getNombre());
        }
        System.out.println("---------------------------");
        miLista.add(cancion);
    }

    @Override
    public void añadirCancion(Cancion cancion) {
        miLista.add(cancion);
        System.out.println("Canción añadida: " + cancion.getNombre());
    }

    @Override
    public void eliminarCancion(Cancion cancion) {
        System.out.println("Para acceder a estas opciones, compre el paquete PREMIUM");
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
