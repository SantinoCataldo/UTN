package Ej1;

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private String sexo;

    public Persona(String nombre, int edad, String dni, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
    }

    public void guardarJson() {
        JSONObject json = new JSONObject(this);
        try (FileWriter file = new FileWriter("persona.json")) {
            file.write(json.toString(4)); // El 4 es para indentar el JSON
            System.out.println("El archivo persona.json se ha creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
