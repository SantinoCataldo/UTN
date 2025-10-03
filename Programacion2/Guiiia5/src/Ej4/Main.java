package Ej4;

public class Main {
    public static void main(String[] args) {
        Colegio colegio = new Colegio();

        colegio.agregarAlumno(new Alumnos("Juan", "Argentina"));
        colegio.agregarAlumno(new Alumnos("Maria", "Chile"));
        colegio.agregarAlumno(new Alumnos("Pedro", "Argentina"));
        colegio.agregarAlumno(new Alumnos("Ana", "Brasil"));

        colegio.verNacionalidad("Argentina");
        colegio.verNacionalidad("Chile");

        colegio.contNacionalidad();

        colegio.verTodos();

        colegio.borrarAlumno(new Alumnos("Maria", "Chile"));

        colegio.verTodos();
    }
}