public abstract class Contenido {
    private String titulo;
    private int lanzamiento;
    private Director director;

    public Contenido(String titulo, int lanzamiento, Director director) {
        this.director = director;
        this.titulo = titulo;
        this.lanzamiento = lanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public Director getDirector() {
        return director;
    }

    public abstract void mostrarInfo();
}

class Pelicula extends Contenido {
    private int duracion;
    private int creditos;
    private String descripcion;

    public Pelicula(String titulo, int lanzamiento, Director director, int duracion,int creditos, String descripcion) {
        super(titulo, lanzamiento, director);
        this.duracion = duracion;
        this.creditos = creditos;
        this.descripcion = descripcion;
    }

    public int duracionTotal() {
        return duracion + creditos;
    }

    public void mostrarInfo() {
        System.out.println("--- Película ---");
        System.out.println("Direcor: " + getDirector().getNombre() + " (" + getDirector().getNacionalidad() + ")");
        System.out.println("Título: " + getTitulo());
        System.out.println("Año de lanzamiento: " + getLanzamiento());
        System.out.println("Duración: " + duracionTotal() + " minutos");
        System.out.println((duracion + creditos)>=120?"Versión extendida":"Versión estándar");
        System.out.println("Descripción: " + descripcion);
    }
}

class Serie extends Contenido {
    private int temporadas;
    private int capitulos;
    private boolean finalizada;

    public Serie(String titulo, int lanzamiento, Director director, int temporadas, int capitulos, boolean finalizada) {
        super(titulo, lanzamiento, director);
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.finalizada = finalizada;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void mostrarInfo() {
        System.out.println("----SERIE----");
        System.out.println("Direcor: " + getDirector().getNombre() + " (" + getDirector().getNacionalidad() + ")");
        System.out.println("Título: " + getTitulo());
        System.out.println("Año de lanzamiento: " + getLanzamiento());
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Capítulos: " + capitulos);
        System.out.println("Finalizada: " + (finalizada ? "Sí" : "No"));
        System.out.println((temporadas <= 1 && finalizada)?"Miniserie":"Serie");
    }
}