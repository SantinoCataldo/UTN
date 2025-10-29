package Ej3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombreCurso;
    private int codigo;
    private List<Persona> inscriptos;

    public Curso(String nombreCurso, int codigo) {
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.inscriptos = new ArrayList<>();
    }

    public void agregarInscripto(Persona persona) {
        inscriptos.add(persona);
    }

    public void eliminarInscripto(Persona persona) {
        inscriptos.remove(persona);
    }

    public void guardarJson() {
        JSONObject json = new JSONObject();
        json.put("nombreCurso", nombreCurso);
        json.put("codigo", codigo);

        JSONArray inscriptosJson = new JSONArray();
        for (Persona persona : inscriptos) {
            inscriptosJson.put(new JSONObject(persona));
        }
        json.put("inscriptos", inscriptosJson);

        try (FileWriter file = new FileWriter("curso.json")) {
            file.write(json.toString(4));
            System.out.println("El archivo curso.json se ha creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Curso cargarDesdeJson(String archivo) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject json = new JSONObject(contenido);

            String nombreCurso = json.getString("nombreCurso");
            int codigo = json.getInt("codigo");

            Curso curso = new Curso(nombreCurso, codigo);

            JSONArray inscriptosJson = json.getJSONArray("inscriptos");
            for (int i = 0; i < inscriptosJson.length(); i++) {
                JSONObject personaJson = inscriptosJson.getJSONObject(i);
                String nombre = personaJson.getString("nombre");
                int edad = personaJson.getInt("edad");
                String dni = personaJson.getString("dni");
                String sexo = personaJson.getString("sexo");
                curso.agregarInscripto(new Persona(nombre, edad, dni, sexo));
            }
            return curso;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombreCurso='" + nombreCurso + '\'' +
                ", codigo=" + codigo +
                ", inscriptos=" + inscriptos +
                '}';
    }
}
