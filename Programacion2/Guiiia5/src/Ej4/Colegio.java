package Ej4;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Colegio {
    private ArrayList<Alumnos> listadoAlumnos;

    public Colegio() {
        this.listadoAlumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumnos alumno) throws AlumnoInvalidoException {
        if (alumno == null || alumno.getNombre() == null || alumno.getNombre().trim().isEmpty()
                || alumno.getNacionalidad() == null || alumno.getNacionalidad().trim().isEmpty()) {
            throw new AlumnoInvalidoException("El alumno y sus datos (nombre, nacionalidad) no pueden ser nulos o vacíos.");
        }
        listadoAlumnos.add(alumno);
        System.out.println("Alumno agregado: " + alumno.getNombre());
    }

    public void verNacionalidad(String nacionalidad) throws AlumnoInvalidoException {
        if (nacionalidad == null || nacionalidad.trim().isEmpty()) {
            throw new AlumnoInvalidoException("La nacionalidad no puede ser nula o vacía.");
        }

        long count = listadoAlumnos.stream()
                .filter(alumno -> alumno.getNacionalidad().equalsIgnoreCase(nacionalidad))
                .count();

        System.out.println("Nacionalidad: " + nacionalidad + " - Número de alumnos: " + count);
    }

    // Renombrado de contNacionalidad a cuantos() según el requerimiento
    public void cuantos() throws ColegioVacioException {
        if (listadoAlumnos.isEmpty()) {
            throw new ColegioVacioException("No hay alumnos en el listado para contar nacionalidades.");
        }

        long count = listadoAlumnos.stream()
                .map(Alumnos::getNacionalidad)
                .distinct()
                .count();

        System.out.println("Número de nacionalidades diferentes: " + count);
    }

    // Renombrado de borrarAlumno a borrar() según el requerimiento
    public void borrar(Alumnos alumno) throws AlumnoNoEncontradoException, AlumnoInvalidoException {
        if (alumno == null) {
            throw new AlumnoInvalidoException("El alumno a borrar no puede ser nulo.");
        }
        if (!listadoAlumnos.remove(alumno)) {
            throw new AlumnoNoEncontradoException("El alumno " + alumno.getNombre() + " no existe en el listado.");
        }
        System.out.println("Alumno eliminado: " + alumno.getNombre());
    }

    public void verTodos() throws ColegioVacioException {
        if (listadoAlumnos.isEmpty()) {
            throw new ColegioVacioException("No hay alumnos en el listado para mostrar.");
        }

        Map<String, Long> nacionalidades = listadoAlumnos.stream()
                .collect(Collectors.groupingBy(Alumnos::getNacionalidad, Collectors.counting()));

        nacionalidades.forEach((nacionalidad, count) ->
                System.out.println("Nacionalidad: " + nacionalidad + " - Alumnos: " + count));
    }
}