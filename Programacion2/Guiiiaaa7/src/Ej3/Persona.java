package Ej3;

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void guardarJson() {
        JSONObject json = new JSONObject(this);
        try (FileWriter file = new FileWriter("persona.json")) {
            file.write(json.toString(4));
            System.out.println("El archivo persona.json se ha creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Persona cargarDesdeJson(String archivo) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject json = new JSONObject(contenido);
            String nombre = json.getString("nombre");
            int edad = json.getInt("edad");
            String dni = json.getString("dni");
            String sexo = json.getString("sexo");
            return new Persona(nombre, edad, dni, sexo);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
