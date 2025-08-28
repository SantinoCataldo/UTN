public class Autor {
    private String nombre;
    private String apellido;
    private String email;
    private char genero;

    public Autor(String nombre, String apellido, String email, char genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
    }

    public String toString() {
        return nombre + " " + apellido + " (" + email + "), " + genero;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public char getGenero() { return genero; }
}

class Libro {
    private String titulo;
    private int precio;
    private int stock;
    private Autor autor;

    public Libro(String titulo, Autor autor, int precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void aumentarStock(int cantidad) {
        this.stock += cantidad;
    }

    public Autor getAutor() {
        return autor;
    }

    public String toString() {
        return "Libro: " + titulo + ", Autor: " + autor + ", Precio: " + precio + ", Stock: " + stock;
    }

    public void imprimirMensajeVenta() {
        System.out.println("El libro, " + titulo + " de " + autor.getNombre() + ". Se vende a " + precio + " pesos");
    }
}