public class Amigo {
    private String nombre;
    private boolean piloto;
    private Nave nave;

    public Amigo(String nombre, boolean piloto, Nave nave) {
        this.nombre = nombre;
        this.piloto = piloto;
        this.nave = nave;
    }

    public Nave getNave() {
        return nave;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "nombre='" + nombre + '\'' +
                ", piloto=" + piloto +
                ", nave=" + nave +
                '}';
    }
}
