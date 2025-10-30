import java.util.ArrayList;
import java.util.function.Predicate;

public class Contenedor<T> {
    private ArrayList<T> elementos;

    public Contenedor() {
        this.elementos = new ArrayList<>();
    }

    public void agregar(T elemento) throws ElementoDuplicadoEx {
        if (elementos.contains(elemento)) {
            throw new ElementoDuplicadoEx("El elemento ya existe en el repositorio");
        }
        elementos.add(elemento);
    }

    public boolean existe(Predicate<T> criterio) {
        return elementos.stream().anyMatch(criterio);
    }
}