import java.util.List;

public class Personaje {
    private String nombre;
    private int edad;
    private boolean jedi;
    private String planeta_nacimiento;
    private Maestro maestro;
    private List<Amigo> amigos;
    private List<Evento> eventos;

    public Personaje(String nombre, int edad, boolean jedi, String planeta_nacimiento, Maestro maestro, List<Amigo> amigos, List<Evento> eventos) {
        this.nombre = nombre;
        this.edad = edad;
        this.jedi = jedi;
        this.planeta_nacimiento = planeta_nacimiento;
        this.maestro = maestro;
        this.amigos = amigos;
        this.eventos = eventos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", jedi=" + jedi +
                ", planeta_nacimiento='" + planeta_nacimiento + '\'' +
                ", maestro=" + maestro +
                ", amigos=" + amigos +
                ", eventos=" + eventos +
                '}';
    }
}
