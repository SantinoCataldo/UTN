import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StarWarsRegistro<T extends Personaje> {
    private Set<T> registro;

    public StarWarsRegistro() {
        this.registro = new HashSet<>();
    }

    public void agregarPersonaje(T personaje) {
        registro.add(personaje);
    }

    public T obtenerPersonajePorNombre(String nombre) throws PersonajeNoEncontradoException {
        for (T personaje : registro) {
            if (personaje.getNombre().equals(nombre)) {
                return personaje;
            }
        }
        throw new PersonajeNoEncontradoException(nombre);
    }

    public void eliminarPersonaje(T personaje) {
        registro.remove(personaje);
    }

    public List<T> listarPersonajes() {
        return new ArrayList<>(registro);
    }

    public void limpiar() {
        registro.clear();
    }
}
