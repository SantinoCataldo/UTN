package app;

import models.*;
import services.BibliotecaService;
import exceptions.*;

import java.util.Scanner;

public class Menu {

    private BibliotecaService servicio;
    private Scanner scanner;

    public Menu() {
        this.servicio = new BibliotecaService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            procesarOpcion(opcion);
        } while (opcion != 10);
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("       BIBLIOTECA UNIVERSITARIA          ");
        System.out.println("==========================================");
        System.out.println("  1.  Registrar un nuevo libro");
        System.out.println("  2.  Registrar una nueva revista");
        System.out.println("  3.  Registrar un usuario");
        System.out.println("  4.  Listar todos los materiales");
        System.out.println("  5.  Realizar un prestamo");
        System.out.println("  6.  Registrar devolucion");
        System.out.println("  7.  Prestamos de un usuario");
        System.out.println("  8.  Mostrar materiales disponibles");
        System.out.println("  9.  Usuario con mas prestamos");
        System.out.println("  10. Salir");
        System.out.println("==========================================");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarLibro();
                break;
            case 2:
                registrarRevista();
                break;
            case 3:
                registrarUsuario();
                break;
            case 4:
                servicio.listarMateriales();
                break;
            case 5:
                realizarPrestamo();
                break;
            case 6:
                registrarDevolucion();
                break;
            case 7:
                verPrestamosUsuario();
                break;
            case 8:
                servicio.listarMaterialesDisponibles();
                mostrarEstadisticas();
                break;
            case 9:
                mostrarUsuarioConMasPrestamos();
                break;
            case 10:
                System.out.println("Saliendo del sistema. Hasta pronto!");
                break;
            default:
                System.out.println("Opcion no valida. Intente nuevamente.");
        }
    }

    private void registrarLibro() {
        System.out.println("--- Registrar Libro ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        int anio = leerEntero("Anio de publicacion: ");

        Libro libro = new Libro(titulo, autor, anio);
        servicio.registrarMaterial(libro);
    }

    private void registrarRevista() {
        System.out.println("--- Registrar Revista ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();
        int anio = leerEntero("Anio de publicacion: ");
        int edicion = leerEntero("Numero de edicion: ");

        Revista revista = new Revista(titulo, anio, edicion);
        servicio.registrarMaterial(revista);
    }

    private void registrarUsuario() {
        System.out.println("--- Registrar Usuario ---");
        int id = leerEntero("ID de usuario: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        Usuario usuario = new Usuario(id, nombre);
        servicio.registrarUsuario(usuario);
    }

    private void realizarPrestamo() {
        System.out.println("--- Realizar Prestamo ---");
        int idUsuario = leerEntero("ID del usuario: ");
        System.out.print("Titulo del material: ");
        String titulo = scanner.nextLine().trim();
        int dias = leerEntero("Dias de prestamo: ");

        try {
            servicio.realizarPrestamo(idUsuario, titulo, dias);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (MaterialNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (LimitePrestamosException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (PrestamoInvalidoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (MaterialNoDisponibleException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void registrarDevolucion() {
        System.out.println("--- Registrar Devolucion ---");
        int idUsuario = leerEntero("ID del usuario: ");
        System.out.print("Titulo del material a devolver: ");
        String titulo = scanner.nextLine().trim();

        try {
            servicio.registrarDevolucion(idUsuario, titulo);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (MaterialNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (PrestamoInvalidoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void verPrestamosUsuario() {
        int idUsuario = leerEntero("ID del usuario: ");
        try {
            servicio.listarPrestamosDeUsuario(idUsuario);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void mostrarEstadisticas() {
        int disponibles = servicio.contarMaterialesDisponibles();
        System.out.println("Total de materiales disponibles: " + disponibles);

        Material masAntiguo = servicio.getMaterialMasAntiguo();
        if (masAntiguo != null) {
            System.out.println("Material mas antiguo: " + masAntiguo);
        }
    }

    private void mostrarUsuarioConMasPrestamos() {
        Usuario usuario = servicio.getUsuarioConMasPrestamos();
        if (usuario == null) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("=== Usuario con mas prestamos activos ===");
            System.out.println(usuario);
        }
    }

    private int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String linea = scanner.nextLine();
            try {
                valor = Integer.parseInt(linea.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero entero valido.");
            }
        }
        return valor;
    }
}

