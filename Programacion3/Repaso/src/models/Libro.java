package models;

import interfaces.Prestable;

public class Libro extends Material implements Prestable {

    private String autor;

    public Libro(String titulo, String autor, int anioPublicacion) {
        super(titulo, anioPublicacion);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void prestar() {
        setDisponible(false);
    }

    @Override
    public void devolver() {
        setDisponible(true);
    }

    @Override
    public String toString() {
        return "[Libro] " + super.toString() + " | Autor: " + autor;
    }
}

