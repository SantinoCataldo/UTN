public class Chofer {
    private String nombre;
    private String apellido;
    private int dni;
    private float salarioKM;

    public Chofer(String nombre, String apellido, int dni, float salarioKM) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salarioKM = salarioKM;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public float getSalarioKM() {
        return salarioKM;
    }
}