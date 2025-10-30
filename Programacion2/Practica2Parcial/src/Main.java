import java.util.List;

public class Main {

    public static void main(String[] args) {
        String json = JsonUtiles.leer("archivo");
        StarWarsRegistro<Personaje> registro = new StarWarsRegistro<>();

        try {
            // 1. Parsear el JSON y obtener la lista de personajes
            List<Personaje> personajes = StarWarsJsonParser.parsePersonajes(json);

            // 2. Agregar los personajes al registro
            for (Personaje personaje : personajes) {
                registro.agregarPersonaje(personaje);
            }

            // 3. Probar la funcionalidad del registro
            System.out.println("Personajes en el registro:");
            registro.listarPersonajes().forEach(System.out::println);

            // 4. Guardar y mostrar las naves
            ArchivoBinario.guardarNaves(registro, "naves.dat");
            ArchivoBinario.mostrarNaves("naves.dat");

            // 5. Probar la búsqueda y eliminación
            System.out.println("\nBuscando a Luke Skywalker...");
            Personaje luke = registro.obtenerPersonajePorNombre("Luke Skywalker");
            System.out.println("Encontrado: " + luke);

            System.out.println("\nEliminando a Luke Skywalker...");
            registro.eliminarPersonaje(luke);

            System.out.println("\nPersonajes después de eliminar a Luke:");
            registro.listarPersonajes().forEach(System.out::println);

            // 6. Probar la excepción personalizada
            System.out.println("\nIntentando buscar a un personaje que no existe...");
            try {
                registro.obtenerPersonajePorNombre("Jar Jar Binks");
            } catch (PersonajeNoEncontradoException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
