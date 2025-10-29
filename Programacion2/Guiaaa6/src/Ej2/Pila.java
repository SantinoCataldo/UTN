package Ej2;

import java.util.ArrayList;

public class Pila<T> {
    private ArrayList<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public T quitar() {
        if (!estaVacia()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int tamanio() {
        return elementos.size();
    }
}
