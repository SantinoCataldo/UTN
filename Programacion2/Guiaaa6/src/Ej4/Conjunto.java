package Ej4;

import java.util.HashSet;

public class Conjunto<T> {
    private HashSet<T> elementos = new HashSet<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "elementos=" + elementos +
                '}';
    }
}
