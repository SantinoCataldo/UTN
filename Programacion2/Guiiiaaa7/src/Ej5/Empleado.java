package Ej5;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;

public class Empleado {
    private int id;
    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(int id, String nombre, double salario, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("nombre", nombre);
        json.put("salario", salario);
        json.put("departamento", departamento);
        return json;
    }

    public void guardarJson(String nombreArchivo) {
        try (FileWriter file = new FileWriter(nombreArchivo)) {
            file.write(this.toJson().toString(4));
            System.out.println("El archivo " + nombreArchivo + " se ha guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static Empleado cargarDesdeJson(String nombreArchivo) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            JSONObject json = new JSONObject(contenido);

            // Validación de campos
            String[] camposRequeridos = {"id", "nombre", "salario", "departamento"};
            for (String campo : camposRequeridos) {
                if (!json.has(campo)) {
                    System.err.println("Error de validación: El campo '" + campo + "' es requerido y no se encontró en el archivo.");
                    return null;
                }
            }

            int id = json.getInt("id");
            String nombre = json.getString("nombre");
            double salario = json.getDouble("salario");
            String departamento = json.getString("departamento");

            return new Empleado(id, nombre, salario, departamento);

        } catch (NoSuchFileException e) {
            System.err.println("Error: El archivo '" + nombreArchivo + "' no fue encontrado.");
        } catch (IOException e) {
            System.err.println("Error de E/S al leer el archivo: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error de formato JSON: El archivo '" + nombreArchivo + "' no contiene un JSON válido. " + e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
