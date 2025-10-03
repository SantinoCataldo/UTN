package Ej4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Colegio {
    private ArrayList<Alumnos> listadoAlumnos;

    public Colegio() {
        this.listadoAlumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumnos alumno) {
        try {
            if (alumno == null || alumno.nombre == null || alumno.nacionalidad == null || alumno.nacionalidad.isEmpty()) {
                throw new IllegalArgumentException("El alumno debe tener un nombre y una nacionalidad válida.");
            }
            listadoAlumnos.add(alumno);
            System.out.println("Alumno agregado: " + alumno.nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void verNacionalidad(String nacionalidad) {
        try {
            if (nacionalidad == null || nacionalidad.isEmpty()) {
                throw new IllegalArgumentException("La nacionalidad no puede estar vacía.");
            }
            int count = 0;
            for (Alumnos alumno : listadoAlumnos) {
                if (alumno.nacionalidad.equalsIgnoreCase(nacionalidad)) {
                    count++;
                }
            }
            System.out.println("Nacionalidad: " + nacionalidad + " - Número de alumnos: " + count);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void contNacionalidad() {
        try {
            if (listadoAlumnos.isEmpty()) {
                throw new IllegalStateException("No hay alumnos en el listado.");
            }

            HashSet<String> uniqueNationalities = new HashSet<>();
            for (Alumnos alumno : listadoAlumnos) {
                uniqueNationalities.add(alumno.nacionalidad);
            }
            System.out.println("Número de nacionalidades diferentes: " + uniqueNationalities.size());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void borrarAlumno(Alumnos alumno) {
        try {
            if (alumno == null || !listadoAlumnos.contains(alumno)) {
                throw new IllegalArgumentException("El alumno no existe en el listado.");
            }
            listadoAlumnos.remove(alumno);
            System.out.println("Alumno eliminado: " + alumno.nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void verTodos() {
        try {
            if (listadoAlumnos.isEmpty()) {
                throw new IllegalStateException("No hay alumnos en el listado.");
            }
            Map<String, Integer> nacionalidades = new HashMap<>();
            for (Alumnos alumno : listadoAlumnos) {
                nacionalidades.put(alumno.nacionalidad, nacionalidades.getOrDefault(alumno.nacionalidad, 0) + 1);
            }
            nacionalidades.forEach((nacionalidad, count) ->
                    System.out.println("Nacionalidad: " + nacionalidad + " - Número de alumnos: " + count));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}