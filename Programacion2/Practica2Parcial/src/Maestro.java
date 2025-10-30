import java.util.List;

public class Maestro {
    private String nombre;
    private boolean es_jedi;
    private List<String> habilidades;

    public Maestro(String nombre, boolean es_jedi, List<String> habilidades) {
        this.nombre = nombre;
        this.es_jedi = es_jedi;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Maestro{" +
                "nombre='" + nombre + '\'' +
                ", es_jedi=" + es_jedi +
                ", habilidades=" + habilidades +
                '}';
    }
}
