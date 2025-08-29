public class Main {
    public static void main(String[] args) {
        Director d1 = new Director("Steven Spielberg", "USA");
        Director d2 = new Director("Christopher Nolan", "Reino Unido");
        Director d3 = new Director("Vince Gilligan", "USA");
        Director d4 = new Director("David Fincher", "USA");
        Director d5 = new Director("Peter Jackson", "Nueva Zelanda");
        Director d6 = new Director("Ryan Murphy", "USA");

        Contenido[] contenidos = new Contenido[] {
            new Pelicula("E.T.", 1982, d1, 115, 10, "Un niño y un extraterrestre."),
            new Pelicula("Jurassic Park", 1993, d1, 127, 9, "Dinosaurios vivos."),
            new Pelicula("Inception", 2010, d2, 148, 12, "Sueños dentro de sueños."),
            new Pelicula("Interstellar", 2014, d2, 169, 15, "Viaje interestelar para salvar la humanidad."),
            new Pelicula("El Señor de los Anillos", 2001, d5, 178, 14, "La aventura épica en la Tierra Media."),
            new Serie("Breaking Bad", 2008, d3, 5, 62, true),
            new Serie("Chernobyl", 2019, d4, 1, 5, true),
            new Serie("Band of Brothers", 2001, d5, 1, 10, true),
            new Serie("American Crime Story", 2016, d6, 3, 29, false)
        };

        mostrarPorTitulo(contenidos, "Breaking Bad");

        mostrarMiniseries(contenidos);

        mostrarPeliculasPorDirector(contenidos, "Christopher Nolan");
    }

    public static void mostrarPorTitulo(Contenido[] contenidos, String titulo) {
        System.out.println("--------------------");
        System.out.println("Buscando contenido con título: " + titulo);
        for (Contenido c : contenidos) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                c.mostrarInfo();
                return;
            }
        }
        System.out.println("No se encontró contenido con ese título.");
    }

    public static void mostrarMiniseries(Contenido[] contenidos) {
        System.out.println("--------------------");
        System.out.println("Miniseries encontradas:");
        for (Contenido c : contenidos) {
            if (c instanceof Serie s) {
                if (s.getTemporadas() == 1) {
                    s.mostrarInfo();
                }
            }
        }
    }

    public static void mostrarPeliculasPorDirector(Contenido[] contenidos, String nombreDirector) {
        System.out.println("Películas dirigidas por: " + nombreDirector);
        for (Contenido c : contenidos) {
            if (c instanceof Pelicula && c.getDirector().getNombre().equalsIgnoreCase(nombreDirector)) {
                c.mostrarInfo();
            }
        }
    }
}