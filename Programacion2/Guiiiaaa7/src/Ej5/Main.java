package Ej5;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear un empleado y guardarlo correctamente
        Empleado empleadoOriginal = new Empleado(1, "Ana Torres", 45000, "Desarrollo");
        empleadoOriginal.guardarJson("empleado_correcto.json");
        System.out.println("---------------------------------");

        // --- Demostración de manejo de errores ---

        // 1. Intentar cargar un archivo que no existe
        System.out.println("Intentando cargar un archivo inexistente...");
        Empleado.cargarDesdeJson("archivo_inexistente.json");
        System.out.println("---------------------------------");

        // 2. Intentar cargar un archivo con JSON mal formado
        try (FileWriter file = new FileWriter("empleado_malformado.json")) {
            file.write("{'id': 2, 'nombre': 'Carlos Ruiz', 'salario': 50000, 'departamento': 'Ventas',,}"); // Coma extra
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Intentando cargar un archivo con JSON mal formado...");
        Empleado.cargarDesdeJson("empleado_malformado.json");
        System.out.println("---------------------------------");

        // 3. Intentar cargar un archivo con campos faltantes
        try (FileWriter file = new FileWriter("empleado_incompleto.json")) {
            file.write("{\"id\": 3, \"nombre\": \"Laura Gomez\", \"salario\": 52000}"); // Falta departamento
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Intentando cargar un archivo con campos faltantes...");
        Empleado.cargarDesdeJson("empleado_incompleto.json");
        System.out.println("---------------------------------");

        // --- Demostración del caso exitoso ---
        System.out.println("Intentando cargar el archivo correcto...");
        Empleado empleadoCargado = Empleado.cargarDesdeJson("empleado_correcto.json");
        if (empleadoCargado != null) {
            System.out.println("Empleado cargado exitosamente:");
            System.out.println(empleadoCargado);
        }
    }
}
