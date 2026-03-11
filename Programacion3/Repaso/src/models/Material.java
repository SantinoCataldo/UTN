package models;

public abstract class Material implements Comparable<Material> {

    private String titulo;
    private int anioPublicacion;
    private boolean disponible;

    public Material(String titulo, int anioPublicacion) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public int compareTo(Material otro) {
        return Integer.compare(this.anioPublicacion, otro.anioPublicacion);
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
               " | Anio: " + anioPublicacion +
               " | Disponible: " + (disponible ? "Si" : "No");
    }
}

