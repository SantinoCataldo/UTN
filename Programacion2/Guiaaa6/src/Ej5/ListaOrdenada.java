package Ej5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaOrdenada<T> {
    private ArrayList<T> elementos = new ArrayList<>();
    private Comparator<T> comparador;

    public ListaOrdenada(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
        Collections.sort(elementos, comparador);
    }

    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    public T obtener(int posicion) {
        if (posicion >= 0 && posicion < elementos.size()) {
            return elementos.get(posicion);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ListaOrdenada{" +
                "elementos=" + elementos +
                '}';
    }
}
