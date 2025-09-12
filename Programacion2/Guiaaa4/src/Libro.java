public class Libro {
    private String titulo;
    private String autor;
    private double precio;
    private int anioPublicacion;

    public Libro(String titulo, String autor, double precio, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
}
