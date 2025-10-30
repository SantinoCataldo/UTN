public class Evento {
    private String nombre;
    private int anio;
    private boolean ganada;

    public Evento(String nombre, int anio, boolean ganada) {
        this.nombre = nombre;
        this.anio = anio;
        this.ganada = ganada;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", ganada=" + ganada +
                '}';
    }
}
