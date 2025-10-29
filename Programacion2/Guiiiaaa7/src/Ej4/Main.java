package Ej4;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // 1. Crear y guardar una biblioteca inicial
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        biblioteca.agregarLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien"));
        biblioteca.guardarJson();
        System.out.println("Biblioteca inicial guardada.");
        System.out.println("---------------------------------");

        try {
            // 2. Leer el archivo biblioteca.json en un JSONObject
            String contenido = new String(Files.readAllBytes(Paths.get("biblioteca.json")));
            JSONObject bibliotecaJson = new JSONObject(contenido);

            System.out.println("JSON cargado desde el archivo:");
            System.out.println(bibliotecaJson.toString(4));
            System.out.println("---------------------------------");

            // 3. Manipular el JSONObject directamente
            JSONArray librosJson = bibliotecaJson.getJSONArray("libros");

            // Eliminar el primer libro
            librosJson.remove(0);

            // Agregar un nuevo libro
            JSONObject nuevoLibro = new JSONObject();
            nuevoLibro.put("titulo", "1984");
            nuevoLibro.put("autor", "George Orwell");
            librosJson.put(nuevoLibro);

            System.out.println("JSON modificado:");
            System.out.println(bibliotecaJson.toString(4));
            System.out.println("---------------------------------");


            // 4. Guardar el JSONObject modificado de nuevo en el archivo
            try (FileWriter file = new FileWriter("biblioteca.json")) {
                file.write(bibliotecaJson.toString(4));
                System.out.println("El archivo biblioteca.json se ha actualizado correctamente.");
                System.out.println("---------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Cargar la biblioteca desde el archivo JSON modificado para verificar
        System.out.println("Cargando biblioteca final desde el archivo modificado...");
        Biblioteca bibliotecaFinal = Biblioteca.cargarDesdeJson("biblioteca.json");
        if (bibliotecaFinal != null) {
            System.out.println("Biblioteca final cargada:");
            System.out.println(bibliotecaFinal);
        }
    }
}
