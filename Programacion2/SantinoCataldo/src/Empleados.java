public class Empleados {
    private int dni;
    private String nombre;
    private String puesto;
    private int antiguedad;

    public Empleados(int dni, String nombre, String puesto, int antiguedad) {
        this.dni = dni;
        this.nombre = nombre;
        this.puesto = puesto;
        this.antiguedad = antiguedad;
    }

    public String toString() {
        return "DNI: " + dni + " Nombre: " + nombre + " Puesto: " + puesto + " Antiguedad: " + antiguedad + "\n";
    }

    public int getDni() {
        return dni;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleados empleados = (Empleados) o;
        return dni == empleados.dni;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }
}