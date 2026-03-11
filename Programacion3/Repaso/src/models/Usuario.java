package models;

import java.util.ArrayList;

public class Usuario {

    private static final int LIMITE_PRESTAMOS = 3;

    private int id;
    private String nombre;
    private ArrayList<Prestamo> prestamosActivos;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamosActivos = new ArrayList<Prestamo>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void agregarPrestamo(Prestamo prestamo) throws exceptions.LimitePrestamosException {
        if (prestamosActivos.size() >= LIMITE_PRESTAMOS) {
            throw new exceptions.LimitePrestamosException(
                "El usuario '" + nombre + "' ha alcanzado el limite de " + LIMITE_PRESTAMOS + " prestamos activos."
            );
        }
        prestamosActivos.add(prestamo);
    }

    public void quitarPrestamo(Prestamo prestamo) {
        prestamosActivos.remove(prestamo);
    }

    public int getCantidadPrestamos() {
        return prestamosActivos.size();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Prestamos activos: " + prestamosActivos.size();
    }
}

