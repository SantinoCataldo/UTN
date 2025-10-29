package Ej4;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombreBiblioteca;
    private List<Libro> libros;

    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void guardarJson() {
        JSONObject json = new JSONObject();
        json.put("nombreBiblioteca", nombreBiblioteca);

        JSONArray librosJson = new JSONArray();
        for (Libro libro : libros) {
            librosJson.put(libro.toJson());
        }
        json.put("libros", librosJson);

        try (FileWriter file = new FileWriter("biblioteca.json")) {
            file.write(json.toString(4));
            System.out.println("El archivo biblioteca.json se ha creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Biblioteca cargarDesdeJson(String archivo) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject json = new JSONObject(contenido);

            String nombreBiblioteca = json.getString("nombreBiblioteca");

            Biblioteca biblioteca = new Biblioteca(nombreBiblioteca);

            JSONArray librosJson = json.getJSONArray("libros");
            for (int i = 0; i < librosJson.length(); i++) {
                JSONObject libroJson = librosJson.getJSONObject(i);
                biblioteca.agregarLibro(Libro.fromJson(libroJson));
            }
            return biblioteca;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombreBiblioteca='" + nombreBiblioteca + '\'' +
                ", libros=" + libros +
                '}';
    }
}
