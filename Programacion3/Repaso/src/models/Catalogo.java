package models;

import java.util.ArrayList;

public class Catalogo<T> {

    private ArrayList<T> elementos;

    public Catalogo() {
        this.elementos = new ArrayList<T>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }

    public int getCantidad() {
        return elementos.size();
    }

    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elementos.size(); i++) {
            sb.append(i + 1).append(". ").append(elementos.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}

