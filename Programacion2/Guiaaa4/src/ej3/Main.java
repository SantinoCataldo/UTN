package ej3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListaBasica miLista = new ListaBasica("Mi Lista de Reproducción");

        Artista duki = new Artista("Duki", 23, "Argentina");
        Artista leo = new Artista("Leo Mateoli", 45, "Argentina");

        Album dfdm = new Album("Desde el Fin del Mundo", duki, 2021);

        Cancion c1 = new Cancion("Goteo", 180, Genero.TRAP, null, dfdm);
        Cancion c2 = new Cancion("Chico Estrella", 200, Genero.TRAP, leo, dfdm);

        miLista.añadirCancion(c1);
        miLista.añadirCancion(c2);

        miLista.verMiLista();

        miLista.reproducir(c1);
        miLista.eliminarCancion(c1);
        miLista.reproducir(c1);
    }
}
