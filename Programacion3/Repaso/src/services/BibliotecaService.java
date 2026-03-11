package services;

import models.*;
import interfaces.Prestable;
import exceptions.*;

import java.util.ArrayList;

public class BibliotecaService {

    private ArrayList<Material> materiales;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public BibliotecaService() {
        this.materiales = new ArrayList<Material>();
        this.usuarios = new ArrayList<Usuario>();
        this.prestamos = new ArrayList<Prestamo>();
    }

    public void registrarMaterial(Material material) {
        materiales.add(material);
        System.out.println("Material registrado correctamente: " + material.getTitulo());
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente: " + usuario.getNombre());
    }

    public Material buscarMaterialPorTitulo(String titulo) throws MaterialNoEncontradoException {
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return materiales.get(i);
            }
        }
        throw new MaterialNoEncontradoException("No se encontro ningun material con el titulo: " + titulo);
    }

    public Usuario buscarUsuarioPorId(int id) throws UsuarioNoEncontradoException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                return usuarios.get(i);
            }
        }
        throw new UsuarioNoEncontradoException("No se encontro ningun usuario con el ID: " + id);
    }

    public void realizarPrestamo(int idUsuario, String tituloMaterial, int dias)
            throws UsuarioNoEncontradoException, MaterialNoEncontradoException,
                   LimitePrestamosException, PrestamoInvalidoException, MaterialNoDisponibleException {

        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Material material = buscarMaterialPorTitulo(tituloMaterial);

        Prestamo prestamo = new Prestamo(usuario, material, dias);

        ((Prestable) material).prestar();
        usuario.agregarPrestamo(prestamo);
        prestamos.add(prestamo);

        System.out.println("Prestamo realizado exitosamente.");
        System.out.println(prestamo);
    }

    public void registrarDevolucion(int idUsuario, String tituloMaterial)
            throws UsuarioNoEncontradoException, MaterialNoEncontradoException, PrestamoInvalidoException {

        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Material material = buscarMaterialPorTitulo(tituloMaterial);

        Prestamo prestamoEncontrado = null;
        ArrayList<Prestamo> prestamosUsuario = usuario.getPrestamosActivos();

        for (int i = 0; i < prestamosUsuario.size(); i++) {
            if (prestamosUsuario.get(i).getMaterial() == material) {
                prestamoEncontrado = prestamosUsuario.get(i);
                break;
            }
        }

        if (prestamoEncontrado == null) {
            throw new PrestamoInvalidoException(
                "El usuario '" + usuario.getNombre() + "' no tiene un prestamo activo del material '" + tituloMaterial + "'."
            );
        }

        ((Prestable) material).devolver();
        usuario.quitarPrestamo(prestamoEncontrado);

        System.out.println("Devolucion registrada exitosamente para: " + tituloMaterial);
    }

    public void listarMateriales() {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        System.out.println("=== Materiales de la Biblioteca ===");
        for (int i = 0; i < materiales.size(); i++) {
            System.out.println((i + 1) + ". " + materiales.get(i));
        }
    }

    public void listarMaterialesDisponibles() {
        System.out.println("=== Materiales Disponibles ===");
        boolean hayDisponibles = false;
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i).isDisponible()) {
                System.out.println("- " + materiales.get(i));
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay materiales disponibles en este momento.");
        }
    }

    public void listarPrestamosDeUsuario(int idUsuario) throws UsuarioNoEncontradoException {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        ArrayList<Prestamo> prestamosUsuario = usuario.getPrestamosActivos();

        System.out.println("=== Prestamos activos de: " + usuario.getNombre() + " ===");
        if (prestamosUsuario.isEmpty()) {
            System.out.println("Este usuario no tiene prestamos activos.");
            return;
        }
        for (int i = 0; i < prestamosUsuario.size(); i++) {
            System.out.println((i + 1) + ". " + prestamosUsuario.get(i));
        }
    }

    public void listarTodosPrestamos() {
        System.out.println("=== Todos los Prestamos Registrados ===");
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos registrados.");
            return;
        }
        for (int i = 0; i < prestamos.size(); i++) {
            System.out.println((i + 1) + ". " + prestamos.get(i));
        }
    }

    public int contarMaterialesDisponibles() {
        int contador = 0;
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i).isDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    public Material getMaterialMasAntiguo() {
        if (materiales.isEmpty()) {
            return null;
        }
        Material masAntiguo = materiales.get(0);
        for (int i = 1; i < materiales.size(); i++) {
            if (materiales.get(i).compareTo(masAntiguo) < 0) {
                masAntiguo = materiales.get(i);
            }
        }
        return masAntiguo;
    }

    public void listarLibrosPorAutor(String autor) {
        System.out.println("=== Libros del autor: " + autor + " ===");
        boolean encontrado = false;
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i) instanceof Libro) {
                Libro libro = (Libro) materiales.get(i);
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    System.out.println("- " + libro);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros de ese autor.");
        }
    }

    public Usuario getUsuarioConMasPrestamos() {
        if (usuarios.isEmpty()) {
            return null;
        }
        Usuario mayor = usuarios.get(0);
        for (int i = 1; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCantidadPrestamos() > mayor.getCantidadPrestamos()) {
                mayor = usuarios.get(i);
            }
        }
        return mayor;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
}

