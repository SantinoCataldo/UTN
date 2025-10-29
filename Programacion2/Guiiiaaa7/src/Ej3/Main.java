package Ej3;

public class Main {
    public static void main(String[] args) {
        // Crear un curso y agregar personas
        Curso curso = new Curso("Programación 2", 101);
        curso.agregarInscripto(new Persona("Juan Perez", 30, "12345678A", "Masculino"));
        curso.agregarInscripto(new Persona("Maria Lopez", 25, "87654321B", "Femenino"));

        // Guardar el curso en un archivo JSON
        curso.guardarJson();

        // Cargar el curso desde el archivo JSON
        Curso cursoCargado = Curso.cargarDesdeJson("curso.json");
        if (cursoCargado != null) {
            System.out.println("Curso cargado desde curso.json:");
            System.out.println(cursoCargado);
        }
    }
}
