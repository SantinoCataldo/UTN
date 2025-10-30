import java.util.Objects;

public class Vehiculos {
     private String patente;
     private String marca;
     private String modelo;
     private int capacidad;
     private int anio;

     public Vehiculos(String patente, String marca, String modelo, int capacidad, int anio) {
         this.patente = patente;
         this.marca = marca;
         this.modelo = modelo;
         this.capacidad = capacidad;
         this.anio = anio;
     }

     public String toString() {
         return "Patente: " + patente + " Marca: " + marca + " Modelo: " + modelo + " Capacidad: " + capacidad + " Anio: " + anio + "\n";
     }

    public String getPatente() {
        return patente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculos vehiculos = (Vehiculos) o;
        return Objects.equals(patente, vehiculos.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }
}
