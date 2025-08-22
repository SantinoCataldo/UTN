public class Libro {
    private String titulo;
    private String autor;
    private int precio;
    private int cantidad;
    private int id;
    private static int contId = 0;

    public Libro(String titulo, String autor, int precio, int cantidad){

        this.id = contId++;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    public void ventas(int ventasDisponibles){
        if(ventasDisponibles < cantidad){
            this.cantidad = cantidad - ventasDisponibles;
        } else {
            System.out.println("No hay tantos libros");
        }
    }

    public void ingreso(int ingresoDisponibles){
        this.cantidad = cantidad + ingresoDisponibles;
    }

    public void mostrarLibro(){
        System.out.println("Id= " + id + " Título= " + titulo + " Autor= " + autor + " Precio= " + precio + " copias disponibles= " + cantidad);
    }
}
