package models;

public class Revista extends Material {

    private int numeroEdicion;

    public Revista(String titulo, int anioPublicacion, int numeroEdicion) {
        super(titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String toString() {
        return "[Revista] " + super.toString() + " | Edicion N: " + numeroEdicion;
    }
}

