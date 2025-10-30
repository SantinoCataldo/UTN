import java.util.Objects;

public class Pasajeros {
    private int dni;
    private String nombre;
    private String asientoAsignado;

    public Pasajeros(int dni, String nombre, String asientoAsignado) {
        this.dni = dni;
        this.nombre = nombre;
        this.asientoAsignado = asientoAsignado;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAsientoAsignado() {
        return asientoAsignado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasajeros pasajero = (Pasajeros) o;
        return dni == pasajero.dni || Objects.equals(asientoAsignado, pasajero.asientoAsignado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, asientoAsignado);
    }
}
