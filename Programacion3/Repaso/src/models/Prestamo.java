package models;

import interfaces.Prestable;
import exceptions.PrestamoInvalidoException;
import exceptions.MaterialNoDisponibleException;

public class Prestamo {

    private Usuario usuario;
    private Material material;
    private int diasPrestamo;

    public Prestamo(Usuario usuario, Material material, int diasPrestamo)
            throws PrestamoInvalidoException, MaterialNoDisponibleException {

        if (diasPrestamo <= 0) {
            throw new PrestamoInvalidoException(
                "La cantidad de dias del prestamo debe ser mayor a cero."
            );
        }

        if (!(material instanceof Prestable)) {
            throw new PrestamoInvalidoException(
                "El material '" + material.getTitulo() + "' no es prestable."
            );
        }

        if (!material.isDisponible()) {
            throw new MaterialNoDisponibleException(
                "El material '" + material.getTitulo() + "' no se encuentra disponible."
            );
        }

        this.usuario = usuario;
        this.material = material;
        this.diasPrestamo = diasPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo => Usuario: " + usuario.getNombre() +
               " | Material: " + material.getTitulo() +
               " | Dias: " + diasPrestamo;
    }
}

