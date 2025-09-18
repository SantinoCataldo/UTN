package ej3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cancion> todasLasCanciones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        crearCancionesEjemplo();

        Reproduccion lista = seleccionarTipoLista();

        mostrarMenuPrincipal(lista);
    }

    private static void crearCancionesEjemplo() {
        // Crear artistas
        Artista duki = new Artista("Duki", 27, "Argentina");
        Artista badBunny = new Artista("Bad Bunny", 29, "Puerto Rico");
        Artista metallica = new Artista("Metallica", 40, "Estados Unidos");
        Artista milesDavis = new Artista("Miles Davis", 65, "Estados Unidos");
        Artista beethoven = new Artista("Ludwig van Beethoven", 56, "Alemania");

        // Crear álbumes
        Album dfdm = new Album("Desde el Fin del Mundo", duki, 2021);
        Album yhlqmdlg = new Album("YHLQMDLG", badBunny, 2020);
        Album masterOfPuppets = new Album("Master of Puppets", metallica, 1986);
        Album kindOfBlue = new Album("Kind of Blue", milesDavis, 1959);
        Album symphony9 = new Album("Symphony No. 9", beethoven, 1824);

        // Crear canciones
        todasLasCanciones.add(new Cancion("Goteo", 180, Genero.TRAP, null, dfdm));
        todasLasCanciones.add(new Cancion("Chico Estrella", 200, Genero.TRAP, badBunny, dfdm));
        todasLasCanciones.add(new Cancion("Safaera", 290, Genero.TRAP, null, yhlqmdlg));
        todasLasCanciones.add(new Cancion("Master of Puppets", 515, Genero.METAL, null, masterOfPuppets));
        todasLasCanciones.add(new Cancion("Battery", 312, Genero.METAL, null, masterOfPuppets));
        todasLasCanciones.add(new Cancion("So What", 563, Genero.JAZZ, null, kindOfBlue));
        todasLasCanciones.add(new Cancion("Ode to Joy", 1020, Genero.CLASICA, null, symphony9));
    }

    private static Reproduccion seleccionarTipoLista() {
        System.out.println("=== BIENVENIDO A SPOTIFY ===");
        System.out.println("Selecciona el tipo de cuenta:");
        System.out.println("1. Lista Básica (Gratis)");
        System.out.println("2. Lista Premium");
        System.out.print("Ingresa tu opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingresa el nombre de tu lista: ");
        String nombre = scanner.nextLine();

        if (opcion == 2) {
            return new ListaPremium(nombre);
        } else {
            return new ListaBasica(nombre);
        }
    }

    private static void mostrarMenuPrincipal(Reproduccion lista) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducir");
            System.out.println("2. Añadir canción");
            System.out.println("3. Eliminar canción");
            System.out.println("4. Ver mi lista");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    lista.reproducir();
                    esperarPausa();
                    break;
                case 2:
                    añadirCancionDesdeCatalogo(lista);
                    break;
                case 3:
                    lista.eliminarCancion();
                    break;
                case 4:
                    lista.verMiLista();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar Spotify!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void añadirCancionDesdeCatalogo(Reproduccion lista) {
        System.out.println("\n=== CATÁLOGO DE CANCIONES ===");
        for (int i = 0; i < todasLasCanciones.size(); i++) {
            Cancion c = todasLasCanciones.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " - " +
                             c.getAlbum().getArtista().getNombre() + " (" + c.getGenero() + ")");
        }

        System.out.print("Selecciona el número de la canción a añadir: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= todasLasCanciones.size()) {
            Cancion cancionSeleccionada = todasLasCanciones.get(opcion - 1);
            lista.añadirCancion(cancionSeleccionada);
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void esperarPausa() {
        System.out.println("\nPresiona 'p' y Enter para pausar y volver al menú principal:");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("p")) {
            System.out.println("Canción pausada. Volviendo al menú principal...");
        }
    }
}
